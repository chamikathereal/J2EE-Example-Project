<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>500</h1>

    ${requestScope['jakarta.servlet.error.status_code']}
    ${requestScope['jakarta.servlet.error.message']}
</body>
</html>
