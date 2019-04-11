/**
 * 给出n*2个杯子，每个杯子的容星为ai，以及w毫升的水，小招喵将要接待n个男孩和n个女孩。每人一个杯子，
 * 倒水的规则如下:-每个男孩杯子里的水量要相同-每个女孩杯子里的水量要相同
 * 一男孩杯子里的水量要是女孩杯子里的水量的两倍。问最多总共能倒入多少毫升水。
 * 输入描述:输入包含两行。
 * 第一行为两个整数n和 w(1≤n≤105, 1≤w≤10%)
 * 第二行为2n个整数a1,a2...a2n(1≤ai≤10^9)
 * 输出描述
 * 一个数，表示最多倒入多少 毫升水，答案保留6位小数。
 *
 * 先排序，前n个杯子给女孩，
 * 第n+1个假如是第一个的2倍以上，就男生为第一个杯子的2倍，女生是第一个杯子。
 * 如果是以下，女生就是第n+1个的一半，男生就是n+1个
 * 然后要判断水容量够不够，如果不够就直接按水容量/3就是女生的，男生*2
 */
package test;
import java.util.Arrays;
import java.util.Scanner;
public class PourWater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), w = scanner.nextInt();
        int[] a = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            a[i] = scanner.nextInt();
        }
        // 将杯子容量进行排序
        Arrays.sort(a);
        // 男生的第一个杯子，女生的第一个杯子
        double bMin = a[n], gMin = a[0];
        double ans;
        // 如果男生的第一个杯子比女生第一个杯子2倍少
        if (bMin / 2 <= gMin) {
            // 女生的杯子容量是男生第一个杯子的1/2
            ans = bMin * 1.5 * n;
        } else {//男生的第一个杯子比女生第一个杯子2倍多
            // 男生的杯子容量是女生第一个杯子的2倍
            ans = gMin * n * 3;
        }
        // 判断总容量
        if (ans >= w) {
            ans = w;
        }
        System.out.printf("%.6f", ans);
    }
}
