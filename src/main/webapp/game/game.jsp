<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<script>
function deleteGame(gameId) {
    if (confirm('Are you sure you want to delete this game?')) {
        var form = document.createElement('form');
        form.method = 'post';
        form.action = '/game/delete/' + gameId;
        
        var input = document.createElement('input');
        input.type = 'hidden';
        input.name = '_method';
        input.value = 'delete';
        form.appendChild(input);

        document.body.appendChild(form);
        form.submit();
    }
}
</script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
  border: 1px solid black;
 
}

table.center {
  margin-left: auto; 
  margin-right: auto;
}
</style>
</head>
<body>

	<table class="center">
		<tr>
			<th>Title</th>
			<th>Author</th>
			<th>Description</th>
			<th>Photo_url</th>
			<th>Price Retail</th>
			<th>Price Digital</th>
			<th>Release date</th>


		</tr>
		<tbody>
			<c:forEach var="game" items="${gameListForm}">
				<tr>
					<td>${game.id}</td>
					<td>${game.title}</td>
					<td>${game.author }</td>
					<td>${game.photoUrl }</td>
					<td>${game.description }</td>
					<td>${game.priceRetail }</td>
					<td>${game.priceDigital}</td>
					<td>${game.releaseDate}</td>
					<td><a class="btn btn-primary"
						href="http://localhost:8080/game/update/${game.id}">Edit</a></td>
					<td><<a href="javascript:void(0);" onclick="deleteGame(${game.id})">Delete</a>
				</tr>
			</c:forEach>

		</tbody>



	</table>
	<div style="text-align: center">


		<a class="btn btn-primary" href="http://localhost:8080/game/insert">Insert</a>
	</div>
</body>
</html>