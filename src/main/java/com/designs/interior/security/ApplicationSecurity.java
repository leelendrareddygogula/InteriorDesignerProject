package com.designs.interior.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ApplicationSecurity 
{
	@Bean
	public BCryptPasswordEncoder cryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService getDetailsService() {
		return new CustomUserDetailsService();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(getDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(cryptPasswordEncoder());
		return daoAuthenticationProvider;
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http.csrf().disable().authorizeHttpRequests()
		.antMatchers("/", "/home", "/checkdesigner", 
				"/customer/quotation/**", "/images/**", 
				"/image/**", "/customer/**", "/builtBy",
				"/css/**", "/images/**", "/js/**", "/logo.png", 
				"/superuser/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/checkdesigner").loginProcessingUrl("/designer")
//		.usernameParameter("username")
		.defaultSuccessUrl("/designer/designerHome").permitAll()
		.failureUrl("/loginErrorControl?error=true")
		.and()
		.logout().logoutUrl("/logout")
		.logoutSuccessUrl("/logoutSuccessfull?error=false").permitAll();
		
		return http.build();
	}
}