/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.service.impl;

import com.UPV.MITSS.TFM.DocFacDPLfw.repository.RoleJpaRepository;
import com.UPV.MITSS.TFM.DocFacDPLfw.repository.UserJpaRepository;
import java.util.Enumeration;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;
/**
 *
 * @author S
 */
@Service("remembermeService")
public class RememberMeServicesImpl implements RememberMeServices,AuthenticationManager{

    @Autowired
    @Qualifier("userServiceImpl")
    private UserServiceImpl userService;
    
    @Autowired
    @Qualifier("userJpaRepository")
    private UserJpaRepository userRepo;
    
    @Autowired
    @Qualifier("roleJpaRepository")
    private RoleJpaRepository userRole;
    
    @Override
    public Authentication autoLogin(HttpServletRequest hsr, HttpServletResponse hsr1) {
        for(Cookie cookie : hsr.getCookies())
            if(cookie.getName().equals("rememberme")){
                UserDetails user = userService.loadUserByUsername(cookie.getValue());
                
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
                hsr.getSession();

                token.setDetails(new WebAuthenticationDetails(hsr));
                Authentication authenticatedUser = this.authenticate(token);
                
                SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
            }
        return  SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public void loginFail(HttpServletRequest hsr, HttpServletResponse hsr1) {
        // TO-DO (By the moment no block)
    }

    @Override
    public void loginSuccess(HttpServletRequest hsr, HttpServletResponse hsr1, Authentication a) {
        
        Enumeration<String> params = hsr.getParameterNames();
        boolean exist = false;
        while(params.hasMoreElements()){
            if(params.nextElement().equals("rememberme"))
            exist = true;
        }
        
        if(exist){
            if(hsr.getParameter("rememberme").equals("remember-me")){
                Cookie cookie = new Cookie("rememberme",hsr.getParameter("email"));
                hsr1.addCookie(cookie);
            }
        }else{
            Cookie[] cookies = hsr.getCookies();
            for(Cookie c : cookies){
                if(c.getName().equals("rememberme")){
                    c.setMaxAge(0);
                    hsr1.addCookie(c);
                }
            }
        }
    }

    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
        
        String username = a.getPrincipal() + "";
        String password = a.getCredentials() + "";
        
        User user = (User)userService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
        
    }
}
