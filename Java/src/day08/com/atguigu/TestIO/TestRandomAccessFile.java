package day08.com.atguigu.TestIO;

import org.junit.Test;

import java.io.File;
import java.io.RandomAccessFile;

public class TestRandomAccessFile {

    //相较于 test3更为通用
    @Test
    public void test4() throws Exception{


        RandomAccessFile randomAccessFile = new RandomAccessFile(new File("hello.txt"),"rw");

        randomAccessFile.seek(4);  //指针转移到第三个位置，从0开始
        byte[] b = new byte[20];
        int len;
        StringBuffer sb = new StringBuffer();
        while ((len = randomAccessFile.read(b)) != -1){
            sb.append(new String(b,0,len));
        }


        randomAccessFile.seek(4);
        randomAccessFile.write("xy".getBytes());
        randomAccessFile.write(sb.toString().getBytes());

        randomAccessFile.close();

    }

    /**
     * 实现插入的效果，在d字符后面插入xy字符
     */
    @Test
    public void test3() throws Exception{

        RandomAccessFile randomAccessFile = new RandomAccessFile(new File("hello.txt"),"rw");

        randomAccessFile.seek(4);  //指针转移到第三个位置，从0开始
        String str = randomAccessFile.readLine(); //将第四个位置以后的字符串取出来
        long l = randomAccessFile.getFilePointer(); //指针现在所在位置
        System.out.println(l);

        randomAccessFile.seek(4);
        randomAccessFile.write("xy".getBytes());
        randomAccessFile.write(str.getBytes());

        randomAccessFile.close();

    }


    //实际上实现的是覆盖的效果
    @Test
    public void test2() throws Exception{
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File("hello.txt"),"rw");

        randomAccessFile.seek(3);  //指针转移到第三个位置，从0开始
        randomAccessFile.write("xy".getBytes());

        randomAccessFile.close();

    }


    @Test
    public void test1() throws Exception{
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File("hello.txt"),"r");
        RandomAccessFile randomAccessFile1 = new RandomAccessFile(new File("hello.txt"),"rw");
        byte[] b = new byte[20];
        int len;
        while ((len = randomAccessFile.read(b)) != -1){
            randomAccessFile1.write(b,0,len);
        }
        randomAccessFile.close();
        randomAccessFile1.close();

    }

}
