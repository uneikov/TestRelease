<%--
  Created by IntelliJ IDEA.
  User: URAN
  Date: 08.08.2016
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>

<?xml version="1.0" encoding="UTF-8" ?>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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