package algorithm.ManyData;


/**
 * 归并排序
 * 1.俩俩分组排序
 * 2.扩大俩俩分组排序
 *
 * 时间复杂度O(N * aaaaawLog N)
 */
public class MergeSort {

    public static int[] mergeSort(int[] array, int n) {



        sort(array,0,n-1);

        return  array;
    }

    private static void sort(int[] array, int left, int right) {

        System.out.println("1:  " +left+ " .... "+right);
        if(left < right){
            int middle = (left + right) /2;
            sort(array, left, middle);
            System.out.println("2:  " +left+ " .... "+middle + " ..... "+right);
            sort(array,middle +1,right);

            System.out.println("3:  " +left+ " .... "+middle + " ..... "+right);

            merge(array,left,middle,right);
        }

    }

    private static void merge(int[] array, int left, int middle, int right) {

        int[] tempArray = new int[right -left +1];

        int leftIndex = left;

        int rightIndex = middle +1;

        int tempIndex = 0;

        while(leftIndex  <= middle && rightIndex <= right){
            if(array[leftIndex] < array[rightIndex]){
                tempArray[tempIndex++] = array[leftIndex++];
            }else {
                tempArray[tempIndex++] = array[rightIndex++];
            }
        }


        while (leftIndex <= middle){
            tempArray[tempIndex++] = array[leftIndex++];
        }

        while (rightIndex <= right){
            tempArray[tempIndex++] = array[rightIndex++];
        }

        int temp = 0;

        while ((temp + left) <= right){
            array[left + temp] = tempArray[temp];
            temp++;
        }

    }

    public static void main(String[] args){

        int[] array = new int[]{2,1,3,1,2,3};

        array = mergeSort(array, array.length);

        for(int i = 0; i< array.length; i++){

            System.out.print(array[i] + " ");
        }

    }


}
