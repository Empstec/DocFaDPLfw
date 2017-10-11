/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.controller;

import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.UserModel;
import com.UPV.MITSS.TFM.DocFacDPLfw.service.DocumentService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Salvador Puertes Aleixandre
 */
@RestController

@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/rest")
public class jQueryRequestController {
    
    @Autowired
    private HttpSession httpSession;
    
    @Autowired
    @Qualifier("documentServiceImpl")
    private DocumentService documentService;
    
    @PostMapping("/deleteDocument")
    @ResponseBody
    public ResponseEntity<String> deleteDocument(@RequestBody String jsonRequest){
        JsonObject jsonObject = (new JsonParser()).parse(jsonRequest).getAsJsonObject();
        
        int idDocument = jsonObject.get("idDocument").getAsInt();
        
        if(((UserModel)httpSession.getAttribute("currentUser")).getDocument(idDocument) != null){
            // Remove permission and after remove document
            documentService.removeDocument(idDocument);
            return new ResponseEntity<>("{}",HttpStatus.OK);
        }else{
            JsonObject jsonError = new JsonObject();
            jsonError.addProperty("error", "It isn't your document");
            return new ResponseEntity<>(jsonError.toString(),HttpStatus.valueOf(400));
        }
    }
}
