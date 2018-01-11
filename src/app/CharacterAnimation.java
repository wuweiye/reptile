package app;

import file.file.FileUtils;
import image.transform.ChangeSize;
import image.transform.GrayImage;
import image.transform.GrayImageToTxt;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterAnimation {


    public static final String TXT_PATH = "D://text";

    public static void main(String[] args){

        List<File> files = FileUtils.getFiles("D://images","(.jpg|.png)");

       Map<String,BufferedImage> map = getFixedSizeImages(files);

       writeText(map);


       List<File> txtFiles = FileUtils.getFiles(TXT_PATH,"(.txt)");
       showTxt(txtFiles);

    }

    private static void showTxt(List<File> txtFiles) {

        for(File file :txtFiles){
            FileUtils.showTxt(file);

            break;
        }



    }

    private static void writeText(Map<String,BufferedImage> map) {

        for(Map.Entry<String,BufferedImage> entry : map.entrySet()){

            GrayImageToTxt.write(entry.getValue(),TXT_PATH,entry.getKey());

        }

    }

    private static Map<String,BufferedImage> getFixedSizeImages(List<File> files) {

      /*  List<BufferedImage> bufferedImages = new ArrayList<>();*/



        Map<String,BufferedImage> map = new HashMap<String,BufferedImage>();

        for(File file :files){
          BufferedImage image =   ChangeSize.changeSize(file.getPath());

          if(image != null){
              BufferedImage grayImage = GrayImage.getGrayImage(image);
              if(grayImage !=null){

                  map.put(file.getName(),grayImage);
              }

          }
        }

        return map;
    }


}
