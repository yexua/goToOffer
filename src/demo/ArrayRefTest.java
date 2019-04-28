package demo;

import org.junit.Test;

import java.util.function.Function;

public class ArrayRefTest {
    @Test
    public void test(){
        Function<Integer, String[]> fun = (x) -> new String[x];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);

        Function<Integer, String[]> funs = String[]::new;
        String[] apply = funs.apply(10);
        System.out.println(apply.length);

    }
}
