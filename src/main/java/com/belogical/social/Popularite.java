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
public enum Popularite {

    Populaire, TresPopulaire, NonPopulaire;

    public static Popularite getPopularite(String pop) {
        for (Popularite popularite : values()) {
            if (popularite.toString().equalsIgnoreCase(pop)) {
                return popularite;
            }
        }
        return Popularite.NonPopulaire;
    }
}
