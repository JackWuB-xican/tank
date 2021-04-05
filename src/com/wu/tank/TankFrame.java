package com.wu.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    int x=200;
    int y=200;
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
         System.out.println("paint");
         g.fillRect(x,y,50,50);
         x+=10;
//         y+=10;
     }
     class MyKeyListener extends KeyAdapter {
         @Override
         public void keyPressed(KeyEvent e) {
             System.out.println("keyPressed");
             x+=10;
//             repaint();
         }

         @Override
         public void keyReleased(KeyEvent e) {
             System.out.println("keyPressed");
         }
     }
}
