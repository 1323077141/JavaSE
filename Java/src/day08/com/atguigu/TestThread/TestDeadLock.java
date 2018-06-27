package day08.com.atguigu.TestThread;

/**
 * 死锁问题
 * 处理线程同步时，容易出现
 */
public class TestDeadLock {
    static StringBuffer sb1 = new StringBuffer();
    static StringBuffer sb2 = new StringBuffer();
    public static void main(String[] args) {
        new Thread(){
            public void run(){
                synchronized (sb1){
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sb1.append("A");
                    synchronized (sb2){
                        sb2.append("B");
                    }
                }
            }
        }.start();
        new Thread(){
            public void run(){
                synchronized (sb2){
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sb1.append("C");
                    synchronized (sb1){
                        sb2.append("D");
                    }
                }
            }
        }.start();

    }
}
