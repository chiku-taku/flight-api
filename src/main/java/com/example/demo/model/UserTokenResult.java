package com.example.demo.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author l
 */
@Data
@Accessors(chain = true)
public class UserTokenResult {

    private String token;
    private String userId;
    private String name;
    private String email;
    private boolean islogin;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isIslogin() {
		return islogin;
	}
	public void setIslogin(boolean islogin) {
		this.islogin = islogin;
	}

    
  
    
}
