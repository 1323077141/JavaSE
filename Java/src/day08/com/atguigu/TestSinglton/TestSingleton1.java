package day08.com.atguigu.TestSinglton;

/**
 * 懒汉式:可能存在线程安全问题
 */
public class TestSingleton1 {

    public static void main(String [] args){
        Singleton1 s1 = Singleton1.getInstance();
        Singleton1 s2 = Singleton1.getInstance();
        System.out.println(s1 = s2); //true
    }
}

class Singleton1{

    //1.私有化构造器
    private Singleton1(){

    }

    //2.私有化实例
    private static Singleton1 instance = null;

    //3.通过公共的方法获取实例
    public static Singleton1 getInstance(){
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }


}
