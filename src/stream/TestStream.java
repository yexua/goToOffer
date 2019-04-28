package stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {
    @Test
    public void test(){
        // 通过Collection 系列集合提供的stream()或parallelStream()获取stream
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        // 通过Arrays中的静态方法stream()获取数组流
        Integer[] arr = new Integer[]{1,2,3,4,5};
        Stream<Integer> integerStream = Arrays.stream(arr);

        //通过Stream中的静态方法of()获取流
        Stream<String> aa = Stream.of("aa", "bb", "cc");

        //创建无限流
        Stream<Integer> iterate = Stream.iterate(0, x -> x + 2);

        IntSummaryStatistics collect = list.stream().collect(Collectors.summarizingInt(Integer::valueOf));
    }
}
