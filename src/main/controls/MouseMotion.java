package main.controls;

import main.gameStracture.Game;
import main.gameStracture.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotion implements MouseMotionListener {
    private GamePanel gp;

    public  MouseMotion(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        gp.player.setMouseX(e.getX());
        gp.player.setMouseY(e.getY());
    }
}
