package demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class LambdaTest  extends  Object{

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 22, 9000),
            new Employee(102, "李四", 22, 10000),
            new Employee(103, "王五", 22, 2000),
            new Employee(104, "小明", 22, 3000),
            new Employee(105, "Tom", 28, 6000)
    );

    @Test
    public void test(){
        Collections.sort(emps, (e1, e2) -> {
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else{
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        for(Employee emp : emps){
            System.out.println(emp);
        }
    }
}
class Employee{
    private int id;
    private String name;
    private int age;
    private int salary;

    public Employee() { }

    public Employee(int id) {
        this.id = id;
    }

    public Employee(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}