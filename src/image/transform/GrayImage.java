package image.transform;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 图片转换成灰度图
 * grayWeighImage 加权灰度图 ARGB
 * grayImage  普通转为灰度图 RGB
 */

public class GrayImage {


    private static int colorToRGB(int alpha, int red , int green, int blue){
        int newPixel = 0;
        newPixel += alpha;
        newPixel = newPixel << 8;
        newPixel += red;
        newPixel = newPixel << 8;
        newPixel += green;
        newPixel = newPixel << 8;
        newPixel += blue;

        return newPixel;
    }

    public static BufferedImage grayWeighImage(String path){
        try {

            BufferedImage image = ImageIO.read(new File(path));
            BufferedImage grayImage = new BufferedImage(image.getWidth(),image.getHeight(),image.getType());

            for (int i = 0; i < image.getWidth(); i++) {
                for (int j = 0; j < image.getHeight(); j++) {
                    final int color = image.getRGB(i, j);
                    final int r = (color >> 16) & 0xff;
                    final int g = (color >> 8) & 0xff;
                    final int b = color & 0xff;
                    int gray = (int) (0.3 * r + 0.59 * g + 0.11 * b);;
                    int newPixel = colorToRGB(255, gray, gray, gray);
                    grayImage.setRGB(i, j, newPixel);
                }
            }


           return grayImage;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }


    public static BufferedImage grayImage(String path){
        try {
            BufferedImage image = ImageIO.read(new File(path));
            return getGrayImage(image);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static BufferedImage getGrayImage(BufferedImage image){

        try {
            BufferedImage grayImage = new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_BYTE_GRAY);

            for(int i = 0; i < image.getWidth(); i++){
                for(int j = 0; j < image.getHeight(); j++){
                    int rgb = image.getRGB(i,j);
                    grayImage.setRGB(i,j,rgb);
                }
            }

            return grayImage;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return  null;
    }
}
