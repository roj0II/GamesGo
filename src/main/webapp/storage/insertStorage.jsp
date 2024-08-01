<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert into Storage</title>
</head>
<body>
<h1 class="mb-4">Inserisci in Magazzino</h1>
	<f:form modelAttribute="storageForm" method="POST"
		action="/storage/insert">
		<div class="form-group">
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