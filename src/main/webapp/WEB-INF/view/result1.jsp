<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Шаблон вентиляционной решетки ${name}</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/catalog/grills"><< Grills</a>
<h3>Шаблон вентиляционной решетки ${template}</h3>
Id: ${id}<br>
Name: ${template}
</body>
</html>
