package com.trabalho.casadeshow.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.
		   csrf().disable().
		    authorizeRequests()
		    
		    .antMatchers("/").hasAnyRole("ADMIN","USER")
		    .antMatchers("/h2").permitAll()
		    .antMatchers("/console/**").permitAll()
		    .antMatchers("/casasdeshow").hasRole("ADMIN")
		    .antMatchers("/eventos").hasRole("ADMIN")
		    .antMatchers("/historico").hasAnyRole("ADMIN","USER")
		    .antMatchers("/cadastro").permitAll()
		    .antMatchers("/api/**").permitAll()
		    .antMatchers("/swagger-ui.html#/").permitAll()
		    
		    .anyRequest()
		    .authenticated()
		.and()
		    .formLogin()
		    .loginPage("/login")
		    .permitAll()
		.and()
		   .logout()
		   .logoutSuccessUrl("/login?logout")
		   .permitAll();	
	}
	
	public void configure(WebSecurity config) throws Exception{
		config.ignoring()
        .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/console/**");
	}
	

	
	@Bean
	public AuthenticationProvider authProvider() {
	
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
		
	}
	
}
