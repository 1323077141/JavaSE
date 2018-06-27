package day08.com.atguigu.TestThread;

/**
 * 同步方法
 */
public class TestWindow2 {
    public static void main(String[] args) {
        Window2 w = new Window2();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();

    }

}

class Window2 implements Runnable{
    int ticket = 100;
    public void run(){
        while (true){
            show();
        }
    }
    public synchronized void show(){
       if (ticket > 0){
           try{
                Thread.currentThread().sleep(10);
           }catch (Exception e){
               e.printStackTrace();
           }
           System.out.println(Thread.currentThread().getName() + " : " + ticket--);
       }
    }
}