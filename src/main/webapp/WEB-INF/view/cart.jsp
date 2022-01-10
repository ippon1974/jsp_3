<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Корзина</title>
</head>
<body>

<form action="/update" method="post">
<table align="center" cellspacing="2" cellpadding="2" border="0" width="70%">
    <tr>
        <td colspan="7">
            <h1>Корзина</h1>
        </td>
    </tr>
<%--    <tr>--%>
<%--        <td>Шаблон</td>--%>
<%--        <td>Изображение</td>--%>
<%--        <td>Кол-во</td>--%>
<%--        <td>Материал</td>--%>
<%--        <td>Рзмеры</td>--%>
<%--        <td>Стоимость</td>--%>
<%--        <td>-</td>--%>
<%--    </tr>--%>
    <c:set var="totalcart" value="${0}" />
<c:forEach var="listCatr" items="${listCatr}" varStatus="loop">
<%--    <input type="hidden" name="idnumber" value="${listCatr.getId()}">--%>
<%--    <input type="hidden" name="nameTemplate" value="${listCatr.getName()}">--%>
    <c:set var="totalcart" value="${totalcart + (listCatr.getTotalNDC() * listCatr.getNumber())}" />
    <tr>
<%--        <td width="205px"><img src="/img/showcase/${listCatr.getImg()}.png" alt=""></td>--%>
        <td width="150px">
            <c:if test="${listCatr.getTypematerial() == 1}">
                <p><img src="/img/cart/copper/${listCatr.getImg()}.png"></p>
            </c:if>
            <c:if test="${listCatr.getTypematerial() == 2}">
                <p><img src="/img/cart/brass/${listCatr.getImg()}.png"></p>
            </c:if>
            <c:if test="${listCatr.getTypematerial() == 3}">
                <p><img src="/img/cart/steel/${listCatr.getImg()}.png"></p>
            </c:if>
        </td>
        <td><a target="_blank" href="${pageContext.request.contextPath}/catalog/grills?template=${listCatr.getImg()}&materialid=${listCatr.getTypematerial()}&size=2&width=${listCatr.getWidth()}&height=${listCatr.getHeight()}">Вентиляционная решетка ${listCatr.getName()}</a></td>
        <td>${listCatr.getNamematerial()}</td>
        <td>${listCatr.getWidth()} мм &#215; ${listCatr.getHeight()} мм &#215; ${listCatr.getSize()} мм</td>
        <td>${listCatr.getTotalNDC() * listCatr.getNumber()} руб.</td>
        <td width=""><input type="text" name="number" size="2em" value="${listCatr.getNumber()}"></td>
        <td><a href="/delete?id=${listCatr.getId()}">Удалить</a></td>
    </tr>
</c:forEach>
    <tr>
        <td colspan="7">
            <div align="left">
                <p><a href="${pageContext.request.contextPath}/catalog/grills">Продолжить покупки</a> | <a href="/">Оформить заказ </a></p>
            </div>

            <c:if test="${totalcart != 0}">
                <div align="right"><input type="submit" value="Обновить"></div>
            </c:if>
            <p align="right"><strong>Общая стоимость: ${totalcart} руб.</strong></p>
        </td>
    </tr>
</table>

</form>

<hr>
