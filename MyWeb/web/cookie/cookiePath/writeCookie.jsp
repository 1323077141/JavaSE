<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/1/6
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        Cookie cookie  = new Cookie("cookiePath","CookiePathValue");
        //设置Cookie的作用范围
        cookie.setPath(request.getContextPath());
        response.addCookie(cookie);

        //cookie的作用范围：可以作用当前目录和当前目录的子目录，但不能作用于当前目录的上一级目录
    %>
    <a href="cookie2.jsp">To Read Cookie</a>

</body>
</html>
