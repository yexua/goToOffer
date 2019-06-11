import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] arr = {3, 32, 321,32,1,23,45,31,23,45,32,12,45,65,12};
        System.out.println(PrintMinNumber(arr));
        System.out.println(System.currentTimeMillis() - start);
    }

    public static String PrintMinNumber(int[] numbers) {
        StringBuilder s = new StringBuilder();
//        String s = "";
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, (o1, o2) -> {
            String s1 = o1 + "" + o2;
            String s2 = o2 + "" + o1;
            return s1.compareTo(s2);
        });
        for (Integer integer : list) {
            s.append(integer);
//            s += integer;
        }
        return s.toString();
//        return s;
    }
}
