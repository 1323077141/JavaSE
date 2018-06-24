package day08.com.atguigu.TestIO;

import org.junit.Test;

import java.io.*;

public class TestOtherStream {

    @Test
    public void testData1() throws Exception{
        DataInputStream dis = new DataInputStream(new FileInputStream("hello.txt"));
//        byte[] b = new byte[20];
//        int len;
//        while ((len = dis.read(b)) != -1){
//            System.out.println(new String(b,0,len));
//        }
        String str = dis.readUTF();
        System.out.println(str);
        boolean b = dis.readBoolean();
        System.out.println(b);
        Long l = dis.readLong();
        System.out.println(l);

        dis.close();
    }

    @Test
    public void testData() throws Exception{
        FileOutputStream fos = new FileOutputStream("hello.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeUTF("哈哈哈哈");
        dos.writeBoolean(true);
        dos.writeLong(1234567889);
        dos.close();
    }

    /**
     * 打印流
     * PrintStream 字节流
     * PrintWriter 字符流
     */
    @Test
    public void printStreamWriter() throws Exception{
        FileOutputStream fos = new FileOutputStream("hello.txt");
        PrintStream ps = new PrintStream(fos,true);
        if(ps != null){  //将标准输出流(控制台输出)改成文件
            System.setOut(ps);
        }
        for (int i = 0; i <= 255; i++){ //输出ASCII字符
            System.out.println((char) i);
            if(i % 5 == 0){
                System.out.println();
            }
        }
        ps.close();
    }


    /**
     * 标准的输入输出流
     * 标准输出流:System.out
     * 标准输入流:System.in
     */
    @Test
    public void test2() throws Exception{

        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("请输入字符串:");
        String str;
        while (true){
            str = br.readLine();
            if ("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str)){
                break;
            }
            str = str.toUpperCase();
            System.out.println(str);
        }
        br.close();
    }

    @Test
    public void test1() throws Exception{
        //解码
        File file = new File("hello.txt");
        FileInputStream in = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(in,"UTF-8");
        BufferedReader br = new BufferedReader(isr);
        //编码
        File file1 = new File("hello1.txt");
        FileOutputStream out = new FileOutputStream(file1);
        OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
        BufferedWriter bw = new BufferedWriter(osw);
        String str;
        while ((str = br.readLine()) != null){
            bw.write(str);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }

}
