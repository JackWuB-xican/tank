package com.wu.tank;

import java.awt.*;

public class Tank {
    private int x,y;
    private Dir dir;
    private boolean moving = false;
    private boolean live = true;
    private TankFrame tf ;
    private static final int SPEED = 5;
    private static final  int TANK_WIDTH=50,TANK_HEIGHT=50;
    public  static int WIDTH = ResourceMrg.tankL.getWidth();
    public static int HEIGHT = ResourceMrg.tankL.getHeight();
    public Tank(int x,int y,Dir dir,TankFrame tf){
         this.x = x;
         this.y = y;
         this.dir = dir;
         this.tf = tf;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        if(!live){
            tf.tanks.remove(this);
        }
        switch (dir){
            case RIGHT:
                g.drawImage(ResourceMrg.tankR,x,y,null);
                break;
            case LEFT:
                g.drawImage(ResourceMrg.tankL,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMrg.tankD,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMrg.tankU,x,y,null);
                break;
        }
//         g.drawImage(ResourceMrg.tankL,x,y,null);
//        Color color = g.getColor();
//        g.setColor(Color.yellow);
//        g.fillRect(x,y,TANK_WIDTH,TANK_HEIGHT);
//        g.setColor(color);
        move();
    }
    public void move(){
     if(!moving)return;
        switch (dir){
            case DOWN:
                y+=SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case LEFT:
                x-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            default:break;
        }
    }
    public void fire() {
        int bX = this.x +  Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
       tf.bulletList.add(new Bullet(bX,bY,this.dir,this.tf));
    }

    public void die() {
        this.live = false;
    }
}
