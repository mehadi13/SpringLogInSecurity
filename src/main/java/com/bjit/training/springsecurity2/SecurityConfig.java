package com.bjit.training.springsecurity2;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	throws Exception {
	auth
	.inMemoryAuthentication()
	.withUser("admin").password("password").roles("USER", "ADMIN");
	/*.withUser("user").password("password").roles("USER").and()*/
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	/*http
	.authorizeRequests()
	.antMatchers("/admin").hasAuthority("ROLE_ADMIN")
	.anyRequest().permitAll();*/
		
		http
		.authorizeRequests()
		.antMatchers("/admin").access("hasRole('ADMIN')")
		.anyRequest().permitAll()
		.and()
		.formLogin()
		.loginPage("/login")
		.usernameParameter("username")
		.passwordParameter("password")
		/*.loginProcessingUrl("/loginprocess")*/
		.defaultSuccessUrl("/admin")
		.failureUrl("/login?error=true");
	}
}