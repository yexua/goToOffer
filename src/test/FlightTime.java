package test;

import java.util.Scanner;

/**
 * 1、计算一个航班的飞行时间，通过键盘输入两个数，分别代表航班起飞时间和到达时间（不用考虑跨天的情况）。比如一个航班起飞是7:30，到达是14:20，则输入730和1420，通过程序，则要求输出内容为：“航班飞行时间为6小时50分钟”。
 */

public class FlightTime {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int minuteCount = end - start - (getFront(end) - getFront(start)) * 40;
        int hour = minuteCount / 60;
        int minute = minuteCount % 60;
        System.out.println("航班飞行时间为" + hour + "小时" + minute + "分钟。");
    }

    public static int getFront(int x) {
        String s = String.valueOf(x);
        return Integer.valueOf(s.substring(0, s.length() - 2));
    }
}
