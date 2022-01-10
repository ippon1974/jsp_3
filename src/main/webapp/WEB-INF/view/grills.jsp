<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Grills</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<p><a href="/catalog"><< Catalig</a></p>

<a href="/catalog/form">FORM</a>

<h1>Grills</h1>

<c:if test="${cartService != null}">
    <div align="right"><a href="/cart">Корзина</a></div>
</c:if>

<div id="images">

    <c:forEach var="listGrills" items="${listGrills}">
        <div class="about">
            <figure>
                <a href="/catalog/grills?template=${listGrills.gtransliterations}">
                    <img src="/img/showcase/${listGrills.gtransliterations}.png"></a>
<%--                <figcaption>ID: ${listGrills.gid}<br><a href="/catalog/grills/${listGrills.gtransliterations}">${listGrills.gname}</a><br></figcaption>--%>
                <figcaption>ID: ${listGrills.gid}<br><a href="/catalog/grills?template=${listGrills.gtransliterations}">${listGrills.gname}</a><br></figcaption>
            </figure>
        </div>
    </c:forEach>

</div>



</body>
</html>
