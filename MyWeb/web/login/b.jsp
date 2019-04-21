<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/3/30
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        //检验用户是否登录，若无则重定向到login.jsp
        Object user = session.getAttribute("user");
        if (user == null){
            response.sendRedirect("login.jsp");
        }
        //将这些代码复制到a,b,c,d,e，太麻烦了

    %>
    <h4>BBB Page</h4>
    <a href="list.jsp">Return ...</a>
</body>
</html>
