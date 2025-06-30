<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/30/2025
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Welcome to Home </h1>
<p>Welcome to Home ${sessionScope.user}</p>
<a href="${pageContext.request.contextPath}/logout">Log out</a>
</body>
</html>
