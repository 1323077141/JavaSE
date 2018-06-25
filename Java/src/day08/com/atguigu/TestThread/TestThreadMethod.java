package day08.com.atguigu.TestThread;

/**
 * Thread的常用方法:
 * 1.start():启动线程并执行run() 方法
 * 2.run():子线程要执行的方法
 * 3.currentThread():静态的，调取当前的线程
 * 4.getName(): 获取此线程的名字
 * 5.setName():设置此线程的名字
 * 6.yield():调用此方法的线程释放当前CPU的执行权
 * 7.join():在A线程中调用B线程的join方法，表示，当执行到此方法时，A线程暂停执行，直到B线程执行完毕，继续执行A线程
 * 8.isAlive():判断当前线程是否还存活
 * 9.sleep(long l):显示的让当前线程睡眠l毫秒
 * 10.线程通信：wait() notify() notifyAll()
 *
 * 设置线程的优先级
 * getPriority()
 * setPriority()
 */
public class TestThreadMethod {
    public static void main(String[] args) {
        SubThread1 st = new SubThread1();
        st.setName("子线程");
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        st.start();
        Thread.currentThread().setName("主线程");
        for (int i = 0; i <= 100; i++){
//            if (i %10 == 0){
//                Thread.currentThread().yield();
//            }
            if (i == 20){
                try {
                    st.join();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + i++);
        }
    }

}
class SubThread1 extends Thread{
    public void run(){
        for (int i = 0; i <= 100; i++){
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":" + i++);
        }
    }
}