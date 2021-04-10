package com.wu.tank;




import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResourceMrg {
    public static BufferedImage goodTankL,goodTankR,goodTankU,goodTankD;
    public static BufferedImage badTankL,badTankR,badTankU,badTankD;
    public static BufferedImage bulletL,bulletR,bulletU,bullelD;
    public static List<BufferedImage> bufferedImageList = new ArrayList();
    static {
        try {
            goodTankU = ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankL = ImageUtil.rotateImage(goodTankU,-90);
            goodTankR = ImageUtil.rotateImage(goodTankU,90);
            goodTankD = ImageUtil.rotateImage(goodTankU,180);
            badTankU = ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankL = ImageUtil.rotateImage(badTankU,-90);
            badTankR = ImageUtil.rotateImage(badTankU,90);
            badTankD = ImageUtil.rotateImage(badTankU,180);
            bulletU = ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletL = ImageUtil.rotateImage(bulletU,-90);
            bulletR = ImageUtil.rotateImage(bulletU,90);
            bullelD = ImageUtil.rotateImage(bulletU,180);
         for(int i=0;i<16;i++){
             bufferedImageList.add(ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif")));
         }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
