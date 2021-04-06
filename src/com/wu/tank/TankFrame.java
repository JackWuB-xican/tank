package com.wu.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    Tank myTank = new Tank(200,200,Dir.DOWN);
    private static final int SPEED = 10;
    Dir dir = Dir.DOWN;
     public TankFrame(){
         this.setSize(600,400);
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
     @Override
     public void paint(Graphics g){
         myTank.paint(g);
//         g.fillRect(x,y,50,50);
//         x+=10;
//         y+=10;
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
         }
         public void setMainTankDir(){
             if(bL) myTank.setDir(Dir.LEFT);
             if(bR) myTank.setDir(Dir.RIGHT);
             if(bU) myTank.setDir(Dir.UP);
             if(bD) myTank.setDir(Dir.DOWN);
         }
     }
}
