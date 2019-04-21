<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/4/2
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

        <!--JS 编写Servlet-->
        <%
            //1.获取用户登录信息
            String username = request.getParameter("username");
            //2.若登录信息完整，则把登录信息放到HttpSession
            if (username != null && !username.trim().equals("")){
                session.setAttribute("user",username);
                //3.重定向到list.jsp
                response.sendRedirect("list.jsp");
            }else{
                response.sendRedirect("login.jsp");
            }



        %>

</body>
</html>
