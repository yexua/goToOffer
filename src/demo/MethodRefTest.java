package demo;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class MethodRefTest {

    //对象::实例方法名
    @Test
    public void test(){

        Consumer<String> con = x -> System.out.println(x);
        con.accept("Hello World");
        Consumer<String> cons = System.out::println;
        cons.accept("Hello World");
    }

    //类::静态方法名
    @Test
    public void tset2(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> coms = Integer::compare;
    }

    //类::实例方法名
    @Test
    public void test3(){
        BiPredicate<String, String> com = (x, y) -> x.equals(y);

        BiPredicate<String, String> coms = String::equals;
    }
}
