package com.fideljose.webservices.dto;


public class ObjJson {
    
    private String sub;
    private double iat;
    private double exp;
    private Persona persona;

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public double getIat() {
        return iat;
    }

    public void setIat(double iat) {
        this.iat = iat;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }
    
    
}
