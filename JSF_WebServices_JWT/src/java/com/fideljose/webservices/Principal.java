package com.fideljose.webservices;

import com.auth0.jwt.JWTVerifyException;
import com.fideljose.jwt.Decompiler_jwt;
import com.fideljose.webservices.dto.Persona;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/principal/{value}")
public class Principal {
    
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Persona> primero(@PathParam("value") String value){
//        System.out.println("VALOR "+ value);
//        List<Persona> lista = new ArrayList<Persona>();
//        lista.add(new Persona("nombre1", "direccion1"));
//        lista.add(new Persona("nombre2", "direccion2"));
//        lista.add(new Persona("nombre3", "direccion3"));
//        lista.add(new Persona("nombre4", "direccion4"));
//        lista.add(new Persona("nombre5", "direccion5"));
//        return lista;
//    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response primero(@PathParam("value") String value) throws NoSuchAlgorithmException, InvalidKeyException, IOException, JWTVerifyException, SignatureException, URISyntaxException{
        //System.out.println("VALOR "+ value);
        String data = Decompiler_jwt.decompiler(value);
        System.out.println("VALOR OBTENIDO "+data);
        // valido que el token sea correcto
        if(data.contains("incorrecto")){
            //return Response.status(Status.NOT_ACCEPTABLE).build();
            return redirect("https://www.tcc.com.co/");
        }
        //return Response.status(Status.ACCEPTED).build();
        return redirect("https://www.boxtcc.com.co/");
    }
    
    private Response redirect(String url) throws URISyntaxException{
        java.net.URI location = new java.net.URI(url);
        return Response.temporaryRedirect(location).build();
    }
    
}
