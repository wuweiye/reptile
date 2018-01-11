package algorithm;

public class binarySearch {


    /**
     * 二分查找（正常）
     * @param array
     * @param key
     * @return
     */

    public static int binarySearch(int[] array, int key){
        int left = 0;
        int right = array.length -1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(array[mid] == key){
                return  mid;
            }else if(array[mid] <key){
                left = mid +1;
            }else {
                right = mid -1;
            }
        }
        return -1;
    }

  //查找重复数字第一个
    static int findFirstEqual(int[] array,int key){
        int left = 0;
        int right = array.length -1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(array[mid] >= key){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        if(left < array.length && array[left] == key){
            return left;
        }

        return -1;

    }


    //查找重复数字最后一个
    static int findLastEqual(int[] array,int key){
        int left = 0;
        int right = array.length -1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(array[mid] <= key){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }

        if(right < array.length && array[right] == key){
            return right;
        }

        return -1;

    }

   //查找最后一个等于或者小于key的元素
    static int findLastEqualSmaller(int[] array ,int key){
        int left = 0;
        int right = array.length -1;

        while (left <= right){
            int mid = (left + right) / 2;

            if(array[mid]  > key ){
                right = mid -1;

            }else {
                left = mid +1;
            }
        }

        return  right;
    }

    // 查找最后一个小于key的元素
    static int findLastSmaller(int[] array ,int key){
        int left = 0;
        int right = array.length -1;

        while (left <= right){

            int mid = (  right +left) / 2;
            if(array[mid]  < key ){
                left = mid +1;
            }else {
                right = mid -1;
            }
        }

        return  right;
    }

//查找第一个大于key的元素
    static int findFirstLarger(int[] array, int key) {

        int left = 0;
        int right = array.length -1;

        while (left <= right){

            int mid = (  right +left) / 2;
            if(array[mid]  > key ){
                right = mid -1;

            }else {
                left = mid +1;
            }
        }
        if(array[left] > key){
            return left;
        }

        return  -1;
    }

    public static void main(String[] args){

        int[] array = new int[]{1,2,3};
        int i = findFirstLarger(array,3);

        if(i != -1){
            System.out.println("get :"+ i);
        }else{
            System.out.println("no find");
        }
    }




}
