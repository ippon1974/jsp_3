<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Вентиляционная решетка ${template}</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/catalog/grills"><< Grills</a>
<h3>Вентиляционная решетка ${template}</h3>
Id: ${id}<br>
Name: ${template}
<p><img src="/img/steel/${transliterations}.png">
    <img src="/img/brass/${transliterations}.png">
    <img src="/img/copper/${transliterations}.png">
</p>
</body>
</html>
