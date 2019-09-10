package algorithm.five;

import java.util.ArrayList;
import java.util.List;

/**
 * 贪心算法
 * 五大常用算法之一
 *
 * -- 贪心算法在某种意义上是局部是最优
 *
 * 现在 以01背包问题开始
 *
 * 01背包是在M件物品取出若干件放在空间为W的背包里，每件物品的体积为W1，W2至Wn，
 * 与之相对应的价值为P1,P2至Pn。01背包是背包问题中最简单的问题。01背包的约束条件是给定几种物品，
 * 每种物品有且只有一个，并且有权值和体积两个属性。
 * 在01背包问题中，因为每种物品只有一个，对于每个物品只需要考虑选与不选两种情况。
 * 如果不选择将其放入背包中，则不需要处理。如果选择将其放入背包中，由于不清楚之前放入的物品占据了多大的空间，
 * 需要枚举将这个物品放入背包后可能占据背包空间的所有情况
 *
 *
 */

public class greedyAlgorithm {


    class Item {
        private int weight;
        private int value;

        public Item(int weight,int value){
            this.value = value;
            this.weight = weight;
        }
    }

    class Bag{

        private int totalWeight;
        private int totalValue;
        private int maxWeight;
        private int wi;
        private int count;

        private List<Item> items;

        public Bag(){
            totalWeight = 0;
            totalValue = 0;
            wi =totalValue/totalWeight;
            count = 0;
            items = new ArrayList<>();

        }

        public boolean put(Item item){
            if (totalWeight==0)


            items.add(item);


            return  true;

        }

    }


    public static int bagSize = 10;
    //public static int[] bg = new ;
    public static int[] cost = {1 , 2 , 5 , 3 , 10 , 4};
    public static int[] size = {1 , 2 , 5 , 3 , 10 , 4};


    public static void sort(int[] array,int[] array2){

        for (int i= 0;i< array.length;i++){
            int value = Integer.MAX_VALUE;
            int temp = 0;
            for (int j = i;j< array.length;j++){

                if (array[j]< value){
                    value = array[j];
                    temp = j;
                }
            }

            if (temp!=i){
                array[temp] = array[i];
                array[i] = value;

                //数组2 保持同步
                int value2 = array2[temp];
                array2[temp] = array2[i];
                array2[i] = value2;
            }

        }

    }

   // public static void greedy()


    public static void main(String[] args){

        // 1.1 选取价值最大者 cost
        sort(cost,size);



    }
}
