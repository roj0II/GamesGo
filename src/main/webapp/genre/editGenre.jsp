<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    
     <div class="container mt-5">
        <h1 class="mb-4">Inserisci Ruolo</h1>
        <form action="http://localhost:8080/Gestionale/RuoloCtr"
        method="GET">

        <input type="hidden" name="tipoOperazione" value="inserisci">
        <div class="form-group">
            <label>Descrizione:</label>
              <input type="text" class="form-control" name="descrizione">
        </div>

        <button type="submit" class="btn btn-primary">Salva</button>
    </form>
    </div>
</body>
</html>