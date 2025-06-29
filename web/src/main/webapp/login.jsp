<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>APP | Login</title>
</head>
<body>
<form method="POST" action="${pageContext.request.contextPath}/login">
    <table>
        <tr>
            <th>Email</th>
            <td>
                <input type="text" name="email"/>
            </td>
        </tr>
        <tr>
            <th>Password</th>
            <td>
                <input type="password" name="password"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Login"></td>
        </tr>
    </table>
</form>
</body>
</html>
