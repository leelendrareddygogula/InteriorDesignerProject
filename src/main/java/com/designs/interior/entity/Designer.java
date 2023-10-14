package com.designs.interior.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "designerDetails")
public class Designer 
{
	@Id
	@Column(length = 100)
	private String username;
	@Column(nullable = false, unique = false, length = 100)
	private String password;
	@Column(nullable = false, unique = false, length = 50)
	private String role;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
