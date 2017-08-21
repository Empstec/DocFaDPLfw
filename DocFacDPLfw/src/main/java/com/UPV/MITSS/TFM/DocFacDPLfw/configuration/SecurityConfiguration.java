/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.configuration;

import com.UPV.MITSS.TFM.DocFacDPLfw.service.impl.RememberMeServicesImpl;
import com.UPV.MITSS.TFM.DocFacDPLfw.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author S
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    
    @Autowired
    @Qualifier("userServiceImpl")
    private UserServiceImpl userService;
    
    @Autowired
    @Qualifier("remembermeService")
    private RememberMeServicesImpl rememberMeServices;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/css/**","/images/**","/fonts/**","/font-awesome/**","/js/**","/bs3/**","/bucket-ico-fonts/**","/favicon.ico","/registration","/register").permitAll().anyRequest().authenticated()
                .and().formLogin().loginPage("/").loginProcessingUrl("/login").usernameParameter("email").passwordParameter("password").defaultSuccessUrl("/home/").permitAll()
                .and().rememberMe().rememberMeParameter("rememberme").rememberMeServices(rememberMeServices)
                .and().logout().logoutUrl("/logout").deleteCookies("remeberme").logoutSuccessUrl("/");
        super.configure(http);
    }
}