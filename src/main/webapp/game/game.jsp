<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Title</th>
			<th>Author</th>
			<th>Description</th>
			<th>Price Retail</th>
			<th>Price Digital</th>
			<th>Release date</th>


		</tr>
		<c:forEach var="game" items="${gameList }">
			<td>${game.getTitle()}</td>
			<td>${game.getAuthor() }</td>
			<td>${game.getDescription() }</td>
			<td>${game.getPriceRetail() }</td>
			<td>${game.getPriceDigital() }</td>
			<td>${game.getReleaseDate() }</td>
			<td><a class="btn btn-primary" href="http://localhost:8080/gameCtr/edit/${game.getId()" >Edit</a></td>
			<td><a class="btn btn-primary" href="http://localhost:8080/gameCtr/delete/${game.getId() }">Delete</a>
		</c:forEach>


	</table>
</body>
</html>