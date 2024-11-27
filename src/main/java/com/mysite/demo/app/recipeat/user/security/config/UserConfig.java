package com.mysite.demo.app.recipeat.user.security.config;

import com.mysite.demo.app.recipeat.user.entity.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserConfig {

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final String USER = String.valueOf(UserRole.USER);
	private final String MANAGER = String.valueOf(UserRole.MANAGER);
	private final String ADMIN = String.valueOf(UserRole.ADMIN);

	public UserConfig(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails dimitris = User.builder()
				.username("dimitris")
				.password(bCryptPasswordEncoder.encode("100200300"))
				.roles(USER)
				.build();

		UserDetails george = User.builder()
				.username("george")
				.password(bCryptPasswordEncoder.encode("100200300"))
				.roles(USER, MANAGER)
				.build();

		UserDetails mary = User.builder()
				.username("mary")
				.password(bCryptPasswordEncoder.encode("test123"))
				.roles(USER, MANAGER, ADMIN)
				.build();

		return new InMemoryUserDetailsManager(dimitris, mary, george);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(configurer ->
				configurer
						.requestMatchers(HttpMethod.GET, "/api/getUsers").hasRole(USER)
						.requestMatchers(HttpMethod.POST, "/api/registerUser").hasRole(MANAGER)
						.requestMatchers(HttpMethod.PUT, "/api//updateUser/**").hasRole(MANAGER)
						.requestMatchers(HttpMethod.DELETE, "/api/deleteUser/**").hasRole(ADMIN)
		);
		// use HTTP Basic authentication
		http.httpBasic(Customizer.withDefaults());

		// disable Cross Site Request Forgery (CSRF)
		// not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
		http.csrf(csrf -> csrf.disable());

		return http.build();
	}
}
