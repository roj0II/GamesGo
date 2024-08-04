<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert User</title>
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
	--main-color: #FF6666;
}
</style>
</head>
<body>
	<div class="container">
		<div class="header-buttons">
			<a href="/user/" class="btn btn-primary"><i
				class="fas fa-arrow-left"></i> Indietro</a>
			<div class="icons">
				<i class="fa-solid fa-users fa-2xl"></i>
			</div>
			<h1 class="header-title">Inserisci Utente</h1>
			<a href="/admin" class="btn btn-success"><i class="fas fa-home"></i>
				Home</a>
		</div>
		<f:form modelAttribute="userForm" method="POST" action="/user/insert">
			<table class="table table-striped">
				<thead>
					<tr>
						<td>Username</td>
						<td><f:input class="input-label" path="username" /></td>
					</tr>
					<tr>
						<td>Nome</td>
						<td><f:input class="input-label" path="name" /></td>
					</tr>
					<tr>
						<td>Cognome</td>
						<td><f:input class="input-label" path="surname" /></td>
					</tr>
					<tr>
						<td>Indirizzo</td>
						<td><f:input class="input-label" path="address" /></td>
					</tr>
					<tr>
						<td>Telefono</td>
						<td><f:input class="input-label" path="phone" /></td>
					</tr>
					<tr>
						<td>E-mail</td>
						<td><f:input class="input-label" path="email" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><f:input class="input-label" path="password" /></td>
					</tr>
					<tr>
						<td>Amministratore</td>
						<td><f:input class="input-label" path="admin" /></td>
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