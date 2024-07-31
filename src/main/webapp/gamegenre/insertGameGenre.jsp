<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Game Genre</title>
</head>
<body>
	<h1 class="mb-4">Inserisci gioco e genere</h1>
	<f:form modelAttribute="gameGenreForm" method="POST"
		action="/gamegenre/insert">
		<div class="form-group">
			<f:label path="idGame">ID Gioco:</f:label>
			<f:input path="idGame" />
			<f:label path="idGenre">ID Genere:</f:label>
			<f:input path="idGenre" />
		</div>

		<button type="submit">Salva</button>
	</f:form>
</body>
</html>