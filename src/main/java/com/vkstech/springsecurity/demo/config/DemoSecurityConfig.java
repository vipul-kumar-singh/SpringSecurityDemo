package com.vkstech.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Add our users for in memory authentication
		
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		UserBuilder users = User.builder();
		
		auth.inMemoryAuthentication()
		.withUser(users.username("john").password(encoder.encode("test123")).roles("EMPLOYEE"))
		.withUser(users.username("mary").password(encoder.encode("test123")).roles("MANAGER"))
		.withUser(users.username("susan").password(encoder.encode("test123")).roles("ADMIN"));
		
	}

}
