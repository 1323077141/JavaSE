package day08.com.atguigu.TestIO;

import org.junit.Test;

import java.io.*;

/**
 * 1.IO流的体系
 * 按照数据流向不同：输入流 输出流
 * 按照处理数据安慰的不同：字节流(8 bit)   字符流 (16 bit)
 * 按照角色的不同：节点流(直接作用于文件)  处理流
 *
 * 抽象基类         节点流(文件流)            缓冲流(处理流的一种)
 * InputStream      FileInputStream         BufferedInputStream
 * OutputStream     FileOutputStream        BufferedOutputStream
 * Reader           FileReader              BufferedReader
 * Writer           FileWriter              BufferedWriter
 */
public class TestBuffered {

    @Test
    public void testBufferedReader() throws Exception{
        File file = new File("hello.txt");
        File file1 = new File("hello1.txt");
        FileReader fr = new FileReader(file);
        FileWriter fw = new FileWriter(file1);
        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);
//        char[] c = new char[1024];
//        int len;
//        while ((len = br.read(c)) != -1){
//            String str = new String(c,0,len);
//        }
        String str;
        while ((str = br.readLine()) != null){
            bw.write(str);
            bw.newLine(); //相当于 bw.write(str + "/n");
            bw.flush();
            System.out.println(str);
        }
        br.close();
    }

    @Test
    public void testBufferedInputOutputStream() throws Exception{
        File file1 = new File("hello.txt");
        File file2 = new File("hello.txt1");
        //2.先创建相应的节点流，FileInputStream,FileOutputStream
        FileInputStream in = new FileInputStream(file1);
        FileOutputStream out = new FileOutputStream(file2);
        //3.创建的节点流的对象最为形参传递给缓冲流的构造器中
        BufferedInputStream bin = new BufferedInputStream(in);
        BufferedOutputStream bout = new BufferedOutputStream(out);
        //4.实现文件复制的操作
        byte[] b =new byte[20];
        int len;
        while ((len = in.read(b)) != -1){
            bout.write(b,0,len);
            bout.flush();
        }
        //5.关闭
        bin.close();
        bout.close();

    }


}
