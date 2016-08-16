<%--
  Created by IntelliJ IDEA.
  User: URAN
  Date: 09.08.2016
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<?xml version="1.0" encoding="UTF-8" ?>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>List of users</title>
</head>
<body>
<h1>List of users</h1>
<p>Here you can see users, edit them, remove or update.</p>
<div class="container">

    <table class="table table-hover" border="1" cellpadding="5" cellspacing="5" >
        <thead>
        <tr>
            <th width="10%">ID</th>
            <th width="15%">Name</th>
            <th width="10%">Age</th>
            <th width="10%">Admin</th>
            <th width="20%">Date of creation</th>
            <th width="25%">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>
                    <c:choose>
                        <c:when test="${user.isAdmin==true}">
                            <input type="checkbox" id="center-content-area" name="isAdmin" checked disabled/>
                            <label for="center-content-area">admin</label>
                        </c:when>
                        <c:otherwise>
                            <input type="checkbox" name="isAdmin" disabled/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <fmt:formatDate value="${user.createdDate}" pattern="dd.MM.yyy HH:mm:ss" />
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/user/edit/${user.id}.html">Edit</a><br/>
                    <a href="${pageContext.request.contextPath}/user/delete/${user.id}.html">Delete</a><br/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="pagination">
        <ul>
            <li>
                <c:forEach begin="${startpage}" end="${endpage}" var="p">
                <a href="${pageContext.request.contextPath}/user/list/?page=${p-1}">${p-1}</a>
                </c:forEach>
            </li>
        </ul>
    </div>

</div>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>

</body>
</html>
