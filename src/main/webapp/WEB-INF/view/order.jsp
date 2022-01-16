<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Оформление заказа</title>
</head>

<body>

<table align="center" border="0" cellpadding="2" cellspacing="2" width="70%">
    <tr>
        <td colspan="6">
            <h1>Оформление заказа</h1>
            <h2>Заказ № 1402351</h2>
        </td>
    </tr>

    <c:set var="totalcart" value="${0}" />
    <c:forEach var="orderList" items="${orderList}" varStatus="loop">
        <c:set var="totalcart" value="${totalcart + (orderList.getTotalNDC() * orderList.getNumber())}" />
    <tr>
        <td width="150px">
            <c:if test="${orderList.getTypematerial() == 1}">
                <p><img src="/img/cart/copper/${orderList.getImg()}.png"></p>
            </c:if>
            <c:if test="${orderList.getTypematerial() == 2}">
                <p><img src="/img/cart/brass/${orderList.getImg()}.png"></p>
            </c:if>
            <c:if test="${orderList.getTypematerial() == 3}">
                <p><img src="/img/cart/steel/${orderList.getImg()}.png"></p>
            </c:if>
        </td>
            <td><p>Вентиляционная решетка ${orderList.getNametemplate()}</p></td>
            <td><p>${orderList.getNamematerial()}</p></td>
            <td>${orderList.getWidth()} мм &#215; ${orderList.getHeight()} мм &#215; ${orderList.getSize()} мм</td>
            <td><p>${orderList.getTotalNDC() * orderList.getNumber()} руб.</p></td>
            <td><p>${orderList.getNumber()} шт.</p></td>
    </tr>
        </c:forEach>
    <tr>
        <td colspan="6"><hr></td>
    </tr>
    <tr>
        <td colspan="6">
            <p align="right"><strong>Общая стоимость: ${totalcart} руб.</strong></p>
        </td>
    </tr>

    <tr>
        <td colspan="7">

            <form method="post">
            <table border="0" cellpadding="2" cellspacing="2" width="70%">
                <tr>
                    <td>
                        <label>Имя</label><br>
                        <input type="text" name="name">
                    </td>
                    <td>
                        <label>Телефон</label><br>
                        <input type="text" name="phone">
                    </td>
                    <td>
                        <label>Электронная почта</label><br>
                        <input type="text" name="email">
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <label>Комментарий к заказу</label><br>
                        <textarea style="width: 300px" name="comment"></textarea><br>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <input type="submit" value="Оформить заказ">
                    </td>
                </tr>
            </table>
            </form>

<%--            <form method="post">--%>
<%--                <label>Имя</label><br>--%>
<%--                <input type="text" name="name"><br><br>--%>
<%--                <label>Телефон</label><br>--%>
<%--                <input type="text" name="phone"><br><br>--%>
<%--                <label>Электронная почта</label><br>--%>
<%--                <input type="text" name="email"><br><br>--%>
<%--                <label>Комментарий к заказу</label><br>--%>
<%--                <textarea style="width: 300px" name="comment"></textarea><br><br>--%>
<%--                <input type="submit" value="Оформить заказ">--%>
<%--            </form>--%>
<%--            <form method="post">--%>
<%--                <input type="hidden" name="createdAt" value="">--%>
<%--                <input type="text" name="customerId" VALUE="33">--%>
<%--                <input type="submit" value="ORDER">--%>
<%--            </form>--%>
        </td>
    </tr>
</table>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
</body>
</html>
