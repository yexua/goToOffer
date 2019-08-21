package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyDynamicProxy {
    public static void main(String[] args) {
        HelloImpl helloImpl = new HelloImpl();
        MyInvocationHandler handler = new MyInvocationHandler(helloImpl);
        Hello hello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(), new Class[]{Hello.class}, handler);
        hello.hello();
    }
}


interface Hello {
    void hello();
}

class HelloImpl implements Hello {

    @Override
    public void hello() {
        System.out.println("Hello World");
    }
}

class MyInvocationHandler implements InvocationHandler {

    //目标对象
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置通知代码");
        //执行目标方法
        Object result = method.invoke(target, args);
        System.out.println("后置通知代码");
        return result;
    }
}