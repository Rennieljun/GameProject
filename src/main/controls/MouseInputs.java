package main.controls;

import main.gameStracture.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseListener {

    private GamePanel gp;
    public MouseInputs(GamePanel gp){
       this.gp = gp;
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        int button = e.getButton();
        if(button == MouseEvent.BUTTON1)gp.player.fire(true);
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
