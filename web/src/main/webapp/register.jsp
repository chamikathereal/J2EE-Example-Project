<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>APP | Register</title>
</head>
<body>
<h1>Register</h1>
<form method="POST" action="${pageContext.request.contextPath}/register">
    <table>
        <tr>
            <th>Name</th>
            <td>
                <input type="text" name="name"/>
            </td>
        </tr>
        <tr>
            <th>Email</th>
            <td>
                <input type="text" name="email"/>
            </td>
        </tr>
        <tr>
            <th>Contact</th>
            <td>
                <input type="password" name="contact"/>
            </td>
        </tr>
        <tr>
            <th>Password</th>
            <td>
                <input type="password" name="password"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Register"></td>
        </tr>
    </table>
</form>
</body>
</html>
