package com.wu.tank;

import java.awt.*;
import com.wu.tank.Audio;

/**
 * 爆炸类
 */
public class Explode {
    private int x,y;
    private Dir dir;
    private boolean live = true;
    private TankFrame tf;
    private int step = 0;
    public static int WIDTH = ResourceMrg.bufferedImageList.get(0).getWidth();
    public static int HEIGHT = ResourceMrg.bufferedImageList.get(0).getHeight();

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Thread(()->new Audio("audio/explode.wav").play()).start();
//        new Audio("audio/explode.wav").start();
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



    //--------------------------setter and getter end--------------------------------------------
    public void paint(Graphics g){
        g.drawImage(ResourceMrg.bufferedImageList.get(step++),x,y,null);
        if(step>=ResourceMrg.bufferedImageList.size()){
            step=0;
           tf.explodes.remove(this);
        }

    }

}
