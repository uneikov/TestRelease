<%--
  Created by IntelliJ IDEA.
  User: URAN
  Date: 08.08.2016
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
<h1>Home page</h1>
<p>
    ${message}<br/>
    <a href="${pageContext.request.contextPath}/user/add.html">Add new team</a><br/>
    <a href="${pageContext.request.contextPath}/user/list.html">Team list</a><br/>
</p>
</body>
</html>