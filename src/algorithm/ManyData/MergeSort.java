package algorithm.ManyData;


/**
 * 归并排序
 * 1.数组从中间分成两部分
 * 1.1  递归到最后 分为两个单个元素
 * 1.2  开始排序 并回收结果 （所以两部分 数组都是有序的）
 * 1.3  对两个数组 合并 并且反回
 *
 * 采用思想：分治思想
 * 稳定性: 稳定
 *
 * 时间复杂度O(nlogn)
 * 空间复杂度 (O(N))
 */
public class MergeSort {

    public static void mergeSort(int[] array, int n) {

        recursion(array,0,n-1);

    }


    private static  void recursion(int[] array, int left, int right){

        if (left >= right){
            return;
        }

        int  middle = (left + right)/2;
        recursion(array,left, middle);
        recursion(array,middle+1, right);

        sortMerge(array,left,middle,right);

    }

    private static void sortMerge(int[] array, int left, int middle, int right) {

        int[] array2 = new int[right-left +1];

        int leftIndex = left;
        int rightIndex = middle+1;
        int tempIndex = 0;

        while (leftIndex<=middle && rightIndex <= right){
            if (array[leftIndex] < array[rightIndex]){
                array2[tempIndex++] = array[leftIndex++];
            }else {
                array2[tempIndex++] = array[rightIndex++];
            }
        }

        while (leftIndex<= middle){
            array2[tempIndex++] = array[leftIndex++];
        }

        while (rightIndex <= right){
            array2[tempIndex++] = array[rightIndex++];
        }
        int temp = 0;
        while ((temp + left) <= right){
            array[(temp+ left)] = array2[temp++];
        }

    }





    public static void main(String[] args){

        int[] array = new int[]{2,1,3,1,2,3,5,6,7,8,9};

        mergeSort(array, array.length);

        for(int i = 0; i< array.length; i++){

            System.out.print(array[i] + " ");
        }

    }


}
