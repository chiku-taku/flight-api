package com.example.demo.service;

import com.example.demo.mapper.UserinfoMapper;
import com.example.demo.model.Userinfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	
    private final UserinfoMapper userRepository;

    public CustomUserDetailsService(UserinfoMapper userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库加载用户
        Optional<Userinfo> userOptional = Optional.ofNullable(userRepository.selectByPrimaryKey(username));
        Userinfo user = userOptional.orElseThrow(() -> 
            new UsernameNotFoundException("User not found with username: " + username)
        );

        // 确保权限集合不为null
        List<GrantedAuthority> authorities = Collections.emptyList();
        
        // 创建 Spring Security 的 UserDetails 对象
        return new org.springframework.security.core.userdetails.User(
            user.getUserId(),
            user.getPassword(),
            true,  // 账户未过期
            true,  // 凭证未过期
            true,  // 账户未锁定
            true,  // 账户可用
            //mapRolesToAuthorities(user.getRole())  // 映射角色到权限
            authorities
        );
    }

    // 将角色转换为权限集合
    @SuppressWarnings("unused")
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(String role) {
        // 确保角色前缀为 "ROLE_"（Spring Security 默认要求）
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
    }
}