/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belogical.social;

/**
 *
 * @author yirou
 */
public class Rumeur {
    private double popularite;
    private String msg;
    private TypeRumeur typeRumeur;
    

    public Rumeur() {
    }

    public Rumeur(double popularite,String msg) {
        this.popularite = popularite;
        this.msg=msg;
    }
    
    public Rumeur(Rumeur another) {
        this.popularite = another.getPopularite();
        this.msg=another.getMsg();
    }

    public String getMsg() {
        return msg;
    }

    public void setTypeRumeur(TypeRumeur typeRumeur) {
        this.typeRumeur = typeRumeur;
    }

    public TypeRumeur getTypeRumeur() {
        return typeRumeur;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public double getPopularite() {
        return popularite;
    }

    public void setPopularite(double popularite) {
        this.popularite = popularite;
    }
    
    
}
