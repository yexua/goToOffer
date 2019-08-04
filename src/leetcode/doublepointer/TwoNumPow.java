package leetcode.doublepointer;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 */
public class TwoNumPow {
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int pow = i * i + j * j;
            if (pow == c) {
                return true;
            } else if (pow > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
