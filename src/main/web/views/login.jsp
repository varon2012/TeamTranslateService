<%--
  Created by IntelliJ IDEA.
  User: Олег Пятко
  Date: 08.05.2017
  Time: 1:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head></head>
<body>
<h1>Login</h1>
<form name='f' action="login" method='POST'>
    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
        </tr>
    </table>
</form>
</body>

<script type="text/javascript">
    function validate() {
        if (document.f.username.value == "" && document.f.password.value == "") {
            alert("Username and password are required");
            document.f.username.focus();
            return false;
        }
        if (document.f.username.value == "") {
            alert("Username is required");
            document.f.username.focus();
            return false;
        }
        if (document.f.password.value == "") {
            alert("Password is required");
            document.f.password.focus();
            return false;
        }
    }
</script>

</html>