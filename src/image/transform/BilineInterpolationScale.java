package image.transform;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class BilineInterpolationScale {

    public static BufferedImage image;

    public BilineInterpolationScale(String filename) throws IOException {
        File f = new File(filename);
        image = ImageIO.read(f);
    }


    public static void sysLog(int x,int y,int srcW, int srcH, int destW, int destH) throws IOException {

        float rowRatio = ((float)srcH) / ((float)destH);
        float colRatio = ((float)srcW) / ((float)destW);

        double srcRow = ((float)y) * rowRatio;
        double j = Math.floor(srcRow);
        double srcCol = ((float)x) * colRatio;
        double k = Math.floor(srcCol);



        double t = srcRow - j;
        double u = srcCol - k;

        double coffiecent1 = (1.0d - t) * (1.0d - u);
        double coffiecent2 = (t) * (1.0d - u);
        double coffiecent3 = t * u;
        double coffiecent4 = (1.0d - t) * u;

        int x1 = getClip((int)j, srcH - 1, 0);
        int x2 = getClip((int)(j + 1), srcH - 1, 0);
        int x3 = getClip((int)(j + 1), srcH - 1, 0);
        int x4 = getClip((int)j, srcH - 1, 0);

        int y1 = getClip((int)k, srcW - 1, 0);
        int y2 = getClip((int)k, srcW - 1, 0);
        int y3 = getClip((int)(k + 1),srcW - 1, 0);
        int y4 = getClip((int)(k + 1),srcW - 1, 0);

        System.out.println("x:"+x1+",y="+y1);
        System.out.println("x:"+x2+",y="+y2);
        System.out.println("x:"+x3+",y="+y3);
        System.out.println("x:"+x4+",y="+y4);


        image = ImageIO.read(new FileInputStream(PATH));

        int ARGB = image.getRGB(x1,y1);
        int a1 = (ARGB >> 24) & 0xFF; // alpha
        int r1 = (ARGB >> 16) & 0xFF; // red
        int g1 = (ARGB >> 8) & 0xFF;  // green
        int b1 = (ARGB) & 0xFF;       // blue
         ARGB = image.getRGB(x2,y2);
        int a2 = (ARGB >> 24) & 0xFF; // alpha
        int r2 = (ARGB >> 16) & 0xFF; // red
        int g2 = (ARGB >> 8) & 0xFF;  // green
        int b2 = (ARGB) & 0xFF;       // blue
         ARGB = image.getRGB(x3,y3);
        int a3 = (ARGB >> 24) & 0xFF; // alpha
        int r3 = (ARGB >> 16) & 0xFF; // red
        int g3 = (ARGB >> 8) & 0xFF;  // green
        int b3 = (ARGB) & 0xFF;       // blue
         ARGB = image.getRGB(x4,y4);
        int a4 = (ARGB >> 24) & 0xFF; // alpha
        int r4 = (ARGB >> 16) & 0xFF; // red
        int g4 = (ARGB >> 8) & 0xFF;  // green
        int b4 = (ARGB) & 0xFF;       // blue


        int a = (int) (coffiecent1* a1 + coffiecent2 * a2 + coffiecent3 * a3 + coffiecent4 * a4);
        int r = (int) (coffiecent1* r1 + coffiecent2 * r2 + coffiecent3 * r3 + coffiecent4 * r4);
        int g = (int) (coffiecent1* g1 + coffiecent2 * g2 + coffiecent3 * g3 + coffiecent4 * g4);
        int b = (int) (coffiecent1* b1 + coffiecent2 * b2 + coffiecent3 * b3 + coffiecent4 * b4);


        System.out.println("result: a="+ a +",r="+ r + ",g=" + g + ",b="+ b);


    }






    public static int[][][] imgScale(int[] inPixelsData, int srcW, int srcH, int destW, int destH) {
        double[][][] input3DData = processOneToThreeDeminsion(inPixelsData, srcH, srcW);

        System.out.println(input3DData.length);
        int[][][] outputThreeDeminsionData = new int[destH][destW][4];
        float rowRatio = ((float)srcH) / ((float)destH);
        float colRatio = ((float)srcW) / ((float)destW);

        for(int row = 0; row < destH; row++) {

            double srcRow = ((float)row) * rowRatio;
            double j = Math.floor(srcRow);
            double t = srcRow - j;

            for(int col = 0; col < destW; col++) {

                double srcCol = ((float)col) * colRatio;
                double k = Math.floor(srcCol);
                double u = srcCol - k;

                double coffiecent1 = (1.0d - t) * (1.0d - u);
                double coffiecent2 = (t) * (1.0d - u);
                double coffiecent3 = t * u;
                double coffiecent4 = (1.0d - t) * u;

                for (int i = 0; i < 4; i++) {
                    outputThreeDeminsionData[row][col][i] = (int)(
                            coffiecent1 * input3DData[getClip((int)j, srcH - 1, 0)][getClip((int)k, srcW - 1, 0)][i] +
                                    coffiecent2 * input3DData[getClip((int)(j + 1), srcH - 1, 0)][getClip((int)k, srcW - 1, 0)][i] +
                                    coffiecent3 * input3DData[getClip((int)(j + 1), srcH - 1, 0)][getClip((int)(k + 1),srcW - 1, 0)][i] +
                                    coffiecent4 * input3DData[getClip((int)j, srcH - 1, 0)][getClip((int)(k + 1), srcW - 1, 0)][i]
                    );

                }
            }
        }

        System.out.println(outputThreeDeminsionData.length);
        //return convertToOneDim(outputThreeDeminsionData, destW, destH);
        return outputThreeDeminsionData;
    }

    private static int getClip(int x, int max, int min) {
        return x > max ? max : x < min ? min : x;
    }

    public static int[] convertToOneDim(int[][][] data, int imgCols, int imgRows) {
        int[] oneDPix = new int[imgCols * imgRows * 4];

        for (int row = 0, cnt = 0; row < imgRows; row++) {
            for (int col = 0; col < imgCols; col++) {

                oneDPix[cnt] =
                        ((data[row][col][0] << 24) & 0xFF000000)
                                | ((data[row][col][1] << 16) & 0x00FF0000)
                                | ((data[row][col][2] << 8) & 0x0000FF00)
                                | ((data[row][col][3]) & 0x000000FF);

                cnt++;
            }
        }
        return oneDPix;
    }

    private static double [][][] processOneToThreeDeminsion(int[] oneDPix2, int imgRows, int imgCols) {
        double[][][] tempData = new double[imgRows][imgCols][4];
        for(int row=0; row<imgRows; row++) {

            int[] aRow = new int[imgCols];
            for (int col = 0; col < imgCols; col++) {
                int element = row * imgCols + col;
                aRow[col] = oneDPix2[element];
            }

            for(int col = 0; col < imgCols; col++) {
                tempData[row][col][0] = (aRow[col] >> 24) & 0xFF; // alpha
                tempData[row][col][1] = (aRow[col] >> 16) & 0xFF; // red
                tempData[row][col][2] = (aRow[col] >> 8) & 0xFF;  // green
                tempData[row][col][3] = (aRow[col]) & 0xFF;       // blue
            }

        }
        return tempData;
    }

    private static int[] getARGB(File file) throws IOException {

        image = ImageIO.read(file);
        int w = image.getWidth();
        int h = image.getHeight();
        int[] array = new int[w*h];
        int k = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int ARGB = image.getRGB(j, i);
                array[k++] = ARGB;
            }
        }
        return array;
    }

    public static void toImage(int[][][] array,int w,int h) throws IOException {

        BufferedImage tag = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);

        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {

                int grayARGB =
                        ((array[row][col][0] << 24) & 0xFF000000)
                                | ((array[row][col][1] << 16) & 0x00FF0000)
                                | ((array[row][col][2] << 8) & 0x0000FF00)
                                | ((array[row][col][3]) & 0x000000FF);

                tag.setRGB(col,row,grayARGB);
            }
        }

        
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(PATH+"5.png"));
        ImageIO.write(tag,"png",out);

        out.close();
    }
    private static final String PATH = "E:\\123.png";

    public static void main(String[] args) throws IOException {

        image = ImageIO.read(new FileInputStream(PATH));
        int w = image.getWidth();
        int h = image.getHeight();
        int[] array = new int[w*h];
        int k = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int ARGB = image.getRGB(j, i);
                array[k++] = ARGB;
            }
        }
        //System.out.println("w*h="+ w*h);
        //System.out.println("array="+ array.length);

        int scaleW = (int) (w * 1.5);
        int scaleH = (int) (h * 1.5);

        int[][][] conArray =  imgScale(array, w, h, scaleW, scaleH);

        sysLog(965,121,w, h, scaleW, scaleH);

        //System.out.println("start");

        //System.out.println("conArray size" + conArray.length);
        //toImage(conArray,scaleW, scaleH);
        //System.out.println("over");
    }

}
