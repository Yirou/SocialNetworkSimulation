/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belogical.social.views;

import com.belogical.social.Social;
import com.belogical.social.listener.GraphMouseListener;
import com.belogical.social.utils.SocialUtils;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.graphstream.graph.Node;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author yirou
 */
public class SocialView1 extends javax.swing.JFrame {
    
    public static SocialView1 instance = new SocialView1();
    private Social social;
    private View view;
    public static double VIEW_ZOOM = 0.5;

    /**
     * Creates new form SocialView
     */
    private SocialView1() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
//        this.social.setGraph(SocialUtils.initGraph(social));
    }
    
    public static SocialView1 getInstance() {
        return instance;
    }
    
    public void setSocial(Social social) {
        this.social = social;
    }
    
    public Social getSocial() {
        return social;
    }
    
    public void addGraphViewer() {
        Viewer v = new Viewer(this.social.getGraph(), Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        v.enableAutoLayout();
        view = v.addDefaultView(false);
        GridLayout layout = new GridLayout(1, 1);
        this.graphViewPanel.setLayout(layout);
        this.graphViewPanel.add((JComponent) view);
//        view.getCamera().setViewPercent(VIEW_ZOOM);
        view.addMouseListener(new GraphMouseListener());
    }
    
    public void zoomIn() {
        if (VIEW_ZOOM < 1) {
            VIEW_ZOOM += 0.1;
            view.getCamera().setViewPercent(VIEW_ZOOM);
        }
        
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

        graphViewPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        nbUserTxt = new javax.swing.JTextField();
        btnInitGraph = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        comboRumorLuncher = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnLunchRumor = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout graphViewPanelLayout = new javax.swing.GroupLayout(graphViewPanel);
        graphViewPanel.setLayout(graphViewPanelLayout);
        graphViewPanelLayout.setHorizontalGroup(
            graphViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1043, Short.MAX_VALUE)
        );
        graphViewPanelLayout.setVerticalGroup(
            graphViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnInitGraph.setText("Init Graph");
        btnInitGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInitGraphActionPerformed(evt);
            }
        });

        jLabel1.setText("RumorLuncher");

        comboRumorLuncher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("NbUser");

        btnLunchRumor.setText("Lunch Rumor");
        btnLunchRumor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLunchRumorActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nbUserTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnInitGraph)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addComponent(comboRumorLuncher, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(btnLunchRumor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nbUserTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInitGraph)
                            .addComponent(jLabel1)
                            .addComponent(comboRumorLuncher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(btnLunchRumor)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(graphViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInitGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInitGraphActionPerformed
//        social.setNbUser(Integer.parseInt(nbUserTxt.getText()));
//        SocialUtils.initGraph(social);
//        addGraphViewer();
//        validate();
    }//GEN-LAST:event_btnInitGraphActionPerformed

    private void btnLunchRumorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLunchRumorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLunchRumorActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
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
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SocialView().setVisible(true);
//            }
//        });
//    }
    public void setGraphViewPanel(JPanel graphViewPanel) {
        this.graphViewPanel = graphViewPanel;
    }
    
    public JPanel getGraphViewPanel() {
        return graphViewPanel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInitGraph;
    private javax.swing.JButton btnLunchRumor;
    private javax.swing.JComboBox<String> comboRumorLuncher;
    private javax.swing.JPanel graphViewPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField nbUserTxt;
    // End of variables declaration//GEN-END:variables

}
