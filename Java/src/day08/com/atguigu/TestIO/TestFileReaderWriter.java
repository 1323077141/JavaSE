package day08.com.atguigu.TestIO;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 对于非文本文件(视频文件，音频文件，图片等只能用字节流)
 */
public class TestFileReaderWriter {

    @Test
    public void testFileReaderWriter(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File src = new File("hello.txt");
            File dest = new File("hello1.txt");
            fr = new FileReader(src);
            fw = new FileWriter(dest);
            char[] c = new char[20];
            int len;
            while ((len = fr.read(c)) != -1){
                fw.write(c,0,len);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFileReader(){
        File file = new File("hello.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            char[] c = new char[24];
            int len;
            while ((len = fr.read(c)) != -1){
                String str = new String(c,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
