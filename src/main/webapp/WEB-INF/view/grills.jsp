<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Grills</title>
</head>
<body>

<h1>Grills</h1>


<c:forEach var="My" items="${listGrills}">
    <c:set var="name" value="${My.gname}"/>
    <a href="${pageContext.request.contextPath}/catalog/grills?name=${fn:toLowerCase(name)}">${My.gname}</a><br>
</c:forEach>

</body>
</html>
