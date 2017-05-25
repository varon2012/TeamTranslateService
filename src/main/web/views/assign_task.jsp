<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Олег Пятко
  Date: 17.05.2017
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Branches</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value="/resources/style/style.css"/>">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
<div class="page">
    <header class="page-header">
        <div class="logo-container">
            <img src="<c:url value="/resources/img/logo.png"/>" class="logo-image">
        </div>
        <div class="top-navigation-bar">
            <a href="/branch_list">
                <b>Tasks</b>
            </a>
            <a href="/repositories">
                <b>My Repositories</b>
            </a>
            <a href="/invites">
                <b>Invites</b>
            </a>
            <a href="/logout">
                <b>Logout</b>
            </a>
        </div>
    </header>

    <div class="page-content">
        <div class="login-page">
            <div class="form">
                <h3>Assign Task</h3>
                <form:form method="post" action="/task/${repId}" modelAttribute="task"  class="register-form">
                    <form:select style="margin:0 0 20px 0" path="login">
                        <option value="SELECT USER">SELECT USER</option>
                        <c:forEach var="user" items="${users}">
                            <option value="${user.login}">${user.login}</option>
                        </c:forEach>
                    </form:select>
                    <form:input type="text" placeholder="Task Name" path="name"/>
                    <form:textarea type="text" placeholder="Plain Text" path="plainText"/>
                    <button type="submit">Assign</button>
                </form:form>
            </div>
        </div>
    </div>

    <footer class="page-footer">
        <p class="footer-text">
            <b>Oleg Pyatko &copy; 2017</b>
        </p>
    </footer>
</div>
</body>

</html>
