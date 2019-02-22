package com.mytomcat.servlet;

import com.mytomcat.http.Request;
import com.mytomcat.http.Response;

/**
 * Created by Administrator on 2019-02-22.
 */
public class mySecondServlet extends Servelt {
    @Override
    public void doGet(Request request, Response response) {

        System.out.println("进入了我的第二个servlet");
        response.setWirte("进入了第二个servlet");
    }

    @Override
    public void doPost(Request request, Response response) {
        // TODO Auto-generated method stub

    }

}
