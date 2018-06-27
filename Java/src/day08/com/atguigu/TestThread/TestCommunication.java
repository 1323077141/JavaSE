package day08.com.atguigu.TestThread;

/**
 * 线程通信 :甲乙之间交替执行
 *
 *
 *
 */
class PrintNum implements Runnable{
    int num = 1;
    @Override
    public void run() {
        while (true){
            synchronized (this) {
                notify();

                if (num <= 100){
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                }else{
                    break;
                }


                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
public class TestCommunication {
    public static void main(String[] args) {
        PrintNum pt = new PrintNum();
        Thread t1 = new Thread(pt);
        Thread t2 = new Thread(pt);
        t1.setName("甲");
        t2.setName("乙");
        t1.start();
        t2.start();
    }
}
