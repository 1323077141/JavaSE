package com.mytomcat.http;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Administrator on 2019-02-22.
 */
public class Response {
    public OutputStream outputStream;

    public String wirte;


    public static final String responseHeader="HTTP/1.1 200 \r\n"
            + "Content-Type: text/html\r\n"
            + "\r\n";

    public Response(OutputStream outputStream) throws IOException {
        this.outputStream= outputStream;
    }

    public String getWirte() {
        return wirte;
    }

    public void setWirte(String wirte) {
        this.wirte = wirte;
    }

    public Response(){

    }

}
