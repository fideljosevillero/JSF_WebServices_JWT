package com.fideljose.webservices.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Persona {
    private String nombre;
    private String direccion;
    
    
    public Persona() {
    }

    public Persona(String nombre, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

   
    
}
