package com.nemeros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.csrf().disable();
		http
            .authorizeRequests()
            .antMatchers("/webjars/**","/static/**")
            .permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login")
                .passwordParameter("password")
                .usernameParameter("user")
                .defaultSuccessUrl("/greeting")
                .loginProcessingUrl("/loginProcess")
                .permitAll()
            .and()
            .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
		http.csrf().csrfTokenRepository(csrfTokenRepository());
    }
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
                   .withUser("user").password("123").roles("USER");
	}
	
	private CsrfTokenRepository csrfTokenRepository() {
	  HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
	  repository.setHeaderName("X-XSRF-TOKEN");
	  return repository;
	}
}
