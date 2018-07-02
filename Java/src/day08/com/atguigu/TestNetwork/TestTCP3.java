package day08.com.atguigu.TestNetwork;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 从客户端发送文件到服务端，服务端保存在本地，并返回"发送成功" 到客户端，并关闭相应的连接。
 */
public class TestTCP3 {

    @Test
    public void client(){
        Socket client = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        try {
            client = new Socket(InetAddress.getByName("127.0.0.1"),8989);
            os = client.getOutputStream();
            fis = new FileInputStream(new File("1.jpg"));
            byte[] b = new byte[20];
            int len;
            while ((len = fis.read(b)) != -1){
                os.write(b,0,len);
            }
            client.shutdownOutput();
            is = client.getInputStream();
            byte[] b2 = new  byte[20];
            int len2;
            while ((len2= is.read(b2)) != -1){
                String str = new String(b,0,len2);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (client != null){
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void server(){
        ServerSocket ss = null;
        Socket server = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(8989);
            server = ss.accept();
            is = server.getInputStream();
            fos = new FileOutputStream("2.jpg");

            byte[] b = new  byte[20];
            int len;
            while ((len = is.read(b)) != -1){
                fos.write(b,0,len);
            }

            os = server.getOutputStream();
            os.write("收到".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (server != null){
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
