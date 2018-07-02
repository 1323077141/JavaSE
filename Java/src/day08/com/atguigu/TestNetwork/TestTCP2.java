package day08.com.atguigu.TestNetwork;

import jdk.internal.util.xml.impl.Input;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * 客户端给服务端发消息，服务端将信息打印到控制台，同时发送“已收到”给客户端
 *
 */
public class TestTCP2 {

    @Test
    public void client(){
        Socket client = null;
        OutputStream os = null;
        InputStream is = null;
        try {
            client = new Socket(InetAddress.getByName("127.0.0.1"),8989);
            os = client.getOutputStream();
            os.write("我是客户端".getBytes());

            is = client.getInputStream();
            byte[] b = new  byte[20];
            int len;
            while ((len = is.read(b)) != -1){
                String str = new String(b,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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
        OutputStream os = null;
        try {
            ss = new ServerSocket(8989);
            server = ss.accept();
            is = server.getInputStream();
            byte[] b = new  byte[20];
            int len;
            while ((len = is.read(b)) != -1){
                String str = new String(b,0,len);
                System.out.println(str);
            }

            os = server.getOutputStream();
            os.write("收到".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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
