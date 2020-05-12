package image.transform;

import image.entity.ImageGray;

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


    public static void main(String[] args) {
        ImageGray imageGray = new ImageGray();
        int transA = 100;
        int transB = 200;
        int gray = imageGray.getGray(0,0);
        int transGray = transA + (int)((Double.valueOf((transB - transA)+"")/(imageGray.getMaxGray()- imageGray.getMinGray())*(gray - imageGray.getMinGray())));

        System.out.println("原灰度：" + gray +" 转换后灰度" + transGray);
        int newPixel = colorToRGB(255, transGray, transGray, transGray);

        System.out.println("RGB:" + newPixel);
        //transGray(100,200,imageGray);

    }


    protected static int colorToRGB(int alpha, int red , int green, int blue){
        int newPixel = 0;
        /*newPixel += alpha;
        newPixel = newPixel << 8;*/
        newPixel += red;
        newPixel = newPixel << 8;
        newPixel += green;
        newPixel = newPixel << 8;
        newPixel += blue;

        return newPixel;
    }


    /**
     * 灰度线性转换
     * @param transA
     * @param transB
     */
    public static void transGray(int transA,int transB,ImageGray imageGray){

        for(int i=0; i< imageGray.getWeight();i++){
            for(int j = 0; j< imageGray.getHeight(); j++){

                int gray = imageGray.getGray(i,j);
                int transGray = transA + (int)((Double.valueOf((transB - transA)+"")/(imageGray.getMaxGray()- imageGray.getMinGray())*(gray - imageGray.getMinGray())));
                System.out.println("原灰度：" + gray +"- 转换后灰度" + transGray);
                imageGray.getGrayArray()[i][j] = transGray;
            }
        }


    }




    public static BufferedImage grayWeighImage(String path){
        try {

            BufferedImage image = ImageIO.read(new File(path));
            BufferedImage grayImage = new BufferedImage(image.getWidth(),image.getHeight(),image.getType());

            ImageGray imageGray = new ImageGray(image);

            System.out.println("当前灰度范围：[" + imageGray.getMinGray() +"," + imageGray.getMaxGray() + "]");

            transGray(0,255,imageGray);

            for (int i = 0; i < image.getWidth(); i++) {
                for (int j = 0; j < image.getHeight(); j++) {

                    int gray = imageGray.getGray(i,j);
                    int newPixel = colorToRGB(255, gray, gray, gray);
                    grayImage.setRGB(i, j, newPixel);
                }
                //System.out.println("");
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


    /**
     * 转化灰度图
     * @param sourcePath
     * @param transformPath
     */
    public static void transform(String sourcePath,String transformPath){

        String suffix = transformPath.substring(transformPath.lastIndexOf(".")+1);
        BufferedImage image =  GrayImage.grayWeighImage(sourcePath);
        File outputFile = new File(transformPath);

        try {
            ImageIO.write(image, suffix, outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
