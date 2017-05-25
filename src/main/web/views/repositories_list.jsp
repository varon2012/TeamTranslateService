<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
        <h2 class="table-header">Repositories</h2>
        <div class="table-default">
            <div class="table-default__row _head">
                <div class="table-default__col _head">Name</div>
                <div class="table-default__col _head">Tasks</div>
            </div>
            <c:forEach var="repository" items="${repositories}">
                <div class="table-default__row" onclick="window.location='/branch_list/${repository.entity.idRepository}'">
                    <div class="table-default__col">${repository.entity.name}</div>
                    <div class="table-default__col">${repository.tasks}</div>
                </div>
            </c:forEach>
        </div>
        <div class="select-container">
            <form method="get" action="new_repo">
                <button class="compare_button" type="submit">New Repository</button>
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
