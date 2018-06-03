package day08.com.atguigu.TestSinglton;


/**
 *
 *  饿汉式
 * 大概有23中设计模式:
 * 单例设计模式：
 * 1.解决的问题是使得一个类只能够创建一个对象。
 * 2.实现方式
 */
public class TestSingleton {

    public static void main(String [] args){
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2); //true
    }

}

/**
 * 只能创建单个实例
 */
class Singleton{

    //1.私有化构造器,使得在类的外部不能调用构造器
    private Singleton(){
        super();
    }
    //2.在类的内部创建一个类的实例，私有化
    private static Singleton instance = new Singleton();

    //3.私有化instance对象，通过公共的方法调用
    //4.其他类只能通过类来调用，因此设置为static，同时类的实例也必须为static
    public static Singleton getInstance(){
        return instance;
    }
}