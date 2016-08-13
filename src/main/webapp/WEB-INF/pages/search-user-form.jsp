<%--
  Created by IntelliJ IDEA.
  User: URAN
  Date: 13.08.2016
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="UTF-8" ?>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Search user page</title>
</head>
<body>
<h1>Search user page</h1>
<p>Here you can specify user name for search.</p>
<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/user/search.html">
    <table>
        <tbody>

        <tr>
            <td>Name:</td>
            <td><form:input path="name" /></td>
        </tr>

        <tr>
            <td><input type="submit" value="Search" /></td>
            <td></td>
        </tr>
        </tbody>
    </table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>

</body>
</html>
