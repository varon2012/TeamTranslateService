<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Олег Пятко
  Date: 17.05.2017
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
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
        <h2 class="table-header">Commits</h2>
        <div class="table-default">
            <div class="table-default__row _head">
                <div class="table-default__col _head">#</div>
                <div class="table-default__col _head">Message</div>
                <div class="table-default__col _head">Created At</div>
            </div>
            <c:forEach var="commit" items="${commits}">
                <div class="table-default__row" onclick="window.location='/commit/${commit.entity.idCommit}'">
                    <div class="table-default__col">${commit.entity.hash}</div>
                    <div class="table-default__col">${commit.entity.commitMessage}</div>
                    <div class="table-default__col">${commit.entity.createTime}</div>
                </div>
            </c:forEach>
        </div>
        <div class="select-container">
            <form:form modelAttribute="selectedCommits" method="post" action="/compare">
                <form:select path="commit1">
                    <option value="NONE">FIRST COMMIT</option>
                    <c:forEach var="commit" items="${commits}">
                        <option value="${commit.entity.hash}">${commit.entity.hash}</option>
                    </c:forEach>
                </form:select>
                <form:select path="commit2">
                    <option value="NONE">SECOND COMMIT</option>
                    <c:forEach var="commit" items="${commits}">
                        <option value="${commit.entity.hash}">${commit.entity.hash}</option>
                    </c:forEach>
                </form:select>
                <button class="compare_button" type="submit">Compare</button>
            </form:form>
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
