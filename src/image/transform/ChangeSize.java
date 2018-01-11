package image.transform;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;


/**
 * 改变图片大小
 */

public class ChangeSize {

    private static final int WIDTH = 100;  //默认宽度
    private static final int HEIGHT = 100; //默认长度

    private static final String PATH = "D:\\12.jpg";


    public static BufferedImage changeSize(String path){

       return changeSize(path, WIDTH,HEIGHT);

    }

    public static BufferedImage changeSize(String path, Integer width, Integer height){


        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(path));
            Image bi = ImageIO.read(in);
            BufferedImage tag = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
            tag.getGraphics().drawImage(bi,0,0,width,height,null);

            return tag;
            /*BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(PATH+"copy.jpg"));
            ImageIO.write(tag,"jpg",out);
            in.close();
            out.close();
            System.out.println("success");*/
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            try {
                if(in != null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  null;

    }



    public static void main(String[] args){
        changeSize(PATH);
    }

}
