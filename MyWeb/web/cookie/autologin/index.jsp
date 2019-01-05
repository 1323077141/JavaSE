<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/1/5
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        //若可以请求到参数，则打印信息，并保存到cookie中，并设置为30S
    String name = request.getParameter("name");
    if (name != null && !"".equalsIgnoreCase(name.trim())){
        Cookie cookie = new Cookie("name",name);
        cookie.setMaxAge(30);
        response.addCookie(cookie);
    }else{
        //若不能，则从Cookie中读取用户信息，若存在则打印信息
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies){
                String cookieName = cookie.getName();
                if ("name".equals(cookieName)){
                    String value = cookie.getValue();
                    name = value;
                }
            }
        }
    }

    //若不能从cookie中读取，则跳转到login.jsp
    if (name != null && !"".equals(name.trim())){
        out.print("Hello:" + name);
    }else{
        response.sendRedirect("hello.jsp");
    }

    %>

</body>
</html>
