<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/4/20
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="AuthorityServlet?method=getAuthorities" method="post">
        name:<input type="text" name="username" />
        <input type="submit" value="Submit" />
    </form>

    <c:if test="${requestScope.user != null}">
        <br><br>
        ${requestScope.user.username } 的权限是:
        <br><br>
        <form action="AuthorityServlet?method=updateAuthority">
            <input type="hidden" name="username" value="${requestScope.user.username}" />
            <input type="checkbox" name="authority" value="Article-1" />Article-1
            <br><br>
            <input type="checkbox" name="authority" value="Article-2" />Article-2
            <br><br>
            <input type="checkbox" name="authority" value="Article-3" />Article-3
            <br><br>
            <input type="checkbox" name="authority" value="Article-4" />Article-4
            <br><br>
            <input type="submit" value="Update" />

        </form>

    </c:if>


</body>
</html>
