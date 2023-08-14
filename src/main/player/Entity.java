package main.player;

import java.awt.*;

public class Entity {
    private double x;
    private double y;

    public Entity(double x, double y){
        this.x = x;
        this.y = y;
    }
    public void update(Graphics g, Color c){
        setColor(g, c);
        g.fillRect((int)getX(), (int)getY(), 16, 16);
    }

    public void setColor(Graphics g, Color c){
        g.setColor(c.blue);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x += x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y += y;
    }
}
