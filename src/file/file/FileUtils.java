package file.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 对文件夹的读取
 */
public class FileUtils {

    public static final  String REGEX = "(.jpg|.png)";


    public static List<File> getFiles(String path){

        return getFiles(path,null);
    }


    /**
     * 获取文件夹下所有文件
     * @param path
     * @param regex
     * @return
     */
    public static List<File> getFiles(String path,String regex){

        List<File> fileList = new ArrayList<>();

        File[] files = new File(path).listFiles();

        for (File file :files){

            if(regex == null){
                fileList.add(file);
            }else {
                if(file.getName().replaceAll(regex,"").length() != file.getName().length()){
                    fileList.add(file);
                }
            }

        }
        return  fileList;
    }


    public static void showFiles(List<File> files){

        for(File file :files){
            System.out.println(file.getName());
        }
    }


    public static void showTxt(File file){

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            StringBuffer result = new StringBuffer();
            String s = null;
            while ((s = reader.readLine())!= null){

                result.append(s +"\n");
            }
            out(result.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static void out(String print){
        System.out.println(print);
    }

    public static void main(String [] args){

        showFiles(getFiles("D:\\images"));
    }
}
