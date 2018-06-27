package day08.com.atguigu.TestThread;

/**
 * 模拟火车站售票窗口，开启三个窗口售票，售卖100张票
 * 存在线程安全问题:
 * 1.存在原因：
 *  由于一个线程在操作共享数据时，未执行完毕的情况下，了另外的线程参与进来，导致共享数据存在了安全问题
 * 2.解决办法
 * 必须让一个线程操作共享数据完毕后，其他线程才有机会参与共享数据的操作
 * 3.JAVA实现线程安全------线程同步
 * 方式1：同步代码块
 * synchronized(同步监视器){
 *     //需要被同步的代码块
 * }
 * 1.共享数据:多个线程共同操作一个数据
 * 2.同步监视器:由一个类的对象来充当，哪个线程获取此监视器，谁流执行被同步的代码块,俗称，锁(任何类的对象都可充当该锁)。但是该锁在多线程中必须唯一
 * 方式2：同步方法
 * 将共享数据的方法声明为synchronized，即此方法为同步方法，能够保证当一个线程执行此方法时，其他线程在外等待，直至次线程完成方法
 * 同步方法的锁，为当前对象(this)
 * 4.线程的弊端
 * 由于一个时间只能有一个线程访问共享数据，效率变低
 */
public class TestWindows {

    public static void main(String[] args) {
       Window w = new Window();
       Thread t1 = new Thread(w);
       Thread t2 = new Thread(w);
       Thread t3 = new Thread(w);

       t1.start();
       t2.start();
       t3.start();

    }
}

//class Window extends Thread{
//    static int ticket = 100;
//    public void run(){
//        while (ticket > 0){
//            System.out.println(Thread.currentThread().getName() + " : " + ticket--);
//        }
//    }
//}
class Window implements Runnable{
    int ticket = 100;
//    Object obj = new Object();
    public void run(){
//        Object obj = new Object();   //锁放在这，表示每个线程都有自己的锁，并不能做到线程同步
//        synchronized (obj){
            while (ticket > 0){
                synchronized (this){   //this 表示当前对象,即为w,只能用在implements的方式，而不能用thread,理由与上述相同
                System.out.println(Thread.currentThread().getName() + " : " + ticket--);
                }
            }
    }
}

