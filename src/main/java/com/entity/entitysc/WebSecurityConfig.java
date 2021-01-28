/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.entitysc;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author Brian A. Okon - bokon@entitysc.com
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/contact/**").permitAll()
                .antMatchers("/css/**", "/images/**", "/js/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/e-voting/").loginProcessingUrl("/e-voting/logins")
                .defaultSuccessUrl("/home/client-dashboard", true)
                .failureForwardUrl("/auth/login?error=true")
                .and()
                .logout().logoutSuccessUrl("/auth/logout")
                .deleteCookies("JSESSIONID")
                .and()
                .csrf().disable();
    }

}
