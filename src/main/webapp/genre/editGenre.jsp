<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Genre</title>
</head>
<body>
	<h1 class="mb-4">Modifica Genre</h1>
    <f:form modelAttribute="genreForm" method="PUT" action="/genre/update">
        <div class="form-group">
        	<f:input path="id" type="hidden"/>
            <f:label path="name">Nome:</f:label>
            <f:input path="name"/>
        </div>
        
        <button type="submit">Salva</button>
    </f:form>
</body>
</html>