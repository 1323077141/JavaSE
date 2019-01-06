<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/1/5
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍</title>
</head>
<body>

    <h4>Books page</h4>

    <a href="book.jsp?book=JavaWeb">JavaWeb</a><br><br>
    <a href="book.jsp?book=Java">Java</a><br><br>
    <a href="book.jsp?book=Oracle">Oracle</a><br><br>
    <a href="book.jsp?book=Ajax">Ajax</a><br><br>
    <a href="book.jsp?book=JavaScript">JavaScript</a><br><br>
    <a href="book.jsp?book=Android">Android</a><br><br>
    <a href="book.jsp?book=Jdpm">Jdpm</a><br><br>
    <a href="book.jsp?book=Struts">Struts</a><br><br>
    <a href="book.jsp?book=Hibernate">Hibernate</a><br><br>
    <a href="book.jsp?book=Spring">Spring</a><br><br>
    <br><br>

    <%

        String book = request.getParameter("book");

        //1.确定要删除的cookie
        Cookie[] cookies = request.getCookies();
        List<Cookie> bookCookies = new ArrayList<>();
        Cookie tempCookie = null;
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies){
                String cookieName = cookie.getName();
                if (cookieName.startsWith("ATGUIGU_BOOK_")){
                    bookCookies.add(cookie);
                    if (cookie.getValue().equals(book)){
                        tempCookie = cookie;
                    }
                }
            }
        }

        if (bookCookies.size() > 5 && tempCookie == null){
            tempCookie = bookCookies.get(0);
        }

        //删除Cookie
        if (tempCookie != null){
            tempCookie.setMaxAge(0);
            response.addCookie(tempCookie);
        }

        Cookie cookie = new Cookie("ATGUIGU_BOOK_"+book,book);
        response.addCookie(cookie);



    %>



</body>
</html>
