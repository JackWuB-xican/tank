package com.wu.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {
    public static void main(String [] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        while(true){
            Thread.sleep(50);
            tankFrame.repaint();
        }

    }
}
