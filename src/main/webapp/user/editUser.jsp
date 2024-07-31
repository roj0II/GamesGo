<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit User</title>
</head>
<body>
	<h1 class="mb-4">Modifica utente</h1>
	<f:form modelAttribute="userForm" method="POST" action="/user/update">
		<div class="form-group">
			<f:input path="id" type="hidden" />
			<f:label path="username">Username:</f:label>
			<f:input path="username" />
			<f:label path="name">Nome:</f:label>
			<f:input path="name" />
			<f:label path="surname">Cognome:</f:label>
			<f:input path="surname" />
			<f:label path="address">Indirizzo:</f:label>
			<f:input path="address" />
			<f:label path="phone">Telefono:</f:label>
			<f:input path="phone" />
			<f:label path="email">E-mail:</f:label>
			<f:input path="email" />
			<f:label path="password">Password:</f:label>
			<f:input path="password" />
			<f:label path="admin">Amministratore:</f:label>
			<f:input path="admin" />
		</div>

		<button type="submit">Salva</button>
	</f:form>
</body>
</html>