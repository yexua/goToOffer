package demo;

public interface MyInterface {
    default String get(){
        return "MyInterface";
    }

    static void show(){
        System.out.println("接口中的静态方法");
    }

}
