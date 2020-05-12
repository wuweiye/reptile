package image.entity;


import java.awt.image.BufferedImage;

public class ImageGray {

    /**
     * 灰度集合
     */
    int[][] grayArray;

    Integer weight;


    Integer height;

    Integer maxGray = 0;

    Integer minGray = 255;

    public ImageGray(){
        weight = 1;
        height = 1;
        grayArray = new int[weight][height];
        maxGray = 255;
        minGray = 0;
        setGray(0,0,200);
    }

    public ImageGray(BufferedImage image) {

        weight = image.getWidth();
        height = image.getHeight();
        grayArray = new int[weight][height];


        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                final int color = image.getRGB(i, j);
                final int r = (color >> 16) & 0xff;
                final int g = (color >> 8) & 0xff;
                final int b = color & 0xff;

                System.out.print(color + " ");
                int gray = (int) (0.39 * r + 0.5 * g + 0.11 * b);
                setGray(i,j,gray);
            }
            System.out.println();
        }
    }

    public void setGray(int i,int j ,int gray){
        grayArray[i][j] = gray;
        if (maxGray<gray){
            maxGray = gray;
        }
        if (minGray > gray){
            minGray = gray;
        }
    }

    public int getGray(int i,int j){
        if (grayArray == null){
            return 0;
        }
        return grayArray[i][j];
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }



    public int[][] getGrayArray() {
        return grayArray;
    }

    public void setGrayArray(int[][] grayArray) {
        this.grayArray = grayArray;
    }

    public int getMaxGray() {
        return maxGray;
    }

    public void setMaxGray(int maxGray) {
        this.maxGray = maxGray;
    }

    public int getMinGray() {
        return minGray;
    }

    public void setMinGray(int minGray) {
        this.minGray = minGray;
    }
}
