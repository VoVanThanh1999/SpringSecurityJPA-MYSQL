package com.svda.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.svda.service.CustomUserDetailsService;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends  WebSecurityConfigurerAdapter{
	@Autowired
	CustomUserDetailsService userDetailsService;
	
	@Bean
	protected BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder());
    }
	
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
	    http.csrf().disable();
	    http.authorizeRequests().antMatchers("login","logout").permitAll();
	    http.authorizeRequests().antMatchers("/home").access("hasAnyRole('ROLE_ADMIN','ROLE_USER')");
	    http.authorizeRequests().
		antMatchers("/admin").access("hasRole('ROLE_ADMIN')");
	    http.formLogin();
	 }
	 
	
}
