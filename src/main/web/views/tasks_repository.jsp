<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <h2 class="table-header">Your Tasks</h2>
        <div class="table-default">
            <div class="table-default__row _head">
                <div class="table-default__col _head">User</div>
                <div class="table-default__col _head">Branch</div>
            </div>
            <c:forEach  var="task" items="${branches}">
                <div class="table-default__row" onclick="window.location='/commits/${task.branch.idRepository}'">
                    <div class="table-default__col">${task.user.login}</div>
                    <div class="table-default__col">${task.branch.name}</div>
                </div>
            </c:forEach>
            <form method="get" action="/assign_task/${repId}">
                <button class="compare_button" style="margin: 20px 0" type="submit">Assign Task</button>
            </form>
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
