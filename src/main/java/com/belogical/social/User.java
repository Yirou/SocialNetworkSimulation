/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belogical.social;

import com.belogical.social.utils.SocialUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.graphstream.graph.Node;

/**
 *
 * @author yirou
 */
public class User extends Observable {

    private int id;
    private String nom;
    private Popularite popularite;
    private TypePersonne typePersonne;
    private boolean contamine;
    private boolean rumorLuncher;
    private List<Rumeur> mesRumeurs = new ArrayList<>();
    private List<User> mesAmis = new ArrayList<>();
    private List<TypeRumeur> preferencesRumeur = new ArrayList<>();

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public void setTypePersonne(TypePersonne typePersonne) {
        this.typePersonne = typePersonne;
    }

    public TypePersonne getTypePersonne() {
        return typePersonne;
    }

    public void setRumorLuncher(boolean rumorLuncher) {
        this.rumorLuncher = rumorLuncher;
    }

    public boolean isRumorLuncher() {
        return rumorLuncher;
    }

    public User(int id, String nom, Popularite popularite) {
        this.id = id;
        this.nom = nom;
        this.popularite = popularite;
    }

    public User(User another) {
        this.nom = another.getNom();
        this.popularite = another.getPopularite();
    }

    public void setContamine(boolean contamine) {
        this.contamine = contamine;
    }

    public boolean isContamine() {
        return contamine;
    }

    public List<Rumeur> getMesRumeurs() {
        return mesRumeurs;
    }

    public void setPreferencesRumeur(List<TypeRumeur> preferencesRumeur) {
        this.preferencesRumeur = preferencesRumeur;
    }

    public List<TypeRumeur> getPreferencesRumeur() {
        return preferencesRumeur;
    }

    public void setMesRumeurs(List<Rumeur> mesRumeurs) {
        this.mesRumeurs = mesRumeurs;
    }

    public int getId() {
        return id;
    }

    public Popularite getPopularite() {
        return popularite;
    }

    public void setPopularite(Popularite popularite) {
        this.popularite = popularite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<User> getMesAmis() {
        return mesAmis;
    }

    public void setMesAmis(List<User> mesAmis) {
        this.mesAmis = mesAmis;
    }

    void setChange() {
        this.setChanged();
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + '}';
    }

    public void lunchRumor() {
        this.setRumorLuncher(true);
        this.setTypePersonne(TypePersonne.Diffiseur);
        System.out.println(this.getMesRumeurs() + "Rumeurs");
        handleUserRole();

    }

    public void handleUserRole() {

        switch (this.getTypePersonne()) {
            case Diffiseur:
                if (this.getPreferencesRumeur().contains(this.getMesRumeurs().get(0).getTypeRumeur())) {
                    Social.getInstance().spreadRumor(this);
                } else {
                    int pileOuFace = SocialUtils.random(0, 10);
                    if (pileOuFace > 0) {
                        Social.getInstance().spreadRumor(this);
                    }
                }

                break;
            case Glandeur:

                break;
            case Ignorant:
                this.setTypePersonne(TypePersonne.Diffiseur);
                if (this.getPreferencesRumeur().contains(this.getMesRumeurs().get(0).getTypeRumeur())) {
                    Social.getInstance().spreadRumor(this);
                } else {
                    int pileOuFace = SocialUtils.random(0, 10);
                    if (pileOuFace > 0) {
                        Social.getInstance().spreadRumor(this);
                    }
                }
                break;
            default:
                break;
        }
    }

}
