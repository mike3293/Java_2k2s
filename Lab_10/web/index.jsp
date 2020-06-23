<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 19.04.2020
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab_10</title>
</head>
<%--<style>--%>
<%--    .horizontal {--%>
<%--        margin: 0;--%>
<%--        padding: 0;--%>
<%--    }--%>

<%--    .horizontal li {--%>
<%--        display: inline-block;--%>
<%--        width: 100px;--%>
<%--        min-height: 20px;--%>
<%--        border: 1px solid #000;--%>
<%--        background: green;--%>
<%--    }--%>

<%--    .horizontal li form div {--%>
<%--        background: green;--%>
<%--        color: red;--%>
<%--    }--%>
<%--</style>--%>
<body>
<form action="TimeServletTest" method="get">
    <input type="submit" value="time">
</form>
<form action="UserServlet" method="post">
    <input type="text" name="Login" placeholder="Enter login">
    <input type="password" name="Password" placeholder="Enter password">
    <br>
    <input type="submit" value="Log in">
</form>
<form action="UserRegServletTest" method="post">
    <input type="text" name="Login" placeholder="Enter login">
    <input type="password" name="Password" placeholder="Enter password">
    <br>
    <input type="submit" value="Reg">
</form>
<div style="margin-top: 20px">
    <form action="Task6AServletTest" method="get">
        <div>${mystr1}</div>
        <input type="submit" value="Attribute">
    </form>
    <form action="Task6BServletTest" method="post">
        <div>${mystr2}</div>
        <input type="submit" value="Servlet">
    </form>
    <form action="Task6CServletTest" method="post">
        <div>${mystr3}</div>
        <input type="submit" value="Session">
    </form>
</div>
</body>
</html>
