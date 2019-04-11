/**
 * 期未到了，老师为了表扬各位学生，购买了与学生数量相同的巧克力。
 * 老师制定了一个规则，每位学生按学号顺序依次独自进入他的办公室，
 * 他会随机给一定数量的巧克力给进入他办公室的学生(最少1块，学号靠后的同学可能拿不到巧克力)。
 * 小招喵的学号是1,所以他是第一个进入老师办公室的。他希望自己能从老师那里拿到至少6块巧克力。
 * 他希望你帮他计算一下他拿到至少6块巧克力的方案数一共是多少(如果最终分配方案中，某个学号的同学拿到的巧克力数不一样则认为是不同的方案)。
 * 最终的结果可能很大，输出对6666666取模后的结果。
 *
 *   6: 6     ->1
 *   7: 6 1   ->2
 *      7
 *   8: 6 1 1 ->4
 *      6 2
 *      7 1
 *      8
 *   9: 6 3   ->8
 *      6 2 1
 *      6 1 1 1
 *      6 1 2
 *      7 1 1
 *      7 2
 *      8 1
 *      9
 *
 */

package test;

import java.util.Scanner;

public class Chocolate {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if( n < 6){
            System.out.println(0);
            return;
        }
        get(n);
    }

    public static void get(int n){
        int result = 1;
        for(int i = 0; i < n - 6; i++){
            result *= 2;;
            result %= 6666666;
        }
        System.out.println(result);
    }

}
