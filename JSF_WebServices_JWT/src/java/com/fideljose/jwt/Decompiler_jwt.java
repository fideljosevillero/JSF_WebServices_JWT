/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fideljose.jwt;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.fasterxml.jackson.core.JsonParser;
import com.fideljose.webservices.dto.CustomeObjJWT;
import com.fideljose.webservices.dto.ObjJson;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;
import com.fideljose.webservices.dto.Persona;
import com.google.gson.Gson;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author fidel.villero
 */
public class Decompiler_jwt {
    
    
    public static String decompiler(String token) throws NoSuchAlgorithmException,
            InvalidKeyException, IOException, JWTVerifyException, SignatureException {
        Map<String, Object> decodedData = null;
        try {
            String KEY = "bm%^Y3UFKt2?@78w";
            decodedData = new JWTVerifier(KEY).verify(token);
            System.out.println("VALOR DE decodedData "+decodedData);
            
            //*** en caso que el token sea incorrecto retorno y ya.
            System.out.println("Data del token:"+decodedData);
            if(decodedData == null){
                return "Token incorrecto!!!";
            }
            
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            String json = new com.fasterxml.jackson.databind.ObjectMapper().writeValueAsString(decodedData);
            System.out.println(json);
            
    //        Gson gson = new Gson();
    //        ObjJson objJava = gson.fromJson(json, ObjJson.class);

            System.out.println("Data del token:"+decodedData);
            
            //** convertir a obj java
            generatedObjectJava(json);

        //} catch (IllegalStateException illegalStateException) {
        } catch (Exception illegalStateException) {
            System.err.println("Invalid Token! " + illegalStateException);
        }
        
        
        //getObjPersona("persona={nombre=nombre, direccion=direccion, telefono=telefono, email=email}");
        return decodedData.toString();
    }
    
    public static CustomeObjJWT getObjPersona(String JsonString) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        //JSON from String to Object
        CustomeObjJWT obj = mapper.readValue(JsonString, CustomeObjJWT.class);
        System.out.println("Nombre ");
//        System.out.println("Telefono "+obj.getPersona().getTelefono());
        return obj;
    }
    
    private static ObjJson generatedObjectJava(String json){
        //** convertir a obj java
        Gson gson = new Gson();
        ObjJson objJava = gson.fromJson(json, ObjJson.class);
        System.out.println("Objeto java 1 "+objJava.getPersona().getNombre());
        System.out.println("Objeto java 2 "+objJava.getPersona().getDireccion());
        System.out.println("Objeto java 3 "+objJava.getSub());
        System.out.println("Objeto java 4 "+objJava.getExp());
        System.out.println("Objeto java 5 "+objJava.getIat());
        return objJava;
        
    }
    
}
