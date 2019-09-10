package algorithm.ManyData;


/**
 * 快排
 *
 * 实现原理：
 *    1.选取一个位置 开始遍历 将小于此数放左边 大于次数放右边 最后获取此数最后位置p
 *    1.1 然后根据p 对两边数据继续按1步骤操作
 *
 *   稳定性： 不稳定
 *   时间复杂度 nlog(n)
 *   空间复杂度O(1) 在交换时 采用原地完成分区（数组交换） 可以达到空间复杂度为O(1)
 *
 */
public class QuickSort {

    public static void main(String[] args){

        int[] array = new int[]{2,1,3,1,2,3,5,6,7,8,9};

        quickSort(array, array.length);

        for(int i = 0; i< array.length; i++){

            System.out.print(array[i] + " ");
        }

    }

    private static void quickSort(int[] array, int length) {

        sort(array,0,length-1);
    }

    private static void sort(int[] array, int left, int right) {

        if (left>= right){
            return;
        }


        int  position = swap(array,left,right);
        System.out.println(position);
        sort(array,left,position-1);
        sort(array,position+1,right);

    }

    private static int swap(int[] array, int left, int right) {
        int position = right;
        int value = array[position];

        int j = left;
        for (int i = left;i<  position;i++){

            if (array[i] < value){
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                j++;
            }
        }

        array[right] = array[j];
        array[j] = value;
        return j;

    }

}
