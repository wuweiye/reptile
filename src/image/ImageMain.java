package image;

import image.transform.BinarizationImage;
import image.transform.GrayImage;
import image.transform.GrayImageToTxt;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageMain {





    public static void main(String[] args){

        String path = "C:\\Users\\001\\Pictures\\Saved Pictures\\";

        String name = "2.jpg";


        GrayImage.transform(path + name,path + "gray2" + name);

        //BinarizationImage.transform(path+ name,path + "bin" + name);

        System.out.println("over");


    }
}
