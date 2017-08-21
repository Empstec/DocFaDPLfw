/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.service.impl;

import java.util.Enumeration;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.stereotype.Service;
/**
 *
 * @author S
 */
@Service("remembermeService")
public class RememberMeServicesImpl implements RememberMeServices{

    @Autowired
    @Qualifier("userServiceImpl")
    private UserServiceImpl userService;
    
    @Override
    public Authentication autoLogin(HttpServletRequest hsr, HttpServletResponse hsr1) {
        // TO-DO
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public void loginFail(HttpServletRequest hsr, HttpServletResponse hsr1) {
        // TO-DO
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
}
