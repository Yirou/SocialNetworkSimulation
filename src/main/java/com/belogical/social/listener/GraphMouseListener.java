/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belogical.social.listener;

import com.belogical.social.views.SocialView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author yirou
 */
public class GraphMouseListener extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            SocialView.getInstance().zoomOut();
        }
        if (e.getClickCount() == 1) {
//            SocialView.getInstance().getView().getCamera().setViewCenter(e.getXOnScreen(), e.getYOnScreen(), SocialView.VIEW_ZOOM);
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            SocialView.getInstance().zoomIn();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
