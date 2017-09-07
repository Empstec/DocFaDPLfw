/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.controller;

import static com.UPV.MITSS.TFM.DocFacDPLfw.controller.appController.HOME_VEIW;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.DocumentModel;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.UserModel;
import com.UPV.MITSS.TFM.DocFacDPLfw.service.impl.RememberMeServicesImpl;
import com.UPV.MITSS.TFM.DocFacDPLfw.service.impl.UserServiceImpl;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
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
    public static final String LOGOUT_VEIW = "logout";
    public static final String REG_VEIW = "registration";
    public static final String REG_OK_VEIW = "registering";
    
    @Autowired
    private HttpSession httpSession;
    
    @Autowired
    @Qualifier("userServiceImpl")
    private UserServiceImpl userService;
    
    @Autowired
    @Qualifier("remembermeService")
    private RememberMeServicesImpl rememberMe;
    
    @GetMapping({"/","/index"})
    public ModelAndView index(@RequestParam(name="error",required=false) String error,
            @CookieValue(value="rememberme",required=false) String cookie){
        
        ModelAndView mav;
        UserModel user;
        if(cookie != null){
            if(userService.existUser(cookie)){
                mav = new ModelAndView(HOME_VEIW);
                UserDetails userDetails = userService.loadUserByUsername(cookie);
                user = userService.getUser(cookie);
                if(httpSession.getAttribute("currentUser")==null){
                    httpSession.setAttribute("currentUser",user);
                }else if(!((UserModel)httpSession.getAttribute("currentUser")).getEmail().equals(userDetails.getUsername())){
                    httpSession.setAttribute("currentUser",user);
                } 
                DocumentModel newDocument = new DocumentModel();
                newDocument.setAuthor((UserModel)httpSession.getAttribute("currentUser"));
                mav.addObject("newDocument",newDocument);
                mav.addObject("user",(UserModel)httpSession.getAttribute("currentUser"));
            }else{
                mav = new ModelAndView();
            }
        }else if(httpSession.getAttribute("currentUser")==null)
                mav = new ModelAndView(LOGIN_VEIW);
            else{
                mav = new ModelAndView(HOME_VEIW);
                DocumentModel newDocument = new DocumentModel();
                newDocument.setAuthor((UserModel)httpSession.getAttribute("currentUser"));
                mav.addObject("newDocument",newDocument);
                mav.addObject("user",(UserModel)httpSession.getAttribute("currentUser"));
            }
        
        mav.addObject("error", error);
        
        return mav;
    }    
    
    @GetMapping("/registration")
    public ModelAndView registration(@CookieValue(value="rememberme",required=false) String cookie){
        ModelAndView mav;
        if(cookie != null){
            if(userService.existUser(cookie)){
                mav = new ModelAndView(HOME_VEIW);
                userService.loadUserByUsername(cookie);
                DocumentModel newDocument = new DocumentModel();
                UserModel cModelUser = userService.getUser(cookie);
                newDocument.setAuthor(cModelUser);
                mav.addObject("newDocument",newDocument);
                mav.addObject("user",cModelUser);
            }else{
                mav = new ModelAndView(REG_VEIW);
                mav.addObject("user", new UserModel());
            }
        }else{
            mav = new ModelAndView(REG_VEIW);
            mav.addObject("user", new UserModel());
        }
        
        return mav;
    }
    
    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute("user") UserModel user, BindingResult bindingResult){
        ModelAndView mav = new ModelAndView();
        if(bindingResult.hasErrors()){
            mav.setViewName(REG_VEIW);
        }else{
            try{
                BCryptPasswordEncoder pwd = new BCryptPasswordEncoder();
                mav.setViewName(REG_OK_VEIW);
                user.setPassword(pwd.encode(user.getPassword()));
                userService.addUser(user);
            }catch(DataIntegrityViolationException e){
                mav.setViewName(REG_VEIW);
                bindingResult.rejectValue("email","error.user","Correo electrónico ya registrado");
            }   
        }
        return mav;
    }
    
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies)
            if(cookie.getName().equals("rememberme")){
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        httpSession.removeAttribute("currentUser");
        rememberMe.closeCurrentSession();
        return new ModelAndView(LOGIN_VEIW);
    }
    
    @GetMapping("/home")
    public String redirectHome(){
        return "redirect:/home/";
    }
}