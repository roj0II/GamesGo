<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina di inserimento rent</title>
</head>
<body>
<f:form modelAttribute="rentForm" action="/rent/insert" method="post">
<f:label path="startDate">Start date</f:label>
<f:input type="date" path="startDate"/>
<f:label  path="endDate">End date</f:label>
<f:input type="date" path="endDate"/>
<f:label path="type">Type</f:label>
<f:input path="type"/>
<f:label path="productKey">Product key</f:label>
<f:input path="productKey"/>
<input type="submit" value="insert"/>
</f:form>
</body>
</html>