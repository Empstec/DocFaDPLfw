/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.controller;

import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.UserModel;
import com.UPV.MITSS.TFM.DocFacDPLfw.service.UserService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Salvador Puertes Aleixandre
 */
@Controller
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/home")
public class appController {
    
    public static final String HOME_VEIW = "home";
    public static final String CREATE_VEIW = "create";
    public static final String PROFILE_VEIW = "profile";
    
    @Autowired
    private HttpSession httpSession;
    
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    
    @GetMapping("/")
    public ModelAndView loginValidate(@CookieValue(value="rememberme", required=false) String cookie){
        ModelAndView mav = new ModelAndView(HOME_VEIW);
        
        com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.UserModel cModelUser;
        
        if(cookie == null){
            User currentUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // Usuario Actual
            cModelUser = userService.getUser(currentUser.getUsername());
        }else{
            cModelUser = userService.getUser(cookie);
        }
        
        httpSession.setAttribute("currentUser", cModelUser);
        
        mav.addObject("user",cModelUser);
        
        return mav;
    }
    
    @GetMapping("/create")
    public ModelAndView createDocument(){
        ModelAndView mav = new ModelAndView(CREATE_VEIW);
        
        return mav;
    }
    
    @GetMapping("/profile")
    public ModelAndView profile(){
        
        ModelAndView mav = new ModelAndView(PROFILE_VEIW);
        mav.addObject("user",userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName()));
        return mav;
    }
    
    @PostMapping("/saveProfile")
    public ModelAndView saveProfileChanges(@Valid @ModelAttribute("user") UserModel user, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            userService.updateUser(user);
        }
        return new ModelAndView(PROFILE_VEIW);
    }
}
