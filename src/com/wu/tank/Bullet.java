package com.wu.tank;

import java.awt.*;

/**
 * 子弹类
 */
public class Bullet {
    private int x,y;
    private Dir dir;
    private static final int SPEED = 10;
    private final int WIDTH = 5,HEIGHT = 5;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    //--------------------------setter and getter start--------------------------------------------
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
    //--------------------------setter and getter end--------------------------------------------
    public void paint(Graphics g){
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(color);
        move();
    }
    private void move(){
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
}
