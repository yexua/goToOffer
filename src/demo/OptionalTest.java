package demo;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {
    /**
     *
     Optional容器类的常用方法:

     Optional.of(T t) :创建一个Optional实例

     Optional. empty() :创建一个空的Optional实例

     Optional. ofNullable(T t):若t不为null,创建0ptional实例,否则创建空实例isPresent() :判断是否包含值

     orElse(T t) :如果调用对象包含值， 返回该值，否则返回

     orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回s获取的值

     map(Function f):如果有值对其处理，并返回处理后的0ptional,否则返回Optional. empty()flatMap(Function mapper):与map类似，要求返回值必须是0ptional
     */
    @Test
    public void test(){
        Optional<Employee> op = Optional.of(new Employee());
        Employee employee = op.get();
    }
    @Test
    public void test2(){
        Optional<Employee> op = Optional.ofNullable(null);
        if(op.isPresent()){
            System.out.println(op.get());
        }
    }
}
