<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="https://www.svgrepo.com/show/37992/male-and-female-symbol.svg">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="styleGenre.css">
<title>Genere</title>
</head>
<body>
	 <div class="title-row">
            <a href="/admin" class="btn btn-primary"><i class="fas fa-arrow-left"></i> Indietro</a>
            <h1>Lista di Generi</h1>
            <a href="/genre/insert" class="btn btn-success"><i class="fas fa-plus"></i> Aggiungi</a>
        </div>
	 
	 <div class="container">
  <div class="table__container">
    <table>
      <thead>
        <tr>
          <th>Name</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach var="genre" items="${genres}">
		<tr>
			<td>${genre.name}</td>
			<td><div class="button-box">
				  <div class="buttons">
		          <a href="/genre/update/${genre.id}">
		          <i class="fas fa-edit"></i>Modifica</a>
		          <a href="/genre/delete/${genre.id}">
		          <i class="fas fa-trash"></i>Elimina</a>
		        </div>
		    </div>
		    </td>
		</tr>
	   </c:forEach>
      </tbody>
    </table>
  </div>
</div>
	<h1>Lista di Generi</h1>
	<form action="/genre/insert">
		<button type="submit">Crea Genere</button>
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
