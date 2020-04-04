package com.c2s.loginservice.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.c2s.loginservice.service.MyUserDetailsService;
import com.c2s.loginservice.service.RabbitMQListner;

@Configuration

public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	
    
	
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	  System.out.println("in");
		/*
		 * http. authorizeRequests() .antMatchers("/").permitAll()
		 * .antMatchers("/login").permitAll()
		 * .antMatchers("/registration/user").permitAll()
		 * .antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
		 * .authenticated().and().csrf().disable().formLogin()
		 * .loginPage("/login").failureUrl("/login?error=true")
		 * .defaultSuccessUrl("/admin/home") .usernameParameter("user_name")
		 * .passwordParameter("password") .and().logout() .logoutRequestMatcher(new
		 * AntPathRequestMatcher("/logout"))
		 * .logoutSuccessUrl("/login").and().exceptionHandling()
		 * .accessDeniedPage("/access-denied"); System.out.println("inout");
		 */ 
	  
	  http.csrf().disable()
      .authorizeRequests()
      .antMatchers("/registration/user").permitAll()
      .anyRequest()
      .authenticated()
      .and()
      .httpBasic();
	  System.out.println("out");
	  }
	 
	 
	/*
	 * @Override public void configure(WebSecurity web) throws Exception { web
	 * .ignoring() .antMatchers("/resources/**", "/System.out.println("in");System.out.println("in");System.out.println("in");System.out.println("in");System.out.println("in");System.out.println("in");System.out.println("in");System.out.println("in");System.out.println("in");static/**", "/css/**", "/js/**",
	 * "/images/**"); }
	 */

}
