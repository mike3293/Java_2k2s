<%--
  Created by IntelliJ IDEA.
  User: npats
  Date: 01.03.2019
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Title</title>
</head>
<body>
<div class="login-container" align="center">
    <section class="login" id="login" >
        <header>
            <h2>Newspapers list</h2>
            <h4>Login</h4>
        </header>
<%--    <div class = "login-page">--%>
    <div class="form">
<p><font color="red">${errorMessage}</font></p>
    <form class="login-form"  action="${pageContext.servletContext.contextPath}/controller?command=login" method="POST">
<%--        <p> <H1>   <caption> Вход  в систему </caption></H1></p>--%>
        <p>   <input  name="loginName" placeholder="Login" type="text" />
        </p>
       <p>   <input name="password" placeholder="Password"  type="password" />
        </p>
           <input class ="button-main-page" type="submit"  value="Sign in"/>

    </form>
  <%--<a href ="${pageContext.request.contextPath}/views/register.jsp"> Регистрация </a>--%>
   <div>
       <form action="${pageContext.servletContext.contextPath}/controller?command=registration_page" method="post">
    <input class ="button-main-page"   type="submit"  value="Sign up"/>
       </form>
   </div>
</div>
    </section>
</div>

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<%--<jsp:forward page="register.jsp"></jsp:forward>--%>
</body>

</html>

