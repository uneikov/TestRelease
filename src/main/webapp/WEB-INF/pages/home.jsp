<%--
  Created by IntelliJ IDEA.
  User: URAN
  Date: 08.08.2016
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>

<?xml version="1.0" encoding="UTF-8" ?>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Home page</title>
</head>
<body>
<h1>Home page</h1>
<p>
    ${message}<br/>
    <a href="${pageContext.request.contextPath}/user/add.html">Add new user</a><br/>
    <a href="${pageContext.request.contextPath}/user/list.html">User list</a><br/>
</p>
</body>
</html>