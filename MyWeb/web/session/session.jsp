<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/1/6
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session</title>
</head>
<body>


    <%=session.getId() %>
    <%
        Cookie cookie = new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(20);
        response.addCookie(cookie);
        
    %>


</body>
</html>
