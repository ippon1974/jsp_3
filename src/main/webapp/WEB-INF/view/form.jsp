<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>form</title>
</head>
<body>

<div><b>${reply}</b></div>
<form method="get" name="myform">
    First Name:<input name="firstName" type="text" size="10" value="${firstName}"><br />
    Last Name:<input name="lastName" type="text" size="10" value="${lastName}"><br />
    Email id:<input name="email" type="text" size="10" value="${email}"><br />
    <input type="submit" value="GO" />
<%--    <input name="Reset" type="reset" value="Reset" />--%>
</form>


</body>
</html>
