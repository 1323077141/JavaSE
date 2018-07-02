package day08.com.atguigu.TestNetwork;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端发送信息给服务端，服务端输出信息到控制台上
 */
public class TestTcp1 {

    //客户端
    @Test
    public void client(){
        //异常捕获用try catch 最好
        Socket socket = null;
        OutputStream out = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9092);
            out = socket.getOutputStream();
            out.write("我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //服务端
    @Test
    public void server() {
        ServerSocket ss = null;
        Socket s = null;
        InputStream is = null;
        try {
            ss = new ServerSocket(9092);
            s = ss.accept();
            is = s.getInputStream();
            byte[] b = new byte[20];
            int len;
            System.out.println("发送端");
            while ((len = is.read(b)) != -1){
                String str = new String(b,0,len);
                System.out.println(str);
            }
            System.out.println("收到来自于" + s.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (is !=  null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (s !=  null){
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss !=  null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
