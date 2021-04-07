package com.wu.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMrg {
    public static BufferedImage tankL,tankR,tankU,tankD;
    static {
        try {
            tankL = ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankR = ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tankD = ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            tankU = ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
