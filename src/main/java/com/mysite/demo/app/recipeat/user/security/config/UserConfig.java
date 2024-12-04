package com.mysite.demo.app.recipeat.user.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class UserConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(configurer ->
						configurer
								.requestMatchers(HttpMethod.GET, "/", "/recipes/**", "/category/**").permitAll()
								.requestMatchers(HttpMethod.POST, "/", "/recipes/**", "/category/**").permitAll()
//			Authenticate the user
								.requestMatchers(HttpMethod.GET, "/api/**").authenticated()
								.requestMatchers(HttpMethod.POST, "/api/**").authenticated()
								.requestMatchers(HttpMethod.PUT, "/api/**").authenticated()
								.requestMatchers(HttpMethod.DELETE, "/api/**").authenticated()
								.anyRequest().authenticated()
		).formLogin(form ->
				form
						.loginPage("/showMyLoginPage")
						.loginProcessingUrl("/authenticateTheUser")
						.permitAll()
		).logout(logout -> logout.permitAll()
		);
		return http.build();
	}

	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
// define query to retrieve a user by username
		jdbcUserDetailsManager.setUsersByUsernameQuery(
				"select username, password, active from user where username=?");
// define query to retrieve the authorities/roles by username
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
				"select username, role from authorities where username=?");

		return jdbcUserDetailsManager;
	}
}
