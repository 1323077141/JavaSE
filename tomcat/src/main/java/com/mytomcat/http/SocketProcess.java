package com.mytomcat.http;

import com.mytomcat.servlet.Servelt;
import com.mytomcat.tomcat.Mytomcat;

import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Administrator on 2019-02-22.
 */
public class SocketProcess extends Thread{
    protected Socket socket;

    public SocketProcess(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Request request = new Request(socket.getInputStream());
            Response response = new Response(socket.getOutputStream());
//	            Map<String, Object> map = Mytomcat.servletMapping;
//
//	            System.out.println("map大小为："+map.size());
//	            for (Map.Entry<String, Object> entry : map.entrySet()) {
//	              System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//	            }
            //从映射中找
            System.out.println(request.getUrl());
            String servelName = (String) Mytomcat.servletMapping.get(request.getUrl());
            System.out.println(servelName);

            if(servelName!=null) {

                //映射有的话找到对应的对象
                Servelt servlet = (Servelt) Mytomcat.servlet.get(servelName);
                if(servlet!=null) {
                    servlet.doGet(request, response);

                }else {
                    System.out.println("找不到对应的servlet");
                }

            }else {
                System.out.println("找不到对应的servletMapping");
            }

            String res = Response.responseHeader+response.getWirte();
            OutputStream outputStream = socket.getOutputStream();

            outputStream.write(res.getBytes("GBK"));
            outputStream.flush();
            outputStream.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
