package demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class TestStreamAPI {

    /**
     * 给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
     * 给定[1,2,3,4,5],应该返回[1,4,9,16,25]
     */
    @Test
    public void test1(){
        Integer[] numArr = new Integer[]{1,2,3,4,5};
//        Stream<Integer> numArr1 = Stream.of(numArr);
        Stream<Integer> stream = Arrays.stream(numArr);
        stream.map(x -> x * x).forEach(System.out::println);


    }
}
