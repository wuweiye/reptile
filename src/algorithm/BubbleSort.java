package algorithm;

public class BubbleSort {


    public static int[] bubbleSort(int[] array){


        for(int i = 0; i< array.length ; i++){


            for(int j = 0; j < array.length - 1 -i; j++){

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


    public static void main(String[] args){

        int[] array = new int[]{2,1,3,1,2,3};

        array = bubbleSort(array, array.length);

        for(int i = 0; i< array.length; i++){

            System.out.print(array[i] + " ");
        }

    }
}
