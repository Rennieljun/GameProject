package main.gameStracture;

import java.awt.*;

public class Game implements Runnable {
    private GameFrame gf;
    private GamePanel gp;
    private final int FRAMEPERSECOND = 120;
    private final int FRAMEPERUPDATE = 200;
    public Game(){
        gp = new GamePanel();
        gf = new GameFrame(gp);
        gp.setFocusable(true);
        gp.setBackground(Color.GRAY);

        Thread th = new Thread(this);
        th.start();
    }

    public void gameLoop(){
        double timePerFrame = 1_000_000_000.0 / FRAMEPERSECOND;
        double timePerUpdate = 1_000_000_000.0 / FRAMEPERUPDATE;
        long lastCheck = System.nanoTime();
        long currTime;
        double delta = 0;
        double deltaU = 0;
        int frame = 0;
        int update = 0;
        long timer = 0;
        while (true){
            currTime = System.nanoTime();
            delta += (currTime - lastCheck) / timePerFrame;
            deltaU += (currTime - lastCheck) / timePerUpdate;
            timer += (currTime - lastCheck);
            lastCheck = currTime;
            if(delta >= 1){
                gameFrameUpdate();
                delta--;
                frame++;
            }
            if(deltaU >= 1){
                gameUpdate();
                deltaU--;
                update++;

            }

            if(timer >= 1_000_000_000){
                System.out.println("FPS: " + frame + ":" + "UPDATE: " + update);
                frame = 0;
                update = 0;
                timer = 0;
            }
        }
    }

    public void gameUpdate(){
        gp.playerUpdate();
    }

    public void gameFrameUpdate(){
        gp.repaint();
    }

    @Override
    public void run() {
        gameLoop();
    }
}
