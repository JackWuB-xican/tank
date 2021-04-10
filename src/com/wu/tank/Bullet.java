package com.wu.tank;

import java.awt.*;

/**
 * 子弹类
 */
public class Bullet {
    private int x,y;
    private Dir dir;
    private boolean live = true;
    private TankFrame tf;
    private Group group = Group.BAD;
    private static final int SPEED = 10;
    public static int WIDTH = ResourceMrg.bullelD.getWidth();
    public static int HEIGHT = ResourceMrg.bullelD.getHeight();

    public Bullet(int x, int y, Dir dir,Group group,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    //--------------------------setter and getter end--------------------------------------------
    public void paint(Graphics g){
        if(!live){
            tf.bulletList.remove(this);
        }
        switch (dir){
            case RIGHT:
                g.drawImage(ResourceMrg.bulletR,x,y,null);
                break;
            case LEFT:
                g.drawImage(ResourceMrg.bulletL,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMrg.bullelD,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMrg.bulletU,x,y,null);
                break;
        }
//        Color color = g.getColor();
//        g.setColor(Color.RED);
//        g.fillOval(x,y,WIDTH,HEIGHT);
//        g.setColor(color);

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
        if(x<0 || y<0 || x>TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT){
            live = false;
        }
    }

    public void collideWith(Tank tank) {
        if(this.group == tank.getGroup()) return;
        Rectangle rec1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        Rectangle rec2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
        int eX = tank.getX() +  Tank.WIDTH/2 - Explode.WIDTH/2;
        int eY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
        if(rec1.intersects(rec2)){
           tank.die();
           this.die();
           tf.explodes.add(new Explode(eX,eY,tf));
        }
    }

    private void die() {
        this.live = false;
    }
}
