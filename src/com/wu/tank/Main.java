package com.wu.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String [] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
//        PropertyMgr p = new PropertyMgr();

        int initCount =Integer.parseInt((String)PropertyMgr.get("initCount"));
        for(int i=0;i<initCount;i++){
            tankFrame.tanks.add(new Tank(50 + i*80,200,Dir.DOWN,Group.BAD,tankFrame));
        }
        while(true){
            Thread.sleep(50);
            tankFrame.repaint();
        }

    }
}
