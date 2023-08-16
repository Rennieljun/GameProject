package main.player;

import java.awt.*;

public class Entity {
    private double worldX;
    private double worldY;
    private double screenX;
    private double screenY;

    public double getScreenX() {
        return screenX;
    }

    public double getScreenY() {
        return screenY;
    }

    public Entity(double worldX, double worldY){
        this.worldX = worldX;
        this.worldY = worldY;
    }
    public void update(Graphics g, Color c){
        setColor(g, c);
        g.fillRect((int) screenX, (int) screenY, 16, 16);
    }

    public void setScreen (int width, int height){
        this.screenX = (double) width / 2 - ((double) 16 / 2);
        this.screenY = (double) height / 2 - ((double) 16 / 2);
    }

    public void setColor(Graphics g, Color c){
        g.setColor(Color.BLUE);
    }

    public double getWorldX() {
        return worldX;
    }

    public void setWorldX(double worldX) {
        this.worldX += worldX;
    }

    public double getWorldY() {
        return worldY;
    }

    public void setWorldY(double worldY) {
        this.worldY += worldY;
    }
}
