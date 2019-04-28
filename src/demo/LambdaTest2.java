package demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class LambdaTest2 {
    @Test
    public void test1() {
        eat(36, m -> System.out.println("吃红烧鱼，每次消费" + m + "元"));
    }

    @Test
    public void test2() {
        String hello_world = strHandler("Hello World", str -> str.substring(6, str.length()));
        System.out.println(hello_world);
    }

    @Test
    public void test3() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        numList.forEach(System.out::println);
    }

    @Test
    public void test4() {
        List<String> list = Arrays.asList("Hello", "no", "ok", "java");
        List<String> strings = filterString(list, s -> s.length() > 2);
        strings.forEach(System.out::println);
    }

    // 消费型接口
    public void eat(double money, Consumer<Double> con) {
        con.accept(money);
    }

    // 供给型接口
    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    // 函数性接口
    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    // 断言型接口
    // 将满足条件的字符串，放入集合中
    public List<String> filterString(List<String> list, Predicate<String> predicate) {
        ArrayList<String> strList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                strList.add(s);
            }
        }
        return strList;
    }
}
