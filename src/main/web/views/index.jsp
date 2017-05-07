<%--
  Created by IntelliJ IDEA.
  User: Олег Пятко
  Date: 07.04.2017
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style name="table_style">

        table{
            border-collapse: collapse;
            width: 100%;
        }

        table tr:nth-child(odd){
            background-color: #FF6565;
        }

        table tr:hover{
            background-color: #B77B7B;
        }

        table tr{
            width: 100%;
            background-color: #FAFAFA;
            transition: background 0.5s ease;
        }

        td, tr, th{
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>ID</th>
            <th>Login</th>
            <th>Phone</th>
            <th>Role</th>
        </tr>

        <c:forEach  var="user" items="${users}">
            <tr>
                <td>${user.userId}</td>
                <td>${user.login}</td>
                <td>${user.phone}</td>
                <td>${user.role}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
