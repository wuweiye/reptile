package image.transform;

import file.txt.TxtUtils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;

public class GrayImageToTxt {


    public static void write(BufferedImage image,String txtPath ,String imageName){


        String name = imageName.split("\\.")[0]+".txt";
        File file = new File(txtPath+"/"+name);
        BufferedReader reader = null;
        StringBuffer buffer = new StringBuffer();
        for(int y = 0; y < image.getHeight() ; y ++){

            for(int x = 0; x < image.getWidth(); x ++){
                int rgb = image.getRGB(x,y);

                int r = (rgb & 0xff0000) >> 16;
                int g = (rgb & 0xff00) >> 8;
                int b = (rgb & 0xff);
                int gray = (int)(r * 0.3 + g * 0.59 + b * 0.11);    //计算灰度值

                if(gray < 150){
                    buffer.append("M");
                }else {
                    buffer.append(" ");
                }

            }
            buffer.append("\n");
        }

        //输出到txt
        TxtUtils.writeTxtFile(buffer.toString(),file);


    }
}
