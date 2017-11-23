/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fideljose.jwt;

import com.auth0.jwt.JWTVerifyException;
import com.fideljose.webservices.dto.Persona;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fidel.villero
 */
public class Java_jwt_2 {

    
    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, IOException, JWTVerifyException, SignatureException {
//        String token = generatedToken();
//        Decompiler_jwt.decompiler(token);
//    }
    
    public static String generatedToken(){
        String jwt = "";
        String KEY = "bm%^Y3UFKt2?@78w";
        try{
            Persona p = new Persona();
            p.setNombre("nombre");
            p.setDireccion("direccion");
            
            long tiempo = System.currentTimeMillis();
            jwt = Jwts.builder()
            .setSubject("asunto/tema")
            //***
            .setIssuedAt(new Date(tiempo))
            //***
            .setExpiration(new Date(tiempo+300000))
            .claim("nombre", "Fidel José Villero de Hoyos")
            .claim("identificacion", "1234567890")
            .claim("persona", p)
            .signWith(
                SignatureAlgorithm.HS256,
                KEY.getBytes("UTF-8")
            )
            .compact();
        }catch(Exception er){
            
        }finally{
            System.out.println("Token generado:"+jwt);
            return jwt;
        }
    }
    
    
}
