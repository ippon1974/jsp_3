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
<%--<p>--%>
<%--    <img width="150" height="300" src="/img/blank/${transliterations}.png">--%>
<%--    <img width="150" height="300" src="/img/steel/${transliterations}.png">--%>
<%--    <img width="150" height="300" src="/img/brass/${transliterations}.png">--%>
<%--    <img width="150" height="300" src="/img/copper/${transliterations}.png">--%>
<%--</p>--%>

<form>
    <div>
        <fieldset>
            <legend>Материал</legend>
            <select class="custom-select" id="materialid" name="materialid">
                <c:forEach var="modelMaterial" items="${modelMaterial}">
                    <option value="${modelMaterial.mtype}">${modelMaterial.mname}</option>
                </c:forEach>
            </select>
        </fieldset>
    </div>
    <div>
        <fieldset>
            <legend>Толщина листа</legend>
            <select class="custom-select" id="size" name="size">
                <c:forEach var="modelSize" items="${modelSize}">
                    <option value="${modelSize.size}">${modelSize.size}</option>
                </c:forEach>
            </select>
        </fieldset>
    </div>

    <div>
        <fieldset>
            <legend>Длина</legend>
            <input type="text" value="0" name="width" id="width"/>
        </fieldset>
    </div>

    <div>
        <fieldset>
            <legend>Высота</legend>
            <input type="text"  value="0" name="height" id="height"/>

        </fieldset>
    </div>

    <div>
        <input type="submit" value="Расчет "/>
    </div>

</form>

</body>
</html>
