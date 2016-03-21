/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belogical.social;

import com.belogical.social.utils.SocialUtils;
import com.belogical.social.views.SocialView;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.ui.view.View;

/**
 *
 * @author yirou
 */
public class Main {

    public static void main(String[] args) {
        Social social = Social.getInstance();
        social.init();
        SocialUtils.initGraph();

        int rumorLuncher = SocialUtils.random(0, social.getNbUser());
        User user = Social.getInstance().getUsers().get(rumorLuncher);
        Node node = social.getGraph().getNode(user.getId());
        node.addAttribute("ui.class", "rumorLuncher");
        Rumeur r = new Rumeur();
        r.setMsg("Il parait que");
        r.setTypeRumeur(TypeRumeur.Sport);
        user.getMesRumeurs().add(r);
        user.lunchRumor();
//        social.countNbInfecte();
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(SocialView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SocialView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SocialView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SocialView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        SocialView view = SocialView.getInstance();
//        view.setVisible(true);
    }
}
