package com.mysite.demo.app.recipeat.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user")
public class UserCredential {
	@Id
	private Long user_id;

	private String username;
	private String password;
	private String email;
	private UserRole role;

	public UserCredential() {
	}

	public UserCredential(String username, String password, String email, UserRole role) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}
}
