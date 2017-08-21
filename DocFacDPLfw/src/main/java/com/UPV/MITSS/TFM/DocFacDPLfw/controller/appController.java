/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.controller;

import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.UserModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author S
 */
@Controller
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/home")
public class appController {
    
    public static final String HOME_VEIW = "home";
    public static final String CREATE_VEIW = "create";
    
    @GetMapping("/")
    public ModelAndView loginValidate(){
        ModelAndView mav = new ModelAndView(HOME_VEIW);
        
        User currentUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // Usuario Actual
        
        return mav;
    }
    
    @GetMapping("/create")
    public ModelAndView createDocument(){
        ModelAndView mav = new ModelAndView(CREATE_VEIW);
        
        User currentUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // Usuario Actual
        
        return mav;
    }
}
