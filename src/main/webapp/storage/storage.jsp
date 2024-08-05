<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Storage</title>
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
			<a href="/admin" class="btn btn-primary"><i
				class="fas fa-arrow-left"></i> Indietro</a>
			<div class="icons">
				<i class="fa-solid fa-box-open fa-2xl"></i>
			</div>
			<h1 class="header-title">Magazzino</h1>
			<a href="/storage/insert" class="btn btn-success"><i
				class="fas fa-plus"></i> Aggiungi</a>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID Gioco</th>
					<th>Digitale</th>
					<th>Retail</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="storage" items="${storage}">
					<!-- da sistemare -->
					<tr>
						<td>${storage.game.id}</td>
						<td>${storage.amountDigital}</td>
						<td>${storage.amountRetail}</td>
						<td class="table-actions"><a
							href="/storage/update/${storage.id}"
							class="btn btn-warning btn-sm"> <i class="fas fa-edit"></i>
								Modifica
						</a> <a href="/storage/delete/${storage.id}"
							class="btn btn-danger btn-sm" onclick="confirmDelete(event)">
								<i class="fas fa-trash"></i> Elimina
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script>
		function confirmDelete(event) {
			event.preventDefault();
			if (confirm("Sei sicuro di voler eliminare questo elemento?")) {
				window.location.href = event.target.href;
			}
		}
	</script>
</body>
</html>