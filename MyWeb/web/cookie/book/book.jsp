<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/1/5
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍详情</title>
</head>
<body>


    <h4>Book Detail Page</h4>


    Book:<%=request.getParameter("book") %>
    <br><br>

    <a href="books.jsp">Return</a>

    <%
        Cookie[] cookies = request.getCookies();
        Cookie tempCookie = null;
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies){
                String cookieName = cookie.getName();
                if (cookieName.startsWith("ATGUIGU_BOOK_")){
                    out.println(cookie.getValue());
                    out.print("<br>");
                }
            }
        }

    %>


</body>
</html>
