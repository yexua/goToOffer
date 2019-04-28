package demo;

public class MyClass /*extends SubClass*/ implements MyInterface, MyFun {

    @Override
    public String get() {
        return MyInterface.super.get();
        // 或return MyFun.super.get();
        // 或自己实现
    }
}
