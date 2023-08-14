package main.gameStracture;

import java.awt.*;

public class Game implements Runnable {
    private GameFrame gf;
    private GamePanel gp;
    public Game(){
        gp = new GamePanel();
        gf = new GameFrame(gp);
        gp.setFocusable(true);
        gp.setBackground(Color.GRAY);

        Thread th = new Thread(this);
        th.start();
    }

    public void gameLoop(){
        double timePerFrame = 1_000_000_000.0 / 60;
        long lastCheck = System.nanoTime();
        long currTime;
        double delta = 0;
        int frame = 0;
        long timer = 0;
        while (true){
            currTime = System.nanoTime();
            delta += (currTime - lastCheck) / timePerFrame;
            timer += (currTime - lastCheck);
            lastCheck = currTime;
            if(delta >= 1){
                gp.repaint();
                delta--;
                frame++;
            }

            if(timer >= 1_000_000_000){
                System.out.println(frame);
                frame = 0;
                timer = 0;
            }
        }
    }

    @Override
    public void run() {
        gameLoop();
    }
}
