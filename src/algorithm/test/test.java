package algorithm.test;

import java.lang.reflect.Array;

public class test {


    /**
     * 排序 小写字母在前 数字在中间 大写字母在最后 小写，数字大写之间无排序
     * @param args
     */
    public static void main(String[] args){

        String[] strings = new String[]{"8","2","g","J","g","J","g","J","6","O","L","d","8","2","g","J","6","O","L","d","8","2","g","J","6","O","L","d"};

        sort(strings);


        for(int i = 0; i< strings.length; i++){

            System.out.print(strings[i] + " ");
        }
    }

    private static void sort(String[] strings) {

        int rightIndex = strings.length -1;
        int leftStart = 0;
        int cursor = 0;

        for (; cursor< strings.length;cursor++){

            if (cursor > rightIndex){
                return;
            }

            if (leftStart > cursor){
                return;
            }

            Character character = strings[cursor].toCharArray()[0];
            if (Character.isDigit(character)){

            }else if (Character.isLowerCase(character)){

                String s = character.toString();
                strings[cursor] = strings[leftStart];
                strings[leftStart++] = s;
                cursor--;

            }else {
                String s = character.toString();
                strings[cursor] = strings[rightIndex];
                strings[rightIndex--] =s;
                cursor--;
            }

        }
    }
}
