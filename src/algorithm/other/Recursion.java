package algorithm.other;

import java.util.HashMap;
import java.util.Map;

/**
 * 迭代
 */
public class Recursion {





    // 假如这里有 n 个台阶，每次你可以跨 1 个台阶或者 2 个,请问走这 n 个台阶有多少走法
    // F(1) = 1; F(2) = 2; f(3) = f(2) + f(1) F(N) = F(N-1) + F(n -
    static Map<Long,Long> map = new HashMap();
    public static Long stepRecursion(Long n){
        if (n==1l) return 1l;
        if (n == 2l) return  2l;

        if (map.containsKey(n)){
            return map.get(n);
        }

        Long result = stepRecursion(n-1) + stepRecursion(n-2);
        map.put(n,result);

        return result;
    }

    public static void main(String[] args){

        Long start = System.currentTimeMillis();
        Long stepTotal = stepRecursion(1000l);
        System.out.println(stepTotal);
        System.out.println("运行时间：" + (System.currentTimeMillis()-start));



    }

}
