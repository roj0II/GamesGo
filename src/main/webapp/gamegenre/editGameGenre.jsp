<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Game Genre</title>
</head>
<body>
<h1 class="mb-4">Modifica genere o gioco</h1>
    <f:form modelAttribute="gameGenreForm" method="POST" action="/gamegenre/update">
        <div class="form-group">
        	<f:input path="id" type="hidden"/>
            <f:label path="idGame">ID Gioco:</f:label>
            <f:input path="idGame"/>
            <f:label path="idGenre">ID Genere:</f:label>
            <f:input path="idGenre"/>
        </div>
        
        <button type="submit">Salva</button>
    </f:form>
</body>
</html>