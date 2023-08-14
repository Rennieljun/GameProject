package main.controls;

import main.gameStracture.GamePanel;
import main.player.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputs implements KeyListener {
    private GamePanel gp;
    public KeyInputs(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        gp.player.setMove(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        gp.player.setMove(e.getKeyCode(), false);
    }
}
