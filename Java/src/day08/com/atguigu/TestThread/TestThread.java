package day08.com.atguigu.TestThread;

/**
 * 创建一个子线程，完成1-100之间的输出。同样的，主线程执行同样的操作
 * 创建多线程的一种方式:继承Thread类
 */
//1.创建一个继承于Thread的子类
class SubThread extends Thread{
    //2.重写Thread类的run()方法,方法内实现此线程要完成的功能
    public void run(){
        for (int i = 0; i <= 100; i++){
            System.out.println(Thread.currentThread().getName() + ":" + i++);
        }
    }

}
public class TestThread {
    public static void main(String[] args){
        SubThread st = new SubThread();
        //4.调用线程的start()方法:调用相应的run方法,一个线程只执行一次start
        //st.run() 无法启动线程
        st.start();
        for (int i = 0; i <= 100; i++){
            System.out.println(Thread.currentThread().getName() + ":" +  i++);
        }
    }
}
