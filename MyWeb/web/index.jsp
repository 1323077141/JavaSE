<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/1/1
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>
  </head>
  <body>

  <form action="loginServlet" method="post">
    user:<input type="text" name ="user" />
    password:<input type="password" name="password" />

    <br><br>
    insteresting:
    <input type="checkbox" name="insteresting" value="reading" /> reading
    <input type="checkbox" name="insteresting" value="game" /> game
    <input type="checkbox" name="insteresting" value="party" /> party
    <input type="checkbox" name="insteresting" value="shopping" /> shopping

    <input type="submit" value="提交" />

  </form>


  </body>
</html>
