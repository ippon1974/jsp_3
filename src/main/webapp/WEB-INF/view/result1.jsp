<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Вентиляционная решетка ${template}</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/page.css">
</head>
<body>

<a href="${pageContext.request.contextPath}/catalog/grills"><< Grills</a>

<%--Id: ${id}<br>--%>
<%--Name: ${template}<br>--%>
<%--<c:set var="material" value="${material}"/>--%>
<%--<c:if test="${material == null}">--%>
<%--    Material: Не выбран<br>--%>
<%--</c:if>--%>
<%--<c:if test="${material == 1}">--%>
<%--    Material: Латунь<br>--%>
<%--</c:if>--%>
<%--<c:if test="${material == 2}">--%>
<%--    Material: Медь<br>--%>
<%--</c:if>--%>
<%--<c:if test="${material == 3}">--%>
<%--    Material: Сталь<br>--%>
<%--</c:if>--%>

<%--<c:set var="size" value="${size}"/>--%>
<%--<c:if test="${size == null}">--%>
<%--    Size: Не выбран<br>--%>
<%--</c:if>--%>
<%--<c:if test="${size != null}">--%>
<%--    Size: ${size}<br>--%>
<%--</c:if>--%>

<%--Width: ${width}<br>--%>
<%--Height: ${height}<br>--%>

<table cellpadding="5" cellspacing="5" border="0" width="95%">
    <tr>
        <td valign="top" colspan="3">
            <h1>Вентиляционная решетка ${template}</h1>
        </td>
    </tr>
    <tr valign="top">
        <td width="40%">
            <form method="get" id="search">
                <div>
                    <fieldset>
                        <legend>Шаблон</legend>
                        <select class="custom-select" id="template" name="template">
                            <c:forEach var="listGrills" items="${listGrills}">
                                <c:if test="${templateuri == listGrills.gtransliterations}">
                                    <option value="${listGrills.gtransliterations}" selected>${listGrills.gname}</option>
                                </c:if>
                                <c:if test="${templateuri != listGrills.gtransliterations}">
                                    <option value="${listGrills.gtransliterations}">${listGrills.gname}</option>
                                </c:if>
<%--                                <option value="${listGrills.gtransliterations}">${listGrills.gname}</option>--%>
                            </c:forEach>
                        </select>
                    </fieldset>
                </div>
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

            <div>
                <form action="${pageContext.request.contextPath}/cart" name="cart" method="post">
                    <input type="submit" value="В корзину">
                </form>
            </div>

            <h2 class="war">Вычисляем все прямо тут бля! </h2>

                Результаты вычесления. Вычисляем примерную стоимость продукта.
            <dl>
                <dt>Шаблон</dt>
                <dd>${template}</dd>
                <dt>Материал</dt>
                <dd>${modelCalc.getMname()}</dd>
                <dt>Толщина материала</dt>
                <dd>${modelCalc.getSize()} мм.</dd>
                <dt>Длина шаблона</dt>
                <dd>${width} мм.</dd>
                <dt>Высота шаблона</dt>
                <dd>${height} мм.</dd>
            </dl>

            <dl class="calcTotal">
                <dt>Aspect </dt>
                <dd>${aspect}</dd>
                <dt>Площцадь </dt>
                <dd>${area} кв. м.</dd>
                <dt>Стоимость 1 кв. м. склад </dt>
                <dd>${modelCalc.getCost()} руб.</dd>
                <dt>Длина реза</dt>
                <dd>${allcutlength} пог. м.</dd>
                <dt>Стоимость реза 1 пог. м.</dt>
                <dd>${modelCalc.getCostmcut()}  руб.</dd>
            </dl>

            <div class="finalCalc">
                <p>Стоимость материала без раскроя: ${costmatnotcut} руб. + 30% надбавка за материал ${addTaxMat} руб.</p>
                <p>Стоимость раскрооя без материала: ${costcutnotmat} руб. + 30% надбавка за раской ${addTaxCut} руб.</p>

                <div>
                    <h3>Итого: ${total} руб.</h3>
                    <h3>Итого с НДС: ${totalNdc} руб.</h3>
                </div>
            </div>

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
