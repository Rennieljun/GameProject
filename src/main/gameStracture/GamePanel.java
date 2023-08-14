package main.gameStracture;

import main.controls.KeyInputs;
import main.controls.MouseInputs;
import main.controls.MouseMotion;
import main.player.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public Player player;
    public GamePanel(){
        JLabel label = new JLabel("HHAHAAHHA");
        this.add(label);
        setSize();
        player = new Player(100, 100);
        addMouseMotionListener(new MouseMotion(this));
        addMouseListener(new MouseInputs(this));
        addKeyListener(new KeyInputs(this));
    }
    public void setSize(){
        Dimension size = new Dimension(600, 600);
        setPreferredSize(size);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.armsUpdate(g);
        player.update(g, Color.BLUE);
        player.accelerateTimer(g);
        update();
    }

    public void update(){
        player.actionPerformed();
    }
}
