/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fideljose.webservices.dto;

/**
 *
 * @author fidel.villero
 */
public class CustomeObjJWT {
    private String alg;
    private String sub;
    private String iat;
    private String exp;
    private Persona persona;

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getIat() {
        return iat;
    }

    public void setIat(String iat) {
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
