package algorithm.littleData;


/***
 * 冒泡排序
 *  空间复杂度 O（1） ：冒泡排序是原地排序
 *  时间复杂度O（N^2）
 *  稳定算法排序： 稳定
 *  实现方法： 在每轮中将最大或最小元素（通常最大） 移动到数组底部
 *  优化方法：在冒泡排序中，每一轮中 必然有一个元素移动到正确的位置
         当某一轮中 没有发生元素位置的交换 此时 所有元素顺序已经全部正确 不用再继续执行冒泡排序
 *
 * 时间复杂度： 最好情况下O（N） 平均情况O(N^2) 最坏情况O（N^2）
 */
public class BubbleSort {

    /**
     *
     * @param array 数组
     * @param n  长度
     * @return
     */
    public static int[] bubbleSort(int[] array, int n){

        for(int i = 0; i< n ; i++){

            for(int j = 0; j < n - 1 -i; j++){

                if(array[j] > array[j+1]){
                    int num = array[j];
                    array[j] = array[j+1];
                    array[j+1] = num;
                }
            }
        }

        return array;
    }

    /**
     *
     * @param array
     */
    public static void bubbleSort(int[] array){

        int n = array.length;
        if (n <= 1){
            return;
        }

        for(int i= 0;i< n;i++){
            boolean flag = false;
            for (int j = 0; j< n-i-1;j++){

                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }

            if (!flag) break;
        }


    }

    public static void main(String[] args){

        int[] array = new int[]{2,1,3,1,2,3};

        bubbleSort(array);

        for(int i = 0; i< array.length; i++){

            System.out.print(array[i] + " ");
        }

    }
}
