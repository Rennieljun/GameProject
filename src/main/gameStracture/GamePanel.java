package main.gameStracture;

import main.controls.KeyInputs;
import main.controls.MouseInputs;
import main.controls.MouseMotion;
import main.player.Player;
import main.worldMap.WorldGenerator;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public Player player;
    private WorldGenerator worldGenerator;
    private int tileSize = 16;
    private int maxWorldCol = 50;
    private int maxWorldRow = 50;
    public int worldHeight = maxWorldRow * tileSize;
    public int worldWidth = maxWorldCol * tileSize;

    public int screenMaxCol = 20;
    public int screenMaxRow = 20;
    public int screenHeight = screenMaxCol * tileSize;
    public  int screenWidth = screenMaxRow * tileSize;
    public GamePanel(){
        setSize();
        player = new Player(100, 100);
        player.setScreen(screenWidth, screenHeight);
        worldGenerator = new WorldGenerator(maxWorldRow, maxWorldCol, tileSize, this);
        addMouseMotionListener(new MouseMotion(this));
        addMouseListener(new MouseInputs(this));
        addKeyListener(new KeyInputs(this));
    }
    public void setSize(){
        Dimension size = new Dimension(screenWidth, screenHeight);
        setPreferredSize(size);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        worldGenerator.placeTiles(g);
        player.armsUpdate(g);
        player.update(g, Color.BLUE);
        player.accelerateTimer(g);
    }

    public void playerUpdate(){
        update();
    }
    public void update(){
        player.actionPerformed();
    }
}
