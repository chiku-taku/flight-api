package com.example.demo.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author l
 */
@Data
@Accessors(chain = true)
public class JwtUser {

    private boolean valid;
    private String userId;
    private String role;
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
  
    
}
