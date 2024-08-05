<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edit from storage</title>
<!-- Web Icon -->
<link rel="icon" type="image/x-icon"
	href="https://www.svgrepo.com/show/37992/male-and-female-symbol.svg">
<!-- Bootstrap CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	rel="stylesheet">
<!-- Our CSS -->
<link href="/css/styleEntity.css" rel="stylesheet">
<style>
:root {
	--main-color: #6699FF;
}
</style>
</head>
<body>
	<div class="container">
		<div class="header-buttons">
			<a href="/storage/" class="btn btn-primary"><i
				class="fas fa-arrow-left"></i> Indietro</a>
			<div class="icons">
				<i class="fa-solid fa-box-open fa-2xl"></i>
			</div>
			<h1 class="header-title">Modifica dettagli magazzino</h1>
			<a href="/admin" class="btn btn-success"><i class="fas fa-home"></i>
				Home</a>
		</div>

		<f:form modelAttribute="storageForm" method="POST"
			action="/storage/update">
			<table class="table table-striped">
				<thead>
					<tr>
						<td>ID Gioco<f:input path="id" type="hidden" /></td>
						<td><f:input class="input-label" path="idGame" /></td>
					</tr>
					<tr>
						<td>Digitale<f:input path="id" type="hidden" /></td>
						<td><f:input class="input-label" path="amountDigital" /></td>
					</tr>
					<tr>
						<td>Retail<f:input path="id" type="hidden" /></td>
						<td><f:input class="input-label" path="amountRetail" /></td>
					</tr>
				</thead>
			</table>
			<button type="submit" class="buttons">Salva</button>
		</f:form>
	</div>

	<jsp:include page="../fragments/popup.jsp" />

	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>