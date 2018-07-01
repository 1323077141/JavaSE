package day08.com.atguigu.TestProxyClass;
//静态代理模式
//接口
interface ClothFactory{
    void productCloth();
}
//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void productCloth() {
        System.out.println("Nike");
    }
}
//代理类
class ProxyFactory implements ClothFactory{

    ClothFactory cf;

    public ProxyFactory(ClothFactory cf){
        this.cf = cf;
    }

    @Override
    public void productCloth() {
        cf.productCloth();
    }
}


public class TestClothProduct {
    public static void main(String[] args) {
        NikeClothFactory nike = new NikeClothFactory();
        ProxyFactory pf = new ProxyFactory(nike);
        pf.productCloth();
    }
}
