package com.mytomcat.servlet;

import com.mytomcat.http.Request;
import com.mytomcat.http.Response;

/**
 * Created by Administrator on 2019-02-22.
 */
public abstract class Servelt {
    public void service(Request request, Response response) {

        //判断是调用doget 还是 dopost
        if ("get".equalsIgnoreCase(request.getMethod())) {
            this.doGet(request, response);
        } else {
            this.doPost(request, response);
        }


    }

    public abstract void doGet(Request request, Response response);

    public abstract void doPost(Request request, Response response);
}
