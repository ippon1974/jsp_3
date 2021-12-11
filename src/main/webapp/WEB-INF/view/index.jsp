<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:forward page="/WEB-INF/view/index.jsp" />--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello ${name}</title>

</head>

<body>
<h1>Hello ${name}</h1>
<p>${message}</p>
<hr>
<p><a href="/news">News</a></p>
<p><a href="/test">Test page</a></p>
<p><a href="/add_cookies">Add cookies</a></p>
<p><a href="/read_cookies">Read cookies</a></p>
<p><a href="/delete_cookies">Delete cookies</a></p>
<p><a href="/login">Login</a></p>
</body>
</html>