package com.avantsystems.integrator.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSec) throws Exception {

        httpSec.csrf().disable();
        httpSec
                .authorizeRequests()
                .antMatchers("/","/login","/logout","/about").permitAll();

        //pages that requires USER and ADMIN roles
        httpSec.authorizeRequests().antMatchers("/user").access("hasAnyRole('USER', 'ADMIN')");

        httpSec.authorizeRequests().antMatchers("/dashboard").hasAnyRole("USER","ADMIN");

        //pages that requires ADMIN role
        httpSec.authorizeRequests().antMatchers("/admin").hasAuthority("ADMIN");

        //httpSec.authorizeRequests().antMatchers(HttpMethod.GET,"/admin").hasAuthority("");

        //when an authorized user tries accessing a page outside his/her policy, render access denied
        //httpSec.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");


        httpSec.authorizeRequests()
                //configure login page
                .and()
                .formLogin().defaultSuccessUrl("/dashboard")
                //.permitAll()
                //.loginPage("/login")

                //configure logout
                .and()
                .logout();
                //.permitAll();
                //.logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        System.out.println("Authen...");


        auth.inMemoryAuthentication()
                .withUser("joshua@avantsystems.com.au").password("{noop}password").roles("USER")
                .and()
                .withUser("admin@avantsystems.com.au").password("{noop}password").roles("ADMIN")
                .and()
                .withUser("info@avantsystems.com.au").password("{noop}password").roles("USER");



    }



}
