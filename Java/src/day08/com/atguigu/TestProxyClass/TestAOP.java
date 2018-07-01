package day08.com.atguigu.TestProxyClass;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human{
    void info();

    void fly();
}
//被代理类
class Superman implements Human{

    @Override
    public void info() {
        System.out.println("Superman----info");
    }

    @Override
    public void fly() {
        System.out.println("Superman----fly");
    }
}

class HumanUtil{
    public void method1(){
        System.out.println("method1");
    }
    public void method2(){
        System.out.println("method2");
    }
}

class myInvocationHandler implements InvocationHandler{

    Object obj;

    public void setObject(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil h = new HumanUtil();
        h.method1();
        Object returnVal = method.invoke(obj,args);
        h.method2();
        return returnVal;
    }
}

class MyProxy{
    public static Object getProxyInstance(Object obj){
        myInvocationHandler handler = new myInvocationHandler();
        handler.setObject(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}

public class TestAOP {
    public static void main(String[] args) {
        Superman man = new Superman();
        Human human = (Human) MyProxy.getProxyInstance(man);
        human.info();
        human.fly();

    }
}
