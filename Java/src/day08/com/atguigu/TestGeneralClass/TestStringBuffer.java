package day08.com.atguigu.TestGeneralClass;

import org.junit.Test;

/**
 * java.lang.StringBuffer:代表可变的字符序列，可以对字符串内容进行增删
 * java.lang.StringBuilder:代表可变的字符序列,线程不安全，效率高
 */
public class TestStringBuffer {

    /**
     * StringBuilder > StringBuffer > String
     */
    @Test
    public void test2(){
        String text = "";
        long startTime = 0L;
        long endTime = 0L;
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++){
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer : " + (endTime - startTime));


        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++){
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder : " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++){
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String : " + (endTime - startTime));

    }



    @Test
    public void test1(){
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.length());
        sb.append("abc").append("123");
        sb.insert(3,"Hello");
        sb.reverse();


    }

}
