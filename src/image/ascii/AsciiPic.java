package image.ascii;

import image.transform.GrayImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

import static javax.imageio.ImageIO.read;

public class AsciiPic {


    public static void createAsciiPic(String path){

        String base ="@#&$%*o!;.";

        try {
            BufferedImage image  = ImageIO.read(new File(path));

            char[][] css = new char[image.getWidth()][image.getHeight()];

            for(int y = 0; y < image.getHeight() ; y ++){
                for(int x = 0; x < image.getWidth(); x ++){
                    int pixel = image.getRGB(x,y);


                    int r = (pixel &  0xff0000) >> 16, g = (pixel &  0xff00) >> 8, b =  (pixel &  0xff);
                    float gray = 0.299f * r +0.578f * g + 0.114f * b;
                    int index  = Math.round(gray * (base.length() +1)/255);
                    System.out.print(index >= base.length() ? " " :String.valueOf(base.charAt(index)));

                    css[x][y] = base.charAt(index);
                }
                System.out.println();
            }
        } catch (Exception e){

            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        GrayImage.grayWeighImage("D:\\images/原图.jpg");
    }
}
