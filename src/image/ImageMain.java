package image;

import image.transform.GrayImage;
import image.transform.GrayImageToTxt;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageMain {





    public static void main(String[] args){


        BufferedImage image =  GrayImage.grayWeighImage("D:\\222.png");



        File outputfile = new File("D:\\222gray.png");

        try {
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
