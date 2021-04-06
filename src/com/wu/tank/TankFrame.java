package com.wu.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    Tank myTank = new Tank(200,200,Dir.DOWN);
    Bullet bullet = new Bullet(300,300,Dir.DOWN);
    static final int GAME_WIDTH = 800,GAME_HEIGHT = 600;
     public TankFrame(){
         this.setSize(GAME_WIDTH,GAME_HEIGHT);
         this.setTitle("Tank war");
         this.setResizable(false);
         this.setVisible(true);
         this.addKeyListener(new MyKeyListener());
         this.addWindowListener(new WindowAdapter() {
             @Override
             public void windowClosing(WindowEvent e) {
                 System.exit(0);
             }
         });
     }
    Image offScreenImage = null;
    @Override
    /**
     * 双缓冲发处理闪烁
     */
    public void update(Graphics g){
        if(offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics goffScreenImage = offScreenImage.getGraphics();
        Color color = goffScreenImage.getColor();
        goffScreenImage.setColor(Color.BLACK);
        goffScreenImage.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        goffScreenImage.setColor(color);
        paint(goffScreenImage);
        g.drawImage(offScreenImage,0,0,null);
    }
     @Override
     public void paint(Graphics g){
         myTank.paint(g);
         bullet.paint(g);
     }

     class MyKeyListener extends KeyAdapter {
         boolean bL = false;
         boolean bR = false;
         boolean bU = false;
         boolean bD = false;
         @Override
         public void keyPressed(KeyEvent e) {
             int keyCode = e.getKeyCode();
             switch (keyCode){
                 case KeyEvent.VK_LEFT:
                     bL = true;
                     break;
                 case KeyEvent.VK_RIGHT:
                     bR = true;
                     break;
                 case KeyEvent.VK_UP:
                     bU = true;
                     break;
                 case KeyEvent.VK_DOWN:
                     bD = true;
                     break;
                 default:break;
             }
             setMainTankDir();
//             x+=10;
//             repaint();
         }

         @Override
         public void keyReleased(KeyEvent e) {
             int keyCode = e.getKeyCode();
             switch (keyCode){
                 case KeyEvent.VK_LEFT:
                     bL = false;
                     break;
                 case KeyEvent.VK_RIGHT:
                     bR = false;
                     break;
                 case KeyEvent.VK_UP:
                     bU = false;
                     break;
                 case KeyEvent.VK_DOWN:
                     bD = false;
                     break;
                 default:break;
             }
             setMainTankDir();
         }
         public void setMainTankDir(){
             if(!bL && !bR && !bD && !bU){
                 myTank.setMoving(false);
             }else {
                 myTank.setMoving(true);
                 if (bL) myTank.setDir(Dir.LEFT);
                 if (bR) myTank.setDir(Dir.RIGHT);
                 if (bU) myTank.setDir(Dir.UP);
                 if (bD) myTank.setDir(Dir.DOWN);
             }
         }
     }
}
