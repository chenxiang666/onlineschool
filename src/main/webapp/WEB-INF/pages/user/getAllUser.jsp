<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liufree
  Date: 5/11/17
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<tbody id="userTb">
<c:forEach var="user" items="${userList}" varStatus="status">
    <tr>
        <td><input type="checkbox" ></td>
        <td>${user.userId }</td>
        <td>${user.username }</td>
        <td>${user.password}</td>
        <td>${user.firstName}</td>
        <td>${user.lastName }</td>
        <td>${user.email}</td>
        <br>
    </tr>
</c:forEach>
</tbody>
</body>
</html>
