package day08.com.atguigu.TestNetwork;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * URL: 统一资源定位符，一个URL对象，对应着互联网上的资源
 * 可以通过URL对象调用其方法，进行资源读取
 */
public class TestURL {

    /**
     * String getProtocol() 获取该URL的协议名
     * String getHost() 获取该URL的主机名
     * String getPort() 获取该URL的端口
     * String getPath() 获取该URL的文件路径
     * String getFile() 获取该URL的文件名
     * String getRef() 获取该URL在文件中的相对位置
     * String getQuery() 获取该URL的查询名
     *
     */
    @Test
    public void test1(){
//        System.out.println(url.getProtocol()); //http
//        System.out.println(url.getHost()); //127.0.0.1
//        System.out.println(url.getPort()); //8080
//        System.out.println(url.getPath());
//        System.out.println(url.getFile()); // /examples/HelloWorld.txt
//        System.out.println(url.getRef());
//        System.out.println(url.getQuery());
        //读取资源
        URL url = null;
        InputStream is = null;
        try {
            url = new URL("http://127.0.0.1:8080/examples/HelloWorld.txt?a=b");
            is = url.openStream();
            byte[] b = new byte[20];
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
        }
        //数据的输入与输出都有
        InputStream is1 = null;
        FileOutputStream fos = null;
        try {
            url = new URL("http://127.0.0.1:8080/examples/HelloWorld.txt?a=b");
            URLConnection conn = url.openConnection();
            is1 = conn.getInputStream();
            fos = new FileOutputStream(new File("abc.txt"));
            byte[] b = new byte[20];
            int len;
            while ((len = is.read(b)) != -1){
                fos.write(b,0,len);
            }
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
            if (is1 != null){
                try {
                    is1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
