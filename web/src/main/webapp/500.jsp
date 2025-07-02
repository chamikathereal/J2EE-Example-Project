<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/2/2025
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>500</h1>
${requestScope['jakarta.servlet.error.status_code']}
${requestScope['jakarta.servlet.error.message']}
</body>
</html>
