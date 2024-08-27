<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Rent</title>
<!-- Web Icon -->
<link rel="icon" type="image/x-icon"
	href="https://www.svgrepo.com/show/37992/male-and-female-symbol.svg">
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
	--main-color: #FFFF66;
}
</style>
</head>
<body>
	<div class="container">
		<div class="header-buttons">
			<a href="/rent/" class="btn btn-primary"><i
				class="fas fa-arrow-left"></i> Indietro</a>
			<div class="icons">
				<i class="fa-solid fa-handshake fa-2x"></i>
			</div>
			<h1 class="header-title">Modifica noleggi</h1>
			<a href="/admin" class="btn btn-success"><i class="fas fa-home"></i>
				Home</a>
		</div>
		<h1>Modifica Rent</h1>
		<f:form modelAttribute="rentForm" action="/rent/update" method="post">
		<f:input path="id" type="hidden"/>
			<table class="table table-striped">
				<thead>
					<tr>
						<td>Start Date<f:input path="id" type="hidden" /></td>
						<td><f:input class="input-label" type="date" path="startDate" /></td>
					</tr>
					<tr>
						<td>End date</td>
						<td><f:input class="input-label" type="date" path="endDate" /></td>
					</tr>
					<tr>
						<td>Product key</td>
						<td><f:input class="input-label" path="productKey" /></td>
					</tr>
					<tr>
						<td>Type</td>
						<td><f:input class="input-label" path="type" /></td>
					</tr>
					<tr>
	                <td>Transaction</td>
					<td>
	                    <f:input path="transaction.id" id="transInput" class="input-label" list="transList" name="transaction.id" />
	                    <datalist id="transList">
	                        <c:forEach items="${trans}" var="tran">
	                            <option value="${tran.id}"></option>
	                        </c:forEach>
	                    </datalist>
	                </td>
	            	</tr>
				</thead>
			</table>
			<button type="submit" class="buttons">Salva</button>
		</f:form>
	</div>
	<jsp:include page="../fragments/popup.jsp" />
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        document.querySelector("form").addEventListener("submit", function(event) {
            const transInput = document.getElementById("transInput").value;
            
            const trans = Array.from(document.querySelectorAll("#transList option")).map(option => option.value);
            
            if (!trans.includes(transInput)) {
                alert("La transazione inserita non è valida.");
                event.preventDefault();
            }
        });
    </script>
</body>
</html>