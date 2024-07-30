<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert game page</title>
</head>
<body>
<h1>Insert Game</h1>
<f:form modelAttribute="gameForm" action="/game/insert" method="post">
<f:label path="title">Title</f:label>
<f:input path="title"/>
<f:label path="author">Author</f:label>
<f:input path="author"/>
<f:label path="releaseDate">Release date</f:label>
<f:input path="releaseDate"/>
<f:label path="description">Description</f:label>
<f:input path="description"/>
<f:label path="photoUrl">Photo url</f:label>
<f:input path="photoUrl"/>
<f:label path="priceRetail">Price retail</f:label>
<f:input path="priceRetail"/>
<f:label path="priceDigital">Price digital</f:label>
<f:input path="priceDigital"/>
<input type="submit" value="Insert" />
</f:form>
</body>
</html>