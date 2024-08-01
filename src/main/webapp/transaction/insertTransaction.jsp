<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Transaction</title>
</head>
<body>
<h1 class="mb-4">Inserisci una nuova transazione</h1>
	<f:form modelAttribute="transactionForm" method="POST"
		action="/transaction/insert">
		<div class="form-group">
			<f:label path="idUser">ID User:</f:label>
			<f:input path="idUser" />
			<f:label path="idGame">ID Gioco:</f:label>
			<f:input path="idGame" />
		</div>

		<button type="submit">Salva</button>
	</f:form>
</body>
</html>