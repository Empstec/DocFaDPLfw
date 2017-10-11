/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.JSONAdapter;

import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.DocumentModel;
import com.google.common.base.Strings;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/**
 *
 * @author Salvador Puertes Aleixandre
 */
public class DocumentAdapter extends TypeAdapter<DocumentModel>{

    @Override // Object to JSON
    public void write(JsonWriter writer, DocumentModel t) throws IOException {
        
        writer.beginObject();
        
        writer.name("title");
        writer.value(t.getTitle());
        
        if(!Strings.isNullOrEmpty(t.getDescription())){
            writer.name("description");
            writer.value(t.getDescription());
        }

        if(t.getCreation()!= null){
            writer.name("creation");
            writer.value(t.getCreation().toString());
        }
        
        if(t.getLastEdition() != null){
            writer.name("lastEdition");
            writer.value(t.getLastEdition().toString());
        }
        writer.endObject();
    }

    @Override // JSON to Object
    public DocumentModel read(JsonReader reader) throws IOException {
        return null;
    }
    
}
