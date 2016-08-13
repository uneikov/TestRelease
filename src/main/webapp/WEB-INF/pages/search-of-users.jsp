<%--
  Created by IntelliJ IDEA.
  User: URAN
  Date: 13.08.2016
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="UTF-8" ?>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Search of users</title>
</head>
<body>
<h1>Search of users</h1>

<c:if test="${empty users_search}">
    <p>Sorry... no such user(s) found</p>
</c:if>

<c:if test="${not empty users_search}">
    <p>Here you can search users by name, edit them, remove or update.</p>
<table border="1px" cellpadding="0" cellspacing="0" >
    <thead>
    <tr>
        <th width="10%">id</th>
        <th width="15%">name</th>
        <th width="10%">age</th>
        <th width="10%">isAdmin</th>
        <th width="20%">createdDate</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users_search}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.isAdmin}</td>
            <td>${user.createdDate}</td>
            <td>
                <a href="${pageContext.request.contextPath}/user/edit/${user.id}.html">Edit</a><br/>
                <a href="${pageContext.request.contextPath}/user/delete/${user.id}.html">Delete</a><br/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</c:if>
<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>

</body>
</html>