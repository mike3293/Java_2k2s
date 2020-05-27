<%--
  Created by IntelliJ IDEA.
  User: npats
  Date: 01.03.2019
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Title</title>

</head>
<body>

<nav role="navigation" class="navbar navbar-default">
    <div >
     <nav class="menu" >
        <ul >
            <li><a href="${pageContext.request.contextPath}/controller?command=login_page">Login</a></li>
            <li><a href="${pageContext.servletContext.contextPath}/controller?command=sign_out">Logout</a></li>
        </ul>
     </nav>
    </div>




<div class="container">
    <span /><h4>Welcome,  ${username}</h4>


    <div  class = "layer1">
        <H1>   <caption>Newspapers list</caption> </H1>
        <table class ="container" border="2">

            <tr>
                <th><h1>Name</h1></th>
                <th><h1>Number</h1></th>
            </tr>

            <c:forEach items="${group}" var="person">
            <tr><td>${person.name}</td>
                <td>${person.phone}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
    <div class = "layer2">
        <p><font color="red">${errorMessage}</font></p>
        <form class="login-form" method="POST" action="${pageContext.servletContext.contextPath}/controller?command=add_new_person">
          Add new newspaper:
            <p>  Enter name <input name="nname" type="text" /> </p>
            <p>   Enter number <input name="nphone" type="text" /> </p>
            <input name="nemail" type="text" value="_" style="visibility: hidden;"/>
            <input class ="button-main-page" value="Add" type="submit" />
        </form>
    </div>
</div>
<%--<p> ${lastdate}</p>--%>
</body>
</html>
