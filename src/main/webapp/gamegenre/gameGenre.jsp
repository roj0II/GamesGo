<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Game Genre</title>
</head>
<body>
	<h1>Tabella gioco-genere</h1>
	<form action="/gamegenre/insert">
		<button type="submit">Crea associazione</button>
	</form>
	<table>
		<tr>
			<th>Gioco</th>
			<th>Genere</th>
		</tr>
		<c:forEach var="gamegenre" items="${gameGenreList}">
			<tr>
				<td>${gamegenre.game.title}</td>
				<td>${gamegenre.genre.name}</td>
				<td>
					<form action="/gamegenre/update/${gamegenre.id}" method="POST">
						<button type="submit">Modifica</button>
					</form>
					<form action="/genre/delete/${gamegenre.id}">
						<button type="submit">Elimina</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>