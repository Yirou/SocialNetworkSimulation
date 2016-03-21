/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belogical.social;

import com.belogical.social.utils.SocialUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

/**
 *
 * @author yirou
 */
public class Social {

    private List<User> users = new ArrayList<>();
    private int nbUser = 500;
    private Graph graph;
    private Edge edgeEnCours;
    private static final Social instance = new Social();
    private int nbMaxFriend = 5;
    private int nbInfecte = 0;

    private Social() {
    }

    public static Social getInstance() {
        return instance;
    }

    public int getNbMaxFriend() {
        return nbMaxFriend;
    }

    public void setNbMaxFriend(int nbMaxFriend) {
        this.nbMaxFriend = nbMaxFriend;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setNbUser(int nbUser) {
        this.nbUser = nbUser;
    }

    public int getNbUser() {
        return nbUser;
    }

    public void init() {
        User user;
        User friend;
        int nbFriend;
        int rumeursPreferes = 3;
        int typeRumeur;
        int typePersonne;
        for (int i = 0; i < nbUser; i++) {
            user = new User(i);
            typePersonne = SocialUtils.random(0, TypePersonne.values().length);
            user.setTypePersonne(TypePersonne.values()[typePersonne]);
            do {
                typeRumeur = SocialUtils.random(0, TypeRumeur.values().length);
                if (!user.getPreferencesRumeur().contains(TypeRumeur.values()[typeRumeur])) {
                    user.getPreferencesRumeur().add(TypeRumeur.values()[typeRumeur]);
                    rumeursPreferes--;

                }
            } while (rumeursPreferes > 0);
            users.add(user);
        }

        for (User u : users) {
            nbFriend = SocialUtils.random(1, nbMaxFriend);
            for (int i = 0; i < nbFriend; i++) {
                int f = SocialUtils.random(0, nbUser);
                friend = users.get(f);
                if (u != friend && (!u.getMesAmis().contains(friend))) {
                    u.getMesAmis().add(friend);
                    if (!friend.getMesAmis().contains(u)) {
                        friend.getMesAmis().add(u);
                    }
                } else {
                    nbFriend++;
                }
            }

        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void spreadRumor(User user) {
        int transmitionRate = SocialUtils.random(1, 101);
        for (User u : user.getMesAmis()) {
            if (!u.isContamine()) {
                contaminerUser(user, u, transmitionRate);
            }

        }
    }

    private void colorUserNode(User user) {
        Node node = graph.getNode(user.getId() + "");
        if (!user.isRumorLuncher()) {
            node.addAttribute("ui.class", "contamine");
        }
    }

    private void colorEdgeContamine(boolean value) {
        if (value) {
            edgeEnCours.addAttribute("ui.class", "contamine");
        } else {
            edgeEnCours.addAttribute("ui.class", "nonContamine");
        }

    }

    private void contaminerUser(User user, User u, int transmitionRate) {
        int prob;
        try {
            prob = SocialUtils.random(1, 101);
            if (prob > transmitionRate) {
                u.getMesRumeurs().add(user.getMesRumeurs().get(0));
                u.setContamine(true);
                nbInfecte++;
                System.out.println("Personnes contaminés " + nbInfecte);
                Node node = graph.getNode(u.getId());
                if (!u.isRumorLuncher()) {
                    node.addAttribute("ui.class", "contamine");
                }
                edgeEnCours = graph.getEdge(user.getId() + "-" + u.getId());
                if (edgeEnCours == null) {
                    edgeEnCours = graph.getEdge(u.getId() + "-" + user.getId());
                }
                colorEdgeContamine(true);
                Thread.sleep(200);
                colorEdgeContamine(false);
                u.handleUserRole();
            }

            colorUserNode(user);
//                Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Social.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int countNbInfecte() {
        int nbInfecte = 0;
        for (User u : this.users) {
            if (u.isContamine()) {
                nbInfecte++;
            }
        }
        return nbInfecte;
    }

}
