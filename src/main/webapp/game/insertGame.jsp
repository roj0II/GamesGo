<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert game page</title>
<!-- Web Icon -->
<link rel="icon" type="image/x-icon" href="https://www.svgrepo.com/show/37992/male-and-female-symbol.svg">
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
	--main-color: #66FF66;
}
</style>
</head>
<body>
	<div class="container">
		<div class="header-buttons">
			<a href="/game/" class="btn btn-primary"><i
				class="fas fa-arrow-left"></i> Indietro</a>
			<div class="icons">
				<i class="fa-solid fa-gamepad fa-2xl"></i>
			</div>
			<h1 class="header-title">Inserisci Gioco</h1>
			<a href="/admin" class="btn btn-success"><i class="fas fa-home"></i>
				Home</a>
		</div>
		<h1>Insert Game</h1>
		<f:form modelAttribute="gameForm" action="/game/insert" method="post">
			<table class="table table-striped">
			<thead>
			<tr>
			<td>Title</td>
			<td><f:input class="input-label" path="title" /></td>
			</tr>
			<tr>
			<td>Author</td><br>
			<td><f:input class="input-label" path="author" /></td><br>
			</tr>
			<tr>
			<td>Release Date</td>
			<td><f:input class="input-label" type="date" path="releaseDate" /></td>
			</tr>
			<tr>
			<td>Description</td>
			<td><f:input class="input-label" path="description" /></td>
			</tr>
			<tr>
			<td>Photo url</td>
			<td><f:input class="input-label" path="photoUrl" /></td>
			</tr>
			<tr>
			<td>Price Retail</td>
			<td><f:input class="input-label" path="priceRetail" /></td>
			</tr>
			<tr>
			<td>Price digital</td>
			<td><f:input class="input-label" path="priceDigital" /></td>
			</tr>
			
			</thead>
			</table>
			<button class="buttons" type="submit" >Salva</button>
			
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