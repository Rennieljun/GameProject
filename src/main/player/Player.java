package main.player;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Entity{

    private double speed;
    private double accelerate;
    private int timer = 3;
    private int cooldown = 3;
    private int interval = 60;
    private boolean accelerating = false;
    public boolean up = false;
    public boolean down = false;
    public boolean left = false;
    public boolean right = false;
    private double mouseX = 0;
    private double mouseY = 0;
    public boolean firing = false;
    private double gunFiringRate = 0.5;
    private int gunCD = 15;
    public Player(double x, double y) {
        super(x, y);
        speed = 1.5;
        accelerate = 4.6;
    }

    public double getMouseX() {
        return mouseX;
    }

    public void setMouseX(double mouseX) {
        this.mouseX = mouseX;
    }

    public double getMouseY() {
        return mouseY;
    }

    public void setMouseY(double mouseY) {
        this.mouseY = mouseY;
    }
    public void accelerateTimer(Graphics g){
        g.setColor(Color.RED);
        g.fillRect((int)getX() - 2, (int)getY() + 20, 3 * 2, 5);
        g.setColor(Color.CYAN);
        g.fillRect((int)getX() - 2, (int)getY() + 20, timer * 2, 5);
    }
    public void armsUpdate(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        double angle = Math.atan2(mouseY - getY(), mouseX - getX());
        if(firing){
            g2.setColor(Color.YELLOW);
            int bulletX = (int) (getX()+5);
            int bulletY = (int) (getY()+5);
            g2.setStroke(new BasicStroke(1));
            g2.drawLine(bulletX, bulletY, bulletX + (int)(100 * Math.cos(angle)), bulletY + (int)(100 * Math.sin(angle)));
        }
        int gunX = (int) (getX()+5);
        int gunY = (int) (getY()+5);
        g2.setColor(Color.DARK_GRAY);
        g2.setStroke(new BasicStroke(5));
        g2.drawLine(gunX, gunY, gunX + (int)(20 * Math.cos(angle)), gunY + (int)(20 * Math.sin(angle)));

    }
    public void fire(boolean b){
        firing = b;
    }
    public void setMove(int keyCode, boolean b){
        if(keyCode == KeyEvent.VK_LEFT){
            left = b;
        }
        if(keyCode == KeyEvent.VK_RIGHT){
            right = b;
        }
        if(keyCode == KeyEvent.VK_UP){
            up = b;
        }
        if(keyCode == KeyEvent.VK_DOWN){
            down = b;
        }
        if(keyCode == KeyEvent.VK_SPACE ){
            moveFast(b);
        }
        if (keyCode == KeyEvent.VK_F){
            fire(true);
        }
    }

    private void moveFast(boolean b) {
        accelerating = b;
    }
    public void movementUpdate(){
        if(left && !up || left && !down) setX(-speed);
        if (right && !up || right && !down) setX(speed);
        if (up && !left || up && !right) setY(-speed);
        if (down && !left || down && !right) setY(speed);
        if (left && up) {
            setX(-speed / 2);
            setY(-speed / 2);
        }
        if (left && down) {
            setX(-speed / 2);
            setY(speed / 2);
        }
        if (right && up) {
            setX(speed / 2);
            setY(-speed / 2);
        }
        if (right && down) {
            setX(speed / 2);
            setY(speed / 2);
        }
    }
    public void activateAcceleration(){
        if(timer > 0){
            speed = accelerate;
        }else speed = 1.5;
    }
    public void coolDownUpdate(){
        interval--;
        gunCD--;
        if(gunCD == 0){
            gunCD = 25;
            if(firing) firing = false;
        }
        if(interval == 0){
            interval = 60;
            if(accelerating){
                timer--;
                activateAcceleration();
            }else speed = 1.5;
            if(timer < 3){
                cooldown--;
                if(cooldown == 0){
                    timer++;
                    cooldown = 3;
                }
            }

        }
    }
    public void actionPerformed(){
        movementUpdate();
        coolDownUpdate();
    }
}
