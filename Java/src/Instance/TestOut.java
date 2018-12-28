package Instance;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Created by Administrator on 2018-12-28.
 */
public class TestOut {
    public static void main(String[] args) {
        //out 和 err的区别
//        System.out.println("main start");
//        //输出错误信息
//        System.err.println("手动输出错误");
//        System.err.println("\t 注意安全");
//        System.err.println("errrrr");
//        System.err.println(false);
//        System.out.println("1");
//        System.out.println("2");
//        System.err.println("hahahaha");

    //System的重定向
//        try {
//            PrintStream out = System.out;
//            PrintStream ps = new PrintStream("./log.txt");
//            System.setOut(ps);  //重定向
//            System.out.println("年龄为18");
//            System.out.println("hahaha");
//            System.setOut(out); //回复控制台输出
//            System.out.println("完毕");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        //直接互换数据，不用第三个空间
        int a = 3,b=6;
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;


    }
}
