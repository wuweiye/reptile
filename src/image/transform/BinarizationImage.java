package image.transform;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 二值化
 */
public class BinarizationImage extends GrayImage{

    public static BufferedImage getBinarizate(String path) throws IOException {



        BufferedImage image = ImageIO.read(new File(path));
        int h = image.getHeight();
        int w = image.getWidth();
        int arr[][] = new int[w][h];

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                final int color = image.getRGB(i, j);
                final int r = (color >> 16) & 0xff;
                final int g = (color >> 8) & 0xff;
                final int b = color & 0xff;
                int gray = (int) (0.39 * r + 0.5 * g + 0.11 * b);;
                arr[i][j] = gray;

            }
        }

        BufferedImage bufferedImage=new BufferedImage(w, h, BufferedImage.TYPE_BYTE_BINARY);
        int FZ=130;
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                if(getGray(arr,i,j,w,h)>FZ){
                    int black=new Color(255,255,255).getRGB();
                    bufferedImage.setRGB(i, j, black);
                }else{
                    int white=new Color(0,0,0).getRGB();
                    bufferedImage.setRGB(i, j, white);
                }

            }
        }

        return bufferedImage;
    }

    //自己加周围8个灰度值再除以9，算出其相对灰度值
    public static int  getGray(int gray[][], int x, int y, int w, int h) {
        int rs = gray[x][y]
                + (x == 0 ? 255 : gray[x - 1][y])
                + (x == 0 || y == 0 ? 255 : gray[x - 1][y - 1])
                + (x == 0 || y == h - 1 ? 255 : gray[x - 1][y + 1])
                + (y == 0 ? 255 : gray[x][y - 1])
                + (y == h - 1 ? 255 : gray[x][y + 1])
                + (x == w - 1 ? 255 : gray[x + 1][ y])
                + (x == w - 1 || y == 0 ? 255 : gray[x + 1][y - 1])
                + (x == w - 1 || y == h - 1 ? 255 : gray[x + 1][y + 1]);
        return rs / 9;
    }


    /**
     * 转化灰度图
     * @param sourcePath
     * @param transformPath
     */
    public static void transform(String sourcePath,String transformPath){

        String suffix = transformPath.substring(transformPath.lastIndexOf(".")+1);
        BufferedImage image = null;
        try {
            image = getBinarizate(sourcePath);
            File outputFile = new File(transformPath);
            ImageIO.write(image, suffix, outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
