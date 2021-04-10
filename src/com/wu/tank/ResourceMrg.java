package com.wu.tank;




import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResourceMrg {
    public static BufferedImage tankL,tankR,tankU,tankD;
    public static BufferedImage bulletL,bulletR,bulletU,bullelD;
    public static List<BufferedImage> bufferedImageList = new ArrayList();
    static {
        try {
            tankU = ImageIO.read(ResourceMrg.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            tankL = ImageUtil.rotateImage(tankU,-90);
            tankR = ImageUtil.rotateImage(tankU,90);
            tankD = ImageUtil.rotateImage(tankU,180);
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
