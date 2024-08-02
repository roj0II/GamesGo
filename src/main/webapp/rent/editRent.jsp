<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina per modifcare i rent</title>
</head>
<body>
	<h1>Modifica Rent</h1>
	<f:form modelAttribute="rentForm" action="/rent/update" method="post">
		<f:input path="id" type="hidden" />
		<f:label path="startDate">Start Date</f:label>
		<f:input type="date" path="startDate" />
		<f:label path="endDate">End date</f:label>
		<f:input type="date" path="endDate" />
		<f:label path="productKey">Product key</f:label>
		<f:input path="productKey" />
		<f:label path="type">Type</f:label>
		<f:input path="type" />
		<input type="submit" value="Edit"/>


	</f:form>
</body>
</html>