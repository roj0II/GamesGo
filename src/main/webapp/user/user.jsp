<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
</head>
<body>
<h1>Utenti</h1>
	<form action="/user/insert">
		<button type="submit">Inserisci utenti</button>
	</form>
	<table>
		<tr>
			<th>Username</th>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Indirizzo</th>
			<th>Telefono</th>
			<th>E-mail</th>
			<th>Password</th>
			<th>Admin</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.username}</td>
				<td>${gamegenre.name}</td>
				<td>${gamegenre.surname}</td>
				<td>${gamegenre.adress}</td>
				<td>${gamegenre.phone}</td>
				<td>${gamegenre.email}</td>
				<td>${gamegenre.password}</td>
				<td>${gamegenre.admin}</td>
				<td>
					<form action="/user/update/${user.id}">
						<button type="submit">Modifica</button>
					</form>
					<form action="/user/delete/${user.id}">
						<button type="submit">Elimina</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>