<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://mycompany.com//mytags" prefix="MyTags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%@include file="../Header.jsp"%><br>
<body>
Welcome ${name}! <br>
Last login is  ${last_login}!<br>
Login number ${login_number}!<br>
User role ${user_role}!<br>
<h2>Newspapers List</h2>
<p><a href='<c:url value="/create" />'>Create new</a></p>
<table>
    <tr><th>Number</th></tr>
    <c:forEach var="newspaper" items="${newspapers}">
        <tr><td>${newspaper.number}</td>
            <td>
                <a href='<c:url value="/edit?id=${newspaper.id}" />'>Edit</a> |
                <form method="post" action='<c:url value="/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${newspaper.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>


<h2>Test JSTL</h2>
<c:catch var="DefException">
    <% int num = 100 / 0; %>
</c:catch>
The Exception is : ${DefException}
<br>
<c:out value="      100/0 is ${100/0}"></c:out>
<br>
<br>
<c:set var="zero" value="0"/>
<c:forEach var="count" begin="${zero}" end="10">
    <c:if test="${count != 7}">
        <c:out value="..${count}.."/>
    </c:if>
    <c:if test="${count == 7}">
        <c:out value="..Now count is seven.."/>
    </c:if>
</c:forEach>
<br>
<h2>Format Tag example</h2>
<c:set var="numberr" value="99.40"/>
<fmt:parseNumber var="n" integerOnly="true" type="number" value="${numberr}"/>
Parse Number is : <c:out value="${n}"/>
<br>
<c:set var="date" value="02-04-2018"/>
<fmt:parseDate value="${date}" var="pd" pattern="dd-MM-yyyy"/>
Parse Date is : <c:out value="${pd}"/>
<br>
<c:set var="Date" value="<%=new java.util.Date()%>"/>
Format Date is : <fmt:formatDate type="time" value="${Date}"/>
<h2>SQL</h2>
<sql:setDataSource var="myDB" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/java?useUnicode=true&serverTimezone=UTC&useSSL=false"
                   user="root" password="root"/>
<sql:query dataSource="${myDB}" var="newsp">
    SELECT * FROM newspaper;
</sql:query>
<c:forEach var="row" items="${newsp.rows}">
    <div class="center">
        <c:out value="number: ${row.newspapernumber}"/>
        <c:out value=", "/>
        <c:out value="user: ${row.userid}"/>
    </div>
    <hr>
</c:forEach>
<br>
<h2>XML</h2>
<c:set var="subj">
    <subject>
        <id>1</id>
        <name sub="OOTP">OOP</name>
        <course>2</course>
    </subject>
</c:set>
<x:parse xml="${subj}" var="output"/>
<b>Name: </b>
<x:out select="$output/subject[1]/name"/><br>
<b>Sub Name: </b>
<x:out select="$output/subject[1]/name/@sub" /><br>
<b>Course: </b>
<x:out select="$output/subject[1]/course" />
<br>
length of length: ${fn:length("length")}
<br>
<h2>Tag table</h2>
<MyTags:GMPTable objects="${newspapers}"/>
</body>
<c:import var="displayfile" url="../Footer.jsp">
</c:import>
<c:out value="${displayfile}"/><br>
</html>
