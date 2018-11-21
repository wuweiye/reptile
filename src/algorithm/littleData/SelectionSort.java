package algorithm.littleData;

/**
 * 选择排序
 * 1.选取最小的数放在首位
 * 2.继续步奏
 *
 * 时间复杂度O(N^2)
 */
public class SelectionSort {

    public static int[] selectionSort(int[] array, int n) {
        int temp = 0;
        for(int i = 0; i < n; i++){
            int value = Integer.MAX_VALUE;
            int j = i;
            for(; j < n; j++){

                if(array[j] < value){
                    temp = j;
                    value = array[j];
                }


            }
            if (j!= i){
                array[temp] = array[i];
                array[i] = value;
            }


        }



        return  array;
    }
    public static void main(String[] args){

        int[] array = new int[]{6,5,4,3,2,1,0};

        array = selectionSort(array, array.length);

        for(int i = 0; i< array.length; i++){

            System.out.print(array[i] + " ");
        }

    }



}
