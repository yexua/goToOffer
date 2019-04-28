package stream;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPI {

    @Test
    public void test(){
        // 可以通过Collection系列集合提供的stream()或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stringStream = list.stream();

        // 通过Array中的静态方法stream()获取数组流
        Employee[] empArr = new Employee[5];
        Stream<Employee> employeeStream = Arrays.stream(empArr);

        // 通过Stream类中的静态方法of()
        Stream<String> ofStream = Stream.of();
    }

    @Test
    public void test2(){

    }
}
