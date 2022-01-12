<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Оформление заказа</title>
</head>

<body>


<table align="center" border="1" width="80%">
    <tr>
        <td>
            <h1>Оформление заказа</h1>
            <h2>Заказ № 1402351</h2>
        </td>
    </tr>

        <c:forEach var="modelOrderList" items="${modelOrderList}" varStatus="loop">
    <tr>
            <td><p>${modelOrderList.getName()}</p></td>
    </tr>
        </c:forEach>

    <tr>
        <td>
            <form method="post">
                <%--    <input type="text" name="id">--%>
                <input type="text" name="name">
                <input type="submit" value="GO">
            </form>
        </td>
    </tr>
</table>


</body>
</html>
