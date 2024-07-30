<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Genre</title>
</head>
<body>
	<h1>Lista di Genre</h1>
	<form action="/genre/insert">
		<button type="submit">Crea Genre</button>
	</form>
	<table>
	        <tr>
	            <th>Nome</th>
	        </tr>
	        <c:forEach var="genre" items="${genres}">
	            <tr>
	                <td>${genre.name}</td>
	                <td>
	                    <form action="/genre/edit/${genre.id}" method="POST">
	                            <button type="submit">Modifica</button>
	                    </form>
	                    <form action="/genre/delete/${genre.id}">
	                            <button type="submit">Elimina</button>
	                    </form>
	                </td>
	            </tr>
	        </c:forEach>
	</table>
</body>
</html>