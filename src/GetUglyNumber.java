/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 * 前20个丑数为：1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, 18, 20, 24, 25, 27, 30, 32, 36。
 */
public class GetUglyNumber {
    static final int d[] = {2, 3, 5};

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(GetUglyNumber_Solution(1500));
//        System.out.println(GetUglyNumber_Solution_1(1500));
        System.out.println(System.currentTimeMillis() - start);
    }


    public static int GetUglyNumber_Solution_1(int index) {
        if (index == 0) return 0;
        int a[] = new int[index];
        a[0] = 1;
        int p[] = new int[]{0, 0, 0};
        int num[] = new int[]{2, 3, 5};
        int cur = 1;

        while (cur < index) {
            int m = finMin(num[0], num[1], num[2]);
            if (a[cur - 1] < num[m])
                a[cur++] = num[m];
            p[m] += 1;
            num[m] = a[p[m]] * d[m];
        }
        return a[index - 1];
    }

    private static int finMin(int num2, int num3, int num5) {
        int min = Math.min(num2, Math.min(num3, num5));
        return min == num2 ? 0 : min == num3 ? 1 : 2;
    }

    /**
     * 如果p是丑数，那么p=2^x * 3^y * 5^z
     * 那么只要赋予x,y,z不同的值就能得到不同的丑数。
     * 如果要顺序找出丑数，要知道下面几个特（fei）点（hua）。
     * 对于任何丑数p：
     * （一）那么2*p,3*p,5*p都是丑数，并且2*p<3*p<5*p
     * （二）如果p<q, 那么2*p<2*q,3*p<3*q,5*p<5*q
     * 现在说说算法思想：
     * 由于1是最小的丑数，那么从1开始，把2*1，3*1，5*1，进行比较，得出最小的就是1
     * 的下一个丑数，也就是2*1，
     * 这个时候，多了一个丑数‘2’，也就又多了3个可以比较的丑数，2*2，3*2，5*2，
     * 这个时候就把之前‘1’生成的丑数和‘2’生成的丑数加进来也就是
     * (3*1,5*1,2*2，3*2，5*2)进行比较，找出最小的。。。。如此循环下去就会发现，
     * 每次选进来一个丑数，该丑数又会生成3个新的丑数进行比较。
     *
     * @param index
     * @return
     */
    public static int GetUglyNumber_Solution(int index) {
        if (index < 7) {
            return index;
        }
        int[] res = new int[index];
        res[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 1; i < index; i++) {
            res[i] = Math.min(res[t2] * 2, Math.min(res[t3] * 3, res[t5] * 5));
            if (res[i] == res[t2] * 2) t2++;
            if (res[i] == res[t3] * 3) t3++;
            if (res[i] == res[t5] * 5) t5++;
        }
        return res[index - 1];
    }


    /**
     * 判断是否为丑数
     * 直观但是低效的解法
     *
     * @param number
     * @return
     */
    boolean isUgly(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1 ? true : false;
    }
}
