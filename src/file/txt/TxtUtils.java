package file.txt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Text文本进行读写操作
 * User: dkm
 */


public class TxtUtils {

    public static boolean createFile(File fileName){

        boolean flag = false;

        try {
            if(!fileName.exists()){
                fileName.createNewFile();
            }

            flag = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  flag;

    }


    /**
     * 字符串写入Text
     * @param content
     * @param file
     * @return
     */
    public static boolean writeTxtFile(String content,File file){

       if(!createFile(file)){
           return false;
       }
        boolean flag = false;
        FileOutputStream  fos = null;

        try {

            fos = new FileOutputStream(file);
            fos.write(content.getBytes());
            flag = true;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fos != null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  flag;
    }


    public static boolean writeTxtFile(char[][] content,File file){
        boolean flag = false;

        FileOutputStream fos = null;

        return  flag;
    }


}
