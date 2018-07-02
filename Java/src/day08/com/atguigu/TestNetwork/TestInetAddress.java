package day08.com.atguigu.TestNetwork;

import org.junit.Test;

import java.net.InetAddress;

/**
 * java.net包下
 * 1.InetAddress代表IP地址，即一个InerAdress对象代表一个IP地址
 * 2.创建对象:InetAddress.getByName(String name),该对象有两个方法:
 * getHostName 获取IP地址对应的域名
 * getHostAddress 获取IP地址
 *
 */
public class TestInetAddress {


    @Test
    public void test1() throws Exception{
        InetAddress ip = InetAddress.getByName("www.atguigu.com");
        System.out.println(ip); //www.atguigu.com/122.227.164.192
        System.out.println(ip.getHostName() + "   " + ip.getHostAddress()); //  www.atguigu.com  122.227.164.192
        ip = InetAddress.getByName("122.227.164.192");
        System.out.println(ip);  // /122.227.164.192
        System.out.println(ip.getHostName() + "   " + ip.getHostAddress());// 122.227.164.192   122.227.164.192

        ip = InetAddress.getLocalHost();
        System.out.println(ip);  // PC-20170618UNXA/192.168.2.36
        System.out.println(ip.getHostName() + "   " + ip.getHostAddress());// PC-20170618UNXA   192.168.2.36

    }

}
