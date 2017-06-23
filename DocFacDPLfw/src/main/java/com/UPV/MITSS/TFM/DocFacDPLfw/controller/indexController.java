/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    
    @GetMapping("/index")
    public String index(){
        return LOGIN_VEIW;
    }
    
    @GetMapping("/registration")
    public String registration(){
        return REG_VEIW;
    }
    
    @GetMapping("/home")
    public String home(){
        return HOME_VEIW;
    }
}
 