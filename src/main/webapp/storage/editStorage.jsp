<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit from Storage</title>
</head>
<body>
	<h1 class="mb-4">Modifica elementi magazzino</h1>
	<f:form modelAttribute="storageForm" method="POST"
		action="/storage/update">
		<div class="form-group">
			<f:input path="id" type="hidden" />
			<f:label path="idGame">ID Gioco:</f:label>
			<f:input path="idGame" />
			<f:label path="amountDigital">Quantità (digitale)</f:label>
			<f:input path="amountDigital" />
			<f:label path="amountRetail">Quantità (retail)</f:label>
			<f:input path="amountRetail" />
		</div>

		<button type="submit">Salva</button>
	</f:form>
</body>
</html>