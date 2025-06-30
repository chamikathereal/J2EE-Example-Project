<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

<h1>Home</h1>

<c:if test="${empty pageContext.request.userPrincipal}">
    <a href="${pageContext.request.contextPath}/register.jsp">Register</a>
    <a href="${pageContext.request.contextPath}/login.jsp">Login</a>
</c:if>
<c:if test="${not empty pageContext.request.userPrincipal}">
    <a href="${pageContext.request.contextPath}/logout">Log out</a>
</c:if>
</body>
</html>
