<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Вентиляционная решетка ${template}</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/catalog/grills"><< Grills</a>
<h1>Вентиляционная решетка ${template}</h1>
Id: ${id}<br>
Name: ${template}<br>
<c:set var="material" value="${material}"/>
<c:if test="${material == null}">
    Material: Не выбран<br>
</c:if>
<c:if test="${material == 1}">
    Material: Латунь<br>
</c:if>
<c:if test="${material == 2}">
    Material: Медь<br>
</c:if>
<c:if test="${material == 3}">
    Material: Сталь<br>
</c:if>

<c:set var="size" value="${size}"/>
<c:if test="${size == null}">
    Size: Не выбран<br>
</c:if>
<c:if test="${size != null}">
    Size: ${size}<br>
</c:if>

Width: ${width}<br>
Height: ${height}<br>

<table cellpadding="5" cellspacing="5" border="0" width="90%">
    <tr valign="top">
        <td width="70%">
            <form method="get" id="search">

                <div>
                    <fieldset>
                        <legend>Материал</legend>
                        <select class="custom-select" id="materialid" name="materialid">
                            <c:forEach var="modelMaterial" items="${modelMaterial}">
                                <c:if test="${material == modelMaterial.mtype}">
                                    <option value="${modelMaterial.mtype}" selected>${modelMaterial.mname}</option>
                                </c:if>
                                <c:if test="${material != modelMaterial.mtype}">
                                    <option value="${modelMaterial.mtype}">${modelMaterial.mname}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </fieldset>
                </div>
                <div>
                    <fieldset>
                        <legend>Толщина листа</legend>
                        <select class="custom-select" id="size" name="size">
                            <c:forEach var="modelSize" items="${modelSize}">
                                <c:if test="${size == modelSize.size}">
                                    <option value="${modelSize.size}" selected>${modelSize.size}</option>
                                </c:if>
                                <c:if test="${size != modelSize.size}">
                                    <option value="${modelSize.size}">${modelSize.size}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </fieldset>
                </div>

                <div>
                    <fieldset>
                        <legend>Длина</legend>
                        <input type="text" value="${width}" name="width" id="width"/>
                    </fieldset>
                </div>

                <div>
                    <fieldset>
                        <legend>Высота</legend>
                        <input type="text"  value="${height}" name="height" id="height"/>
                    </fieldset>
                </div>

                <div>
                    <input type="submit" value="Расчет "/>
                </div>

            </form>
        </td>
        <td valign="top">

        </td>
        <td>
            <c:if test="${material == null}">
                <p><img src="/img/blank/${transliterations}.png"></p>
            </c:if>
            <c:if test="${material == 1}">
                <p><img src="/img/copper/${transliterations}.png"></p>
            </c:if>
            <c:if test="${material == 2}">
                <p><img src="/img/brass/${transliterations}.png"></p>
            </c:if>
            <c:if test="${material == 3}">
                <p><img src="/img/steel/${transliterations}.png"></p>
            </c:if>
        </td>
    </tr>
</table>


</body>
</html>
