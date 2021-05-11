package net.itbs.spring.data.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	  @Override protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
		  auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("USER","ADMIN");
		  auth.inMemoryAuthentication().withUser("roua").password("{noop}123").roles("USER");
		  }
	  
	  @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin(); //.loginPage(url) crée votre formulaire 
		http.authorizeRequests().antMatchers("/","/produit").permitAll();
		http.authorizeRequests().antMatchers("/user/*").hasRole("USER");
		http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
		
		http.exceptionHandling().accessDeniedPage("/403"); 
	}
	  
	 
}
