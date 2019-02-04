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
        //session本质
        Cookie cookie = new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(20);
        response.addCookie(cookie);
    %>
    <%
        //
        //HttpSession session1 = request.getSession(false);
        HttpSession session1 = request.getSession(true);
        out.print(session1.getId());


        session1.setMaxInactiveInterval(5);//5秒内不访问则该SESSION失效
        out.print(session1.getMaxInactiveInterval());

        //使当前Session失效
        session1.invalidate();




    %>


</body>
</html>
