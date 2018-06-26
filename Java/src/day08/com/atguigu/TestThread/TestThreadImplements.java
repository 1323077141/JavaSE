package day08.com.atguigu.TestThread;

//创建多线程的方式2

/**
 *  继承 VS 实现
 *  1.联系 public class Thread implements Runnable
 *  2.实现的方式优于继承： 实现避免了java中单继承的局限性;如果多个线程共享资源，更适合使用实现的方式
 */
class PrintNum1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}
public class TestThreadImplements {

    public static void main(String[] args) {
        PrintNum1 p = new PrintNum1();
        //要想实现一个多线程，必须通过start()
        Thread t1 = new Thread(p);
        t1.start();  //启动线程，执行Thread对象生成时构造器形参的对象的run方法

        Thread t2 = new Thread(p);
        t2.start();
    }

}
