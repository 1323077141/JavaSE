<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/1/6
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        //读
        String cookieValue = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies){
                if ("cookiePath".equals(cookie.getName())){
                    cookieValue = cookie.getValue();
                }
            }
        }

        if (cookieValue != null){
            out.print(cookieValue);
        }else{
            out.print("没有指定的Cookie.");
        }


    %>


</body>
</html>
