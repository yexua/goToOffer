package forkJoin;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.OptionalLong;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkJoinTest {

    @Test
    public void test(){
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0, 10000000000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());
    }

    @Test
    public void test2(){
        Instant start = Instant.now();
        long sum = 0L;
        for(long i = 0; i< 10000000000L;i++){
            sum +=i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());
    }

    /**
     * Java8并行流
     */
    @Test
        public void test3(){
            Instant start = Instant.now();
            OptionalLong reduce = LongStream.rangeClosed(0, 10000000000L)
                    .parallel()
                    .reduce(Long::sum);
            Instant end = Instant.now();
            System.out.println(Duration.between(start, end).toMillis());
    }
}
