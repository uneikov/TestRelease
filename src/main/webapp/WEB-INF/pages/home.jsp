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
    <style type="text/css">
        h1 {text-align:center;}
        p {text-align:center;}
    </style>
    <title>Home page</title>
</head>
<body>
<div class="dblogo">
    <img src="${pageContext.request.contextPath}/images/frontpage.png" alt="DB logo" width="100%" border="1" />
</div>
<h1>Welcome to my first [Spring MVC/Hibernate/MySQL] web application for JavaRush.</h1>
<h1>Use links below to access the database.</h1>
<p>
    ${message}<br/>
<table class="table table-hover" border="1" cellpadding="5" cellspacing="5" style="width:100%">
    <thead>
    <tr>
        <th style="width:33%">
            <a href="${pageContext.request.contextPath}/list.html">User list</a>
        </th>
        <th style="width:33%">
            <a href="${pageContext.request.contextPath}/add.html">Add new user</a>
        </th>
        <th style="width:33%">
            <a href="${pageContext.request.contextPath}/search.html">User search</a>
        </th>
    </tr>
    </thead>
</table>
</p>
</body>
</html>