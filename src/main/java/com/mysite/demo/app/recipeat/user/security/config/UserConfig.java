package com.mysite.demo.app.recipeat.user.security.config;

import com.mysite.demo.app.recipeat.user.entity.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserConfig {

	private String USER = String.valueOf(UserRole.USER);
	private String ADMIN = String.valueOf(UserRole.ADMIN);


		@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer ->
				configurer
						.requestMatchers(HttpMethod.GET, "/api/getUsers")
						.hasRole(USER)
						.requestMatchers(HttpMethod.POST, "/api/register")
						.hasRole(ADMIN));

			// use HTTP Basic authentication
			http.httpBasic(Customizer.withDefaults());

			// disable Cross Site Request Forgery (CSRF)
			// in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
			http.csrf(csrf -> csrf.disable());

			return http.build();
	}
}
