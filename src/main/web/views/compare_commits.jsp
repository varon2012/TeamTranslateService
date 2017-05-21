<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>Commits</title>
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
        <div class="comparer-container">
            <div class="plain-text-container">
                <h2 class="table-header">Plain Text</h2>
                <p>
                    ${compare.plainText}
                </p>
            </div>
            <div class="plain-text-container">
                <h2 class="table-header">Compared Result</h2>
                <p>
                    ${compare.compareResult}
                </p>
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
