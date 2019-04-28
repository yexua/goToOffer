package demo;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorRefTest {

    @Test
    public void test(){
        Supplier<Employee> sup = () -> new Employee();
        Employee employee = sup.get();
        System.out.println(employee);
        //构造器引用方式
        Supplier<Employee> sups = Employee::new;
        Employee employees = sups.get();
        System.out.println(employees);

        Function<Integer, Employee> fun = (x) -> new Employee(x);
        Function<Integer, Employee> funs = Employee::new;
        Employee apply = funs.apply(1);
        System.out.println(apply);
    }
}
