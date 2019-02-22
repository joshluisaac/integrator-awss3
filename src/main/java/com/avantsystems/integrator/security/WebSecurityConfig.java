package com.avantsystems.integrator.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSec) throws Exception {

        httpSec.csrf().disable();
        httpSec.authorizeRequests().antMatchers("/","/login","/logout","/user").permitAll();

        //pages that requires USER and ADMIN roles
        httpSec.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

        //pages that requires ADMIN role
        httpSec.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");

        //when an authorized user tries accessing a page outside his/her policy, render access denied
        httpSec.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");


        httpSec.authorizeRequests().and().formLogin()
                .loginPage("/login")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
    }



}
