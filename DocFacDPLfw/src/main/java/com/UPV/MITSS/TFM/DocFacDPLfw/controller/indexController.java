/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.controller;

import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.User;
import com.UPV.MITSS.TFM.DocFacDPLfw.service.RegistrationService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Salvador Puertes Aleixandre
 */

@Controller
@RequestMapping("")
public class indexController {
    
    public static final String LOGIN_VEIW = "index";
    public static final String HOME_VEIW = "home";
    public static final String REG_VEIW = "registration";
    public static final String REG_OK_VEIW = "registering";
    
    @GetMapping("/")
    public String index(){
        return LOGIN_VEIW;
    }    
    
//  REIDRECCIONAR    
//    @GetMapping("/")
//    public RedirectView redirect(){
//        return new RedirectView("/index");
//    }
    
    @GetMapping("/registration")
    public ModelAndView registration(){
        ModelAndView mav = new ModelAndView(REG_VEIW);
        mav.addObject("user", new User());
        return mav;
    }
    
    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
        ModelAndView mav = new ModelAndView();
        if(bindingResult.hasErrors()){
            mav.setViewName(REG_VEIW);
        }else{
            System.out.println("fALSE IF BEFORE");
            mav.setViewName(REG_OK_VEIW);
            System.out.println("FALSE IF After");
            mav.addObject("user", user);
        }
        return mav;
    }
    
    @GetMapping("/home")
    public String home(){
        return HOME_VEIW;
    }
    
    @Autowired
    @Qualifier("registrationService")
    private RegistrationService register;
}
 