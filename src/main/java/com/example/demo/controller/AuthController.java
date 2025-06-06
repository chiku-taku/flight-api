package com.example.demo.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserTokenResult;
import com.example.demo.model.Userinfo;
import com.example.demo.security.PasswordEncoder;
import com.example.demo.service.JwtService;
//import com.example.demo.security.TokenProvider;
import com.example.demo.service.RegisterService;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;

@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173") // 允许React前端跨域访问
@RestController
public class AuthController {

	@Resource
	private RegisterService registerService;

	@Resource
	private JwtService jwtService;

	@PostMapping("/login")
	public UserTokenResult login(@RequestBody Userinfo userDto, HttpServletResponse response)
			throws IllegalAccessException, InvocationTargetException {

		String userId = userDto.getUserId();
		// 从数据库获取用户信息
		Userinfo dbUser = registerService.getUserInfoByKey(userId);

		UserTokenResult result = new UserTokenResult();
		if (PasswordEncoder.matches(userDto.getPassword(), dbUser.getPassword())) {
			// 模拟一个用户的数据 用户id为1 登录端为网页web 角色是admin
			String name = dbUser.getFirstName() + dbUser.getLastName();
			String email = dbUser.getEmail();
			result.setEmail(email);
			result.setName(name);
			result.setUserId(userId);
			result.setToken(jwtService.generateToken(loadUserByUsername(userId, dbUser.getPassword())));
			result.setIslogin(true);
			return result;
		}
		result.setIslogin(false);
		return result;
	}

	@PostMapping("/register")
	public String register(@RequestBody Userinfo request) {

		// 对密码进行加密
		String encoderPassword = PasswordEncoder.encode(request.getPassword());
		request.setPassword(encoderPassword);

		// 调用服务层保存用户信息
		Integer rowNum = registerService.setUserInfo(request);

		// 修正返回逻辑：插入成功返回success，失败返回fails
		if (rowNum == 1) {
			return "success";
		} else {
			return "fails";
		}

	}

	public UserDetails loadUserByUsername(String userid, String password) throws UsernameNotFoundException {

		// 将数据库用户转换为 UserDetails
		return new org.springframework.security.core.userdetails.User(userid, password, true, // 是否启用
				true, // 账号是否未过期
				true, // 密码是否未过期
				true, // 账号是否未锁定
				mapRolesToAuthorities("ADMIN") // 用户角色
		);
	}

	// 将角色转换为权限
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(String role) {
		return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
	}
}