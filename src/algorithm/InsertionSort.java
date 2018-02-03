package algorithm;

/**
 * 插入排序  O（n^2）
 *
 * 1.前俩数比较，大的放前面
 * 2.前3数比较 依次比较插入，直至前面数小
 * 3,重复2
 *
 */
public class InsertionSort {

    public static int[] insertionSort(int[] array, int n) {
            // write code here

        for(int i = 1; i< n ; i++){

            for(int j = i; j > 0; j --){
                if(array[j] < array[j-1]){
                    int num = array[j];
                    array[j] = array[j-1];
                    array[j-1] = num;
                }else {
                    break;
                }
            }
        }

        return  array;
    }

    public static void main(String[] args){

        int[] array = new int[]{2,1,3,1,2,3};

        array = insertionSort(array, array.length);

        for(int i = 0; i< array.length; i++){

            System.out.print(array[i] + " ");
        }

    }
}


