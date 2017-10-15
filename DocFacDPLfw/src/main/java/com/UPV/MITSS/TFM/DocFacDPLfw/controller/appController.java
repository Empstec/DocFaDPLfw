/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.controller;

import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.DocumentModel;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.UserModel;
import com.UPV.MITSS.TFM.DocFacDPLfw.service.DocumentService;
import com.UPV.MITSS.TFM.DocFacDPLfw.service.UserService;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public static final String WRITE_VEIW = "write";
    public static final String CREATE_VEIW = "create";
    public static final String PROFILE_VEIW = "profile";
    
    @Autowired
    private HttpSession httpSession;
    
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    
    @Autowired
    @Qualifier("documentServiceImpl")
    private DocumentService documentService;
    
    @GetMapping("/")
    public ModelAndView loginValidate(@CookieValue(value="rememberme", required=false) String cookie){
        ModelAndView mav = new ModelAndView(HOME_VEIW);
        
        UserModel cModelUser;
        DocumentModel newDocument = new DocumentModel();
        String jsonDocuments = "{";
        
        if(cookie == null){
            User currentUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // Usuario Actual
            cModelUser = userService.getUser(currentUser.getUsername());
        }else{
            cModelUser = userService.getUser(cookie);
        }
        
        if(httpSession.getAttribute("currentUser")== null)
            httpSession.setAttribute("currentUser", cModelUser);
        else if(!((UserModel)httpSession.getAttribute("currentUser")).getEmail().equals(cModelUser.getEmail()))
            httpSession.setAttribute("currentUser", cModelUser);
        
        mav.addObject("user",cModelUser);
        newDocument.setAuthor(cModelUser);
        mav.addObject("newDocument",newDocument);
        
        // Sorted list for viee
        SortedSet<Integer> sortedKeys = new TreeSet<>(cModelUser.getDocuments().keySet());
        List<DocumentModel> documents = new ArrayList<>();
        
        // Make sorted list
        if(!sortedKeys.isEmpty()){
            jsonDocuments = sortedKeys.stream().map((key) -> {
                documents.add(cModelUser.getDocuments().get(key));
                return key;
            }).map((key) -> cModelUser.getDocuments().get(key).toJSON()+",").reduce(jsonDocuments, String::concat);
            jsonDocuments = jsonDocuments.substring(0,jsonDocuments.length()-1)+"}";
        }else
            jsonDocuments += "}";
        
        
        Collections.reverse(documents); // Revers the order
        mav.addObject("documents",documents);
        mav.addObject("jsonDocuments",jsonDocuments); // Document's JSON List
        
        return mav;
    }
    
    @GetMapping("/write")
    public ModelAndView createDocument(){
        ModelAndView mav = new ModelAndView(WRITE_VEIW);
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
        ModelAndView mav = new ModelAndView();
        mav.setViewName(PROFILE_VEIW);
        if(!bindingResult.hasErrors()){
            UserModel currentModelUser = (UserModel)httpSession.getAttribute("currentUser"); 
            user.setEmail(currentModelUser.getEmail());
            String oldPassSend = user.getPassword().split(",")[0];
            BCryptPasswordEncoder pwd = new BCryptPasswordEncoder();
            if(pwd.matches(oldPassSend,currentModelUser.getPassword()) && user.getPassword().split(",").length>1){
                String newPass = user.getPassword().split(",")[1];
                if(newPass.length()>50 || newPass.length()<8){
                    bindingResult.rejectValue("password", "error.user","La longitud tiene que estar entre 8 y 50");
                    user.setPassword(currentModelUser.getPassword());
                }else
                    user.setPassword(pwd.encode(newPass));
            }else{
                user.setPassword(currentModelUser.getPassword());
            }
            httpSession.setAttribute("currentUser",userService.updateUser(user));
        }
        return mav;
    }
    
    @PostMapping("/saveDocument")
    public ModelAndView saveCreateDocuemnt(@Valid @ModelAttribute("newDocument") DocumentModel document, BindingResult bindingResult){
        ModelAndView mav = new ModelAndView();
        if(!bindingResult.hasErrors()){
            document.setAuthor((UserModel)httpSession.getAttribute("currentUser"));
            DocumentModel newDocument = documentService.addDocument(document);
            
            mav.addObject("user", (UserModel)httpSession.getAttribute("currentUser"));
            mav.addObject("document", newDocument);
            mav.setViewName(CREATE_VEIW);
        }else{
            mav.addObject("user", (UserModel)httpSession.getAttribute("currentUser"));
            mav.setViewName(HOME_VEIW);
        }
        
        return mav;
    }
}
