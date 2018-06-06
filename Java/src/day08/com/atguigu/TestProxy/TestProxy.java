package day08.com.atguigu.TestProxy;

/**
 * Created by Administrator on 2018-06-06.
 */
public class TestProxy {
    public static void main(String[] args) {
        Object obj = new ProxyObject();
        obj.action();
    }
}

interface Object{
    void action();
}
//代理类
class ProxyObject implements Object{
    Object obj;

    public ProxyObject(){
        System.out.println("代理类创建成功");
        obj = new ObjctImpl();
    }

    public void action(){
        System.out.println("代理类开始执行");
        obj.action();
        System.out.println("代理类执行结束");
    }
}
//被代理类
class ObjctImpl implements Object{

    @Override
    public void action() {
        System.out.println("=====被代理类开始执行======");
        System.out.println("=====具体的操作======");
        System.out.println("=====被代理类执行完毕======");

    }

}
