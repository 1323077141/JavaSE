package day08.com.atguigu.TestIO;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 1.IO流的体系
 * 按照数据流向不同：输入流 输出流
 * 按照处理数据安慰的不同：字节流(8 bit)   字符流 (16 bit)
 * 按照角色的不同：节点流(直接作用于文件)  处理流
 * 抽象基类         节点流(文件流)
 * InputStream      FileInputStream
 * OutputStream     FileOutputStream
 * Reader           FileReader
 * Writer           FileWriter
 */
public class TestFileInputOutputStream{

    @Test
    public void testFileInputStream2(){
        FileInputStream in = null;
        try {
            File file  = new File("F:\\MyFiles\\hello.txt");
            in = new FileInputStream(file);
            byte[] b = new byte[5]; //读取到的数据要写入的数组,返回值为写入数据的长度
            int len = 0;
            while ((len = in.read(b)) != -1){
                for (int i = 0; i< len ; i++){ //abcdefg
                    System.out.println((char) b[i]);
                }
                for (int i = 0; i< b.length ; i++){   //abcdefgcde
                    System.out.println((char) b[i]);
                }
                String str = new String(b,0,b.length);  //abcdefgcde
                System.out.println(str);
                String str1 = new String(b,0,len);  //abcdefg
                System.out.println(str1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in != null){
                try {
                    in.close();
                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 从硬盘存在的一个文件内容读取到程序内存中
     */
    @Test
    public void testFileInputStream1(){
        //异常最好使用 try catch 更合理
        FileInputStream in = null;
        try {
            //1.创建一个File类对象
            File file = new File("F:\\MyFiles\\hello.txt");
            //2.创建FileInputStream 对象
            in = new FileInputStream(file);
            int b;
            //3.读取:read (一次读取一个字节,当执行到结尾时,返回-1)
            while ((b = in.read()) != -1){
                System.out.println((char) b);
                b = in.read();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (in != null){
                try {
                    in.close();
                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }

}
