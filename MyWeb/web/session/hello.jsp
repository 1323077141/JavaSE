<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/1/19
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    //常用方法:
    SessionId:<%=session.getId() %>
    创建时间:<%=session.getCreationTime() %>
    <%=session.getMaxInactiveInterval() %>
    是否最新:<%=session.isNew() %>
    <%=session.getLastAccessedTime() %>

    <% session.invalidate(); %>


    <form method="post" action="hello.jsp">
        username:<input type="text" name="username" />
        <input type="submit" value="submit" />
    </form>

</body>
</html>
