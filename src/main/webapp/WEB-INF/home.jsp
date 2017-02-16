<%@ page import="io.muic.ooc.webapp.mysql.MyJspHelper" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<body>
<h2>UserList </h2>
<p>${info}</p>

    <a href="/addUser">addUser</a>
    <a href="/editUser">editU ser</a>
    <ul>
        <ul>
            <c:forEach items="${myMap}" var="value">
                <li><c:out value="${value}"/><form action="/removeUser" method="get">
                    <input type="hidden" name="username" value=${value}>
                    <input type="submit" value="remove user">
                </form> </li> </li>
            </c:forEach>

        </ul>
    </ul>
    <a href="/login">log out</a>
</body>
</html>