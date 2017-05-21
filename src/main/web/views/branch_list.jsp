<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <a href="#">
                <b>Tasks</b>
            </a>
            <a href="#">
                <b>New Repository</b>
            </a>
            <a href="/logout">
                <b>Logout</b>
            </a>
        </div>
    </header>

    <div class="page-content">
        <h2 class="table-header">Your Tasks</h2>
        <div class="table-default">
            <div class="table-default__row _head">
                <div class="table-default__col _head">Repository</div>
                <div class="table-default__col _head">Branch</div>
                <div class="table-default__col _head">Commits</div>
                <div class="table-default__col _head">Latest Commit</div>
            </div>
            <c:forEach  var="task" items="${branches}">
                <div class="table-default__row" onclick="window.location='/commits/${task.entity.idBranch}'">
                    <div class="table-default__col">${task.repositoryName}</div>
                    <div class="table-default__col">${task.entity.name}</div>
                    <div class="table-default__col">${task.commitNumber}</div>
                    <div class="table-default__col">${task.lastCommitMessage}</div>
                </div>
            </c:forEach>
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
