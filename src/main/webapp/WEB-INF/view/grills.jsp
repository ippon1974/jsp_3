<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Grills</title>
</head>
<body>

<p><a href="/catalog"><< Catalig</a></p>

<h1>Grills</h1>

<c:forEach var="template" items="${listGrills}">
    <a href="${pageContext.request.contextPath}/catalog/grills/${template.gtransliterations}">${template.gname}</a><br>
</c:forEach>

</body>
</html>
