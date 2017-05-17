<%--
  Created by IntelliJ IDEA.
  User: Олег Пятко
  Date: 08.05.2017
  Time: 1:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <link rel='stylesheet' href="<c:url value="/resources/style/style.css"/>">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
<div class="page">
    <header class="page-header">
        <div class="logo-container">
            <img src="<c:url value="/resources/img/logo.png"/>" class="logo-image">
        </div>
        <div class="top-navigation-bar">
            <a href="#">
                <b>Home</b>
            </a>
            <a href="#">
                <b>About</b>
            </a>
        </div>
    </header>

    <div class="page-content">
        <div class="login-page">
            <div class="form">
                <!--	<form class="register-form">
                        <input type="text" placeholder="name"/>
                        <input type="password" placeholder="password"/>
                        <input type="text" placeholder="email address"/>
                        <button>create</button>
                        <p class="message">Already registered? <a href="#">Sign In</a></p>
                    </form>-->
                <form:form action="auth" method="post" modelAttribute="loginEntity" class="login-form">
                    <form:input type="text" placeholder="username" path="username"/>
                    <form:input type="password" placeholder="password" path="password"/>
                    <button type="submit">login</button>
                    <p class="message">Not registered? <a href="./register.html">Create an account</a></p>
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
