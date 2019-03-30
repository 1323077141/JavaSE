package com.mytomcat.servlet;

import com.mytomcat.http.Request;
import com.mytomcat.http.Response;

/**
 * Created by Administrator on 2019-02-22.
 */
public class myFirstServlet extends Servelt{
    @Override
    public void doGet(Request request, Response response) {
        System.out.println("进入了我的第一个servlet");
        response.setWirte("进入了第一个servlet");
    }

    @Override
    public void doPost(Request request, Response response) {


    }


}
