package com.digitate.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// All Req should authenticated
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		
		// If a request is not authenticated, a web page is show
		http.httpBasic(withDefaults());
		
		// CSRF -> POST
		http.csrf().disable();
		
		return http.build();
		
	}
	
}
