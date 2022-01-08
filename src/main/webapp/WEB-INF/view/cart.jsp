<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<h1>Корзина</h1>

<form action="/update" method="post">
<table border="0" width="80%">
    <tr>
        <td>Шаблон</td>
        <td>Изображение</td>
        <td>Кол-во</td>
        <td>Материал</td>
        <td>Рзмеры решетки</td>
        <td>Стоимость</td>
        <td>-</td>
    </tr>
<c:forEach var="listCatr" items="${listCatr}" varStatus="loop">
<%--    <input type="hidden" name="idnumber" value="${listCatr.getId()}">--%>
<%--    <input type="hidden" name="nameTemplate" value="${listCatr.getName()}">--%>
    <tr>
        <td>${listCatr.getName()}</td>
        <td><img src="/img/showcase/${listCatr.getImg()}.png" alt=""></td>
        <td><input type="text" name="number" value="${listCatr.getNumber()}"></td>
        <td>${listCatr.getNamematerial()}</td>
        <td>${listCatr.getWidth()} * ${listCatr.getHeight()} * ${listCatr.getSize()}</td>
        <td>${listCatr.getTotalNDC() * listCatr.getNumber()}</td>
        <td><a href="/delete?id=${listCatr.getId()}">Удалить</a></td>
    </tr>
</c:forEach>
</table>
    <input type="submit" value="Обновить">
</form>

<p><a href="${pageContext.request.contextPath}/catalog/grills">Продолжить покупки</a></p>
<hr>
