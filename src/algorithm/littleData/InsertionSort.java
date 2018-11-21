package algorithm.littleData;

/***
 * 插入排序
 *  空间复杂度 O（1） ：插入排序是原地排序
 *  时间复杂度O（N^2）
 *  稳定算法排序： 稳定
 *  实现方法： 1.前俩数比较，大的放前面
              2.前3数比较 依次比较插入，直至前面数小
              3,重复2
 *
 * 时间复杂度： 最好情况下O（N） 平均情况O(N^2) 最坏情况O（N^2）
 */
public class InsertionSort {

    public static void insertionSort(int[] array, int n) {
            // write code here

        if (n<=1) return ;


        for(int i = 1;i < n; i++){

            int value = array[i];
            int j = i-1;
            for (;j>=0; j--){
                if (array[j] > value){
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }

            array[j+1] =value;

        }

    }

    public static void main(String[] args){

        int[] array = new int[]{2,1,3,1,2,3};

         insertionSort(array, array.length);

        for(int i = 0; i< array.length; i++){

            System.out.print(array[i] + " ");
        }

    }
}


