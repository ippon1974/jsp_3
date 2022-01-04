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
<p>Session: ${osel}</p>
<hr>
<p><a href="/news">News</a></p>
<p><a href="/catalog">Catalog</a></p>
<p><a href="/test">Test page</a></p>
<p><a href="/add_cookies">Add cookies</a></p>
<p><a href="/read_cookies">Read cookies</a></p>
<p><a href="/delete_cookies">Delete cookies</a></p>
<p><a href="/login">Login</a></p>
<p><a href="/servlet-headers">Servlet-Headers</a></p>
<ul>
    <li>User: ${Name}</li>
    <li>Password: ${Password}</li>
    <li>Session: ${osel}</li>
    <li>Cookie: ${Cookie}</li>
</ul>
<hr>

<form name="loginForm" method="post" action="/">
    Username: <input type="text" name="username"/> <br/>
    Password: <input type="password" name="password"/> <br/>
    <input type="submit" value="Login" />
</form>

<hr>
<img src="${pageContext.request.contextPath}/img/110.gif" alt="">
<img src="${pageContext.request.contextPath}/img/103.gif" alt="">
<hr>
<%--<c:forEach var="My" items="${listGrills}">--%>
<%--    <a href="/detail/${My.gid}">${My.gname}</a><br>--%>
<%--</c:forEach>--%>


<%--<c:forEach var="template" items="${listGrills}">--%>
<%--    <a href="${pageContext.request.contextPath}/catalog/grills/${template.gtransliterations}">${template.gname}</a><br>--%>
<%--</c:forEach>--%>

</body>
</html>