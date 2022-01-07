<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<h1>Корзина</h1>

<table border="1" width="80%">
    <tr>
        <td>Name</td>
        <td>Img</td>
        <td>Material</td>
        <td>Size</td>
        <td>Price</td>
        <td>DataTime</td>
    </tr>
<c:forEach var="listCatr" items="${listCatr}">
    <tr>
        <td>${listCatr.getName()}</td>
        <td>1</td>
        <td>1</td>
        <td>1</td>
        <td>1</td>
        <td>${dtSession}</td>
    </tr>
</c:forEach>
</table>

<p><a href="${pageContext.request.contextPath}/catalog/grills">Contie </a></p>