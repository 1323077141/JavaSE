package day08.com.atguigu.TestThread;

/**
 * 生产者/消费者问题
 *
 */
public class TestProduceConsume {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p = new Producer(clerk);
        Consumer c = new Consumer(clerk);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);

        t1.setName("生产者");
        t2.setName("消费者");
        t1.start();
        t2.start();
    }
}

class Clerk{ //中间商
    int product;

    public synchronized void addProduct(){  //生产产品
        if (product >= 20){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            product++;
            System.out.println(Thread.currentThread().getName() + ":" + product);
            notify();//唤醒消费者
        }
    }

    public synchronized void consumeProduct(){  //消费产品
        if (product <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(Thread.currentThread().getName() + ":" + product);
            product--;
            notify();  //唤醒生产者
        }
    }

}

class Consumer implements Runnable{
    Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            clerk.consumeProduct();
        }
    }
}

//生产者
class Producer implements Runnable{
    Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){

            clerk.addProduct();
        }
    }
}
