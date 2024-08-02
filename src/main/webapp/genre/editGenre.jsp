<!--
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifica Genere</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h1 class="mb-4">Modifica Genre</h1>
    <f:form modelAttribute="genreForm" method="POST" action="/genre/update">
        <div class="form-group">
        	<f:input path="id" type="hidden"/>
            <f:label path="name">Nome:</f:label>
            <f:input path="name"/>
        </div>
        
        <button type="submit">Salva</button>
    </f:form>
</body>
</html>
  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Genre</title>
    <!-- Web Icon -->
    <link rel="icon" type="image/x-icon" href="https://www.svgrepo.com/show/37992/male-and-female-symbol.svg">
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" rel="stylesheet">
    <!-- Our CSS -->
    <link href="../admin/styleEntity.css" rel="stylesheet">
    <style>
    	:root {
    		--main-color: #66FFFF;
    	}
    </style>
</head>
<body>
    <div class="container">
        <div class="header-buttons">
            <a href="/admin" class="btn btn-primary"><i class="fas fa-arrow-left"></i> Indietro</a>
            <div class="icons">
	            <i class="fa-solid fa-mars-and-venus fa-2xl"></i>
	         </div>   
	            <h1 class="header-title">Modifica Genre</h1> 
            <a href="../admin" class="btn btn-success"><i class="fas fa-plus"></i> Home</a>
        </div>
        <table class="table table-striped">
        <form modelAttribute="genreForm" method="POST" action="/genre/update">
        <input id="id" type="hidden"/>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
				<tr>
					<td><input id="name"/></td>
					<td class="table-actions">
	                        <button type="submit">Salva</button>
	                </td>
				</tr>
            </tbody>
           </form>
        </table>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>