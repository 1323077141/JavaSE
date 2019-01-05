<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/1/5
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
 pageEncoding="UTF-8" session="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <%
        //在JavaWeb规范中使用Cookie
        //1.创建Cookie对象
        //Cookie cookie = new Cookie("name","atguigu");
        //2.调用response方法，把cookie传给客户端
        //response.addCookie(cookie);

        //1.获取Cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 1){
            for (Cookie item : cookies){
                out.print(item.getName() + "----" + item.getValue());
                out.print("<br>");
            }
        }else{
            out.print("没有Cookie,创建一个");
            Cookie cookie = new Cookie("name","atguigu");
            response.addCookie(cookie);
        }

    %>

</body>
</html>
