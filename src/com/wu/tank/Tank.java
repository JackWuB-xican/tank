package com.wu.tank;

import java.awt.*;
import java.util.Random;

public class Tank {
    private int x,y;
    private Dir dir;
    private boolean moving = true;
    private boolean live = true;
    private Group group = Group.GOOD;
    private TankFrame tf ;
    private Random random = new Random();
    private Rectangle rectangle = new Rectangle();
    private static final int SPEED = 5;
    private static final  int TANK_WIDTH=50,TANK_HEIGHT=50;
    public  static int WIDTH = ResourceMrg.goodTankL.getWidth();
    public static int HEIGHT = ResourceMrg.goodTankL.getHeight();
    public Tank(int x,int y,Dir dir,Group group,TankFrame tf){
         this.x = x;
         this.y = y;
         this.dir = dir;
         this.group = group;
         this.tf = tf;
        rectangle.x = x;
        rectangle.y = y;
        rectangle.height = HEIGHT;
        rectangle.width = WIDTH;
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

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g) {
        if(!live){
            tf.tanks.remove(this);
        }
        switch (dir){
            case RIGHT:
                g.drawImage((this.group == Group.GOOD?ResourceMrg.goodTankR : ResourceMrg.badTankR),x,y,null);
                break;
            case LEFT:
                g.drawImage((this.group == Group.GOOD?ResourceMrg.goodTankL : ResourceMrg.badTankL),x,y,null);
                break;
            case DOWN:
                g.drawImage((this.group == Group.GOOD?ResourceMrg.goodTankD : ResourceMrg.badTankD),x,y,null);
                break;
            case UP:
                g.drawImage((this.group == Group.GOOD?ResourceMrg.goodTankU : ResourceMrg.badTankU),x,y,null);
                break;
        }
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
        if(this.group == Group.BAD && random.nextInt(10)>8){
            this.fire();
        }
        if(this.group == Group.BAD && random.nextInt(100)>95){
            rankDir();
        }
        boundCheck();
        //update rectangle
        rectangle.x = this.x;
        rectangle.y = this.y;
    }

    private void boundCheck() {
        if(this.x <2) x=2;
        if(this.y <28) y=28;
        if(this.x>TankFrame.GAME_WIDTH - Tank.WIDTH -2) x=TankFrame.GAME_WIDTH - Tank.WIDTH -2;
        if(this.y>TankFrame.GAME_HEIGHT - Tank.HEIGHT -2) y=TankFrame.GAME_HEIGHT-Tank.HEIGHT-2;
    }

    public void fire() {
        int bX = this.x +  Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
       tf.bulletList.add(new Bullet(bX,bY,this.dir,this.group,this.tf));
       if(this.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
    public void rankDir(){
        dir = Dir.values()[random.nextInt(4)];
    }

    public void die() {
        this.live = false;
    }
}
