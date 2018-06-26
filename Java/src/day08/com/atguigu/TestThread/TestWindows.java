package day08.com.atguigu.TestThread;

/**
 * 模拟火车站售票窗口，开启三个窗口售票，售卖100张票
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
    public void run(){
        while (ticket > 0){
            System.out.println(Thread.currentThread().getName() + " : " + ticket--);
        }
    }
}

