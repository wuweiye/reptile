package algorithm.test;

/**
 * 二分 查找
 *
 *
 * 优化： 当数据量较大时 取中间数优化
 */
public class BinarySearch {


    private static int bsearch(int[] array,int value){

        int start = 0;
        int end = array.length -1;

        while (start <= end){

            //int middle = (end + start)/2;
            //int middle =  start + (end - start)/2;
            int middle = start + ((end - start) >> 1);
            int temp = array[middle];
            if (value == temp){

                return middle;
            }else if (value > temp){
                start= middle +1;
            }else {
                end = middle - 1;
            }

        }

        return -1;
    }


    /**
     * 二分法 开方
     * @param t
     * @param precise
     * @return
     */
    public static double sqrt(double t, Double precise) {
        double low = 0, high = t, middle, squre,
                prec = precise != null ? precise : 1e-7;
        if ( t < 0 ) {
            throw new RuntimeException("Negetive number cannot have a sqrt root.");
        }

        while ( high - low > prec ) {
            middle = ( low + high ) / 2;
            squre = middle * middle;

            if ( squre > t ) {
                high = middle;
            } else {
                low = middle;
            }
        }
        return ( low + high ) / 2;
    }


    public static void main(String[] args){
        int[] array = new int[]{1,2,3};
        int i = bsearch(array,3);

        if(i != -1){
            System.out.println("get :"+ i);
        }else{
            System.out.println("no find");
        }

        double ll = sqrt(44,null);

        System.out.println(ll);

    }
}
