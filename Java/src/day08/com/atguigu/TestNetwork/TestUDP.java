package day08.com.atguigu.TestNetwork;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TestUDP {

    //发送端
    @Test
    public void send(){
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();

            byte[] b = "我是要发送的数据".getBytes();
            //创建的数据报不能大于64k
            DatagramPacket pack = new DatagramPacket(b,0,b.length,
                    InetAddress.getByName("127.0.0.1"),9090);
            ds.send(pack);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (ds != null){
                ds.close();
            }
        }
    }

    //接收端
    @Test
    public void receive(){
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(9090);
            byte[] b = new byte[1024];
            DatagramPacket packet = new DatagramPacket(b,0,b.length);
            ds.receive(packet);
            String str = new String(packet.getData(),0,packet.getLength());
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (ds != null){
                ds.close();
            }
        }


    }

}
