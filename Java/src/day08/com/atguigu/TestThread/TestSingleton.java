package day08.com.atguigu.TestThread;

/**
 * 同步代码块
 * 在一般方法内，可以使用this
 * 在静态方法内，使用当前类本身充当锁
 */
public class TestSingleton {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}

class Singleton{

    private Singleton(){

    }

    private static Singleton instance = null;

    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class) {
                if (instance == null) {
                    //当线程在此时被挂起时，会产生线程安全问题
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
