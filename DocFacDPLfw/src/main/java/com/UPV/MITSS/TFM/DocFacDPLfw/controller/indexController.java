/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.controller;

import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.UserModel;
import com.UPV.MITSS.TFM.DocFacDPLfw.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Salvador Puertes Aleixandre
 */

@Controller
public class indexController {
    
    public static final String LOGIN_VEIW = "index";
    public static final String HOME_VEIW = "home";
    public static final String REG_VEIW = "registration";
    public static final String REG_OK_VEIW = "registering";
    
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    
    @GetMapping({"/","/index"})
    public ModelAndView index(@RequestParam(name="error",required=false) String error){
        ModelAndView mav = new ModelAndView(LOGIN_VEIW);
        // Revisar sesion/cookkies per a auto loggin
        mav.addObject("error", error);
        mav.addObject("user", new UserModel());
        return mav;
    }    
    
    //@PreAuthorize("hasSole('ROLE_USER')") // Page 403
    @GetMapping("/home")
    public ModelAndView loginValidate(){
        ModelAndView mav = new ModelAndView(HOME_VEIW);
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // Usuario Actual
        // If check rememver poner en sesion
        return mav;
    }
    
    
    @GetMapping("/registration")
    public ModelAndView registration(){
        ModelAndView mav = new ModelAndView(REG_VEIW);
        mav.addObject("user", new UserModel());
        return mav;
    }
    
    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute("user") UserModel user, BindingResult bindingResult){
        ModelAndView mav = new ModelAndView();
        if(bindingResult.hasErrors()){
            mav.setViewName(REG_VEIW);
            mav.addObject("repited","repited");
        }else{
            BCryptPasswordEncoder pwd = new BCryptPasswordEncoder();
            mav.setViewName(REG_OK_VEIW);
            user.setPassword(pwd.encode(user.getPassword()));
            userService.addUser(user);
        }
        return mav;
    }
}