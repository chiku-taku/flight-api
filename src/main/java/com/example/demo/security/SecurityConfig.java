// src/main/java/com/example/flight/security/SecurityConfig.java
package com.example.demo.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.service.CustomUserDetailsService;
import com.example.demo.service.JwtService;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
@Configuration
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;
    

    @Autowired
    private JwtService jwtService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // 禁用CSRF保护（适用于REST API）
            .sessionManagement(session -> 
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 使用无状态会话
            )
            .authorizeHttpRequests(authorize -> 
                authorize
                    .requestMatchers("/api/auth/**", "/api/flights/searchRound","/api/flights/searchSingle","/api/booking/**").permitAll() // 公开端点
                    .anyRequest().authenticated() // 其他请求需要认证
            )
            .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class); // 添加JWT过滤器
        

        return http.build();
    }

    // 配置密码编码器
    @Bean
    public PasswordEncoder passwordEncoder() {
    	System.out.println("Creating BCryptPasswordEncoder Bean"); // 用于调试确认
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
    
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder()); // 设置密码编码器
    }
   
    private Filter jwtAuthenticationFilter() {
        return new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, 
                                            HttpServletResponse response, 
                                            FilterChain filterChain) throws ServletException, IOException {
                // 从请求头中获取 Authorization 字段
                final String authHeader = request.getHeader("Authorization");
                final String jwt;
                final String username;

                // 解析令牌（示例逻辑，需根据实际调整）
                if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                    filterChain.doFilter(request, response);
                    return;
                }
                jwt = authHeader.substring(7); // 去除 "Bearer " 前缀
                username = jwtService.extractUsername(jwt); // 从 JWT 中提取用户名

                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    // 验证 JWT 有效性并创建认证对象
                    if (jwtService.isTokenValid(jwt, username)) {
                        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                        );
                        SecurityContextHolder.getContext().setAuthentication(authToken);
                    }
                }
                filterChain.doFilter(request, response);
            }
        };}
}