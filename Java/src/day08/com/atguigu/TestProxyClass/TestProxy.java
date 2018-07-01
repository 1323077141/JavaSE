package day08.com.atguigu.TestProxyClass;

import java.io.ObjectInputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理的使用
interface Subject{
    void action();
}

//被代理类
class RealSubject implements Subject{

    @Override
    public void action() {
        System.out.println("被代理类");
    }
}

class MyInvocationHandler implements InvocationHandler{

    Object obj;
    //被代理类的实例化;返回一个代理类的对象
    public Object blind(Object obj){
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnVal = method.invoke(obj,args);
        return returnVal;
    }
}

public class TestProxy {
    public static void main(String[] args) {
        RealSubject real = new RealSubject();
        MyInvocationHandler handler = new MyInvocationHandler();
        Object obj = handler.blind(real);
        Subject sub = (Subject)obj; //此时的sub是代理类的对象
        sub.action();


        NikeClothFactory nike = new NikeClothFactory();
        ClothFactory cf = (ClothFactory) handler.blind(nike);
        cf.productCloth();

    }

}
