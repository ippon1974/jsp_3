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
    <tr>
        <td>${modelNameSession}</td>
        <td></td>
        <td>${materialSession}</td>
        <td>${sizeSession} * ${widthSession} * ${heightSession}</td>
        <td>${totalSession}</td>
        <td>${dtSession}</td>
    </tr>
</table>

</body>
</html>
