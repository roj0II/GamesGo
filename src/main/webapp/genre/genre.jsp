<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
<link rel="icon" type="image/x-icon" href="https://www.svgrepo.com/show/37992/male-and-female-symbol.svg">
<link rel="stylesheet" href="styleGenre.css">
<title>Genre</title>
</head>
<body>
	<div class="title-row">
		<h1><a class="icon" href="/admin">
	         <i class="fa-solid fa-arrow-left"></i>
	        </a>
				Lista di Genre
	        <a class="icon" href="/genre/insert">
	         <i class="fa-solid fa-circle-plus"></i>
	        </a>
	     </h1>
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
		          <a href="/genre/update/${genre.id}">Modifica</a>
		          <a href="/genre/delete/${genre.id}">Elimina</a>
		        </div>
		    </div>
		    </td>
		</tr>
	   </c:forEach>
        
      </tbody>
    </table>
  </div>
</div>