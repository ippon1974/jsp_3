<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Вентиляционная решетка ${template}</title>
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
            <h2 class="war">Вычисляем все прямо тут бля! </h2>

                Результаты вычесления. Вычисляем примерную стоимость продукта.
            <dl>
                <dt>Шаблон</dt>
                <dd>${template}</dd>
                <dt>Материал</dt>
                <dd>${modelCalc.getMname()}</dd>
                <dt>Толщина материала</dt>
                <dd>${modelCalc.getSize()}</dd>
                <dt>Длина шаблона</dt>
                <dd>${width}</dd>
                <dt>Высота шаблона</dt>
                <dd>${height}</dd>
            </dl>

            <dl class="calcTotal">
                <dt>Aspect </dt>
                <dd></dd>
                <dt>Площцадь </dt>
                <dd></dd>
                <dt>Стоимость 1 кв. м. склад </dt>
                <dd></dd>
                <dt>Длина реза</dt>
                <dd></dd>
                <dt>Стоимость реза 1 пог. м.</dt>
                <dd></dd>
            </dl>

            <div class="finalCalc">
                <p>Стоимость материала без раскроя</strong>: ' + sessile.getCostmatnotcut() + ' руб. + 30% надбавка за материал ' + sessile.getTaxMat() + ' руб.</p>
                <p>Стоимость раскрооя без материала</strong>: ' + sessile.getCostcutnotmat() + ' руб. + 30% надбавка за раской ' + sessile.getTaxCut() + ' руб.</p>

                <div>
                    <h3>Итого: sessile.getTotal() + '</span>' + ' руб.</h3>
                    <h3>Итого с НДС: sessile.getTotalNdc() + '</span>' + ' руб.'</h3>
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
