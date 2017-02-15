<%@ page import="io.muic.ooc.webapp.mysql.MyJspHelper" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<html>
<body>
<h2>UserList </h2>
<p>${info}</p>

    <a href="/addUser">addUser</a>
    <ul>
        <% ResultSet resultSet = MyJspHelper.getResultSet(); %>
    <%while (resultSet.next())  { %>
        <li><%=resultSet.getString("username")  %>  <button type="button">remove</button>  </li>
        <li><%= "---------------------------- "%>  </li>
    <%}%>
    </ul>
<tr>
    <th> <button type="button">log out</button> </th>
</tr>
</body>
</html>