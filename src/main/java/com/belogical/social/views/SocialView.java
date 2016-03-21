/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belogical.social.views;

import com.belogical.social.Social;
import com.belogical.social.User;
import com.belogical.social.listener.GraphMouseListener;
import com.belogical.social.utils.SocialUtils;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author yirou
 */
public class SocialView extends javax.swing.JFrame {

    private static SocialView INSTANCE = new SocialView();
    private View view;
    public static double VIEW_ZOOM = 0.5;
    private Social social = Social.getInstance();
    GraphMouseListener gml = new GraphMouseListener();

    /**
     * Creates new form SocialView
     */
    private SocialView() {
        initComponents();
        this.setDefaultLookAndFeelDecorated(true);
        this.setAlwaysOnTop(true);
//        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        this.social.setGraph(SocialUtils.initGraph(social));
    }

    public static SocialView getInstance() {
        return INSTANCE;
    }

    public void zoomIn() {
        if (VIEW_ZOOM < 1) {
            VIEW_ZOOM += 0.1;
            view.getCamera().setViewPercent(VIEW_ZOOM);
        }

    }

    private void initViewListener() {
        Viewer v = new Viewer(this.social.getGraph(), Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        v.enableAutoLayout();
        view = v.addDefaultView(false);
        view.removeMouseListener(gml);
        view.addMouseListener(gml);
    }

    public void zoomOut() {
        if (VIEW_ZOOM > 0) {
            VIEW_ZOOM -= 0.1;
            view.getCamera().setViewPercent(VIEW_ZOOM);
        }
    }

    public void setView(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        graphViewPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nbNoeudTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nbLienTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rumorLuncherTxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        graphViewPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Nb Noeud");

        nbNoeudTxt.setText("500");

        jLabel3.setText("Nb Lien max");

        nbLienTxt.setText("5");
        nbLienTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nbLienTxtActionPerformed(evt);
            }
        });

        jLabel4.setText("Rumor Luncher");

        rumorLuncherTxt.setText("10");

        jButton1.setText("Executer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout graphViewPanelLayout = new javax.swing.GroupLayout(graphViewPanel);
        graphViewPanel.setLayout(graphViewPanelLayout);
        graphViewPanelLayout.setHorizontalGroup(
            graphViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(graphViewPanelLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nbNoeudTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(31, 31, 31)
                .addComponent(nbLienTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel4)
                .addGap(31, 31, 31)
                .addComponent(rumorLuncherTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 79, Short.MAX_VALUE))
        );
        graphViewPanelLayout.setVerticalGroup(
            graphViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(graphViewPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(graphViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nbNoeudTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(nbLienTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(rumorLuncherTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(graphViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(graphViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        int nbUser = Integer.parseInt(nbNoeudTxt.getText());
//        social.setNbUser(nbUser);
//        social.setNbMaxFriend(Integer.parseInt(nbLienTxt.getText()));
//        social.init();
//        SocialUtils.initGraph();
////        initViewListener();
//        User user = social.getUsers().get(Integer.parseInt(rumorLuncherTxt.getText()));
//        user.setRumorLuncher(true);
//        social.lunchRumor(user);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nbLienTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nbLienTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nbLienTxtActionPerformed

    public void setGraphViewPanel(JPanel graphViewPanel) {
        this.graphViewPanel = graphViewPanel;
    }

    public JPanel getGraphViewPanel() {
        return graphViewPanel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel graphViewPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField nbLienTxt;
    private javax.swing.JTextField nbNoeudTxt;
    private javax.swing.JTextField rumorLuncherTxt;
    // End of variables declaration//GEN-END:variables

}
