<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edit Transaction</title>
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
	--main-color: #FFB366;
}
</style>
</head>
<body>
	<div class="container">
		<div class="header-buttons">
			<a href="/transaction/" class="btn btn-primary"><i
				class="fas fa-arrow-left"></i> Indietro</a>
			<div class="icons">
				<i class="fa-solid fa-credit-card fa-2xl"></i>
			</div>
			<h1 class="header-title">Modifica Transazione</h1>
			<a href="/admin" class="btn btn-success"><i class="fas fa-home"></i>
				Home</a>
		</div>

		<f:form modelAttribute="transactionForm" method="POST" action="/transaction/update">
			<f:input path="id" type="hidden"/>
			<table class="table table-striped">
			<thead>
	            <tr>
	                <td>User</td>
	                <td>
	                    <f:input path="idUser" id="userInput" class="input-label" list="userList" name="idUser" />
	                    <datalist id="userList">
	                        <c:forEach items="${users}" var="user">
	                            <option value="${user.id}">${user.username}</option>
	                        </c:forEach>
	                    </datalist>
	                </td>
	            </tr>
	            <tr>
	                <td>Game</td>
					<td>
	                    <f:input path="idGame" id="gameInput" class="input-label" list="gameList" name="idGame" />
	                    <datalist id="gameList">
	                        <c:forEach items="${games}" var="game">
	                            <option value="${game.id}">${game.title}</option>
	                        </c:forEach>
	                    </datalist>
	                </td>
	            </tr>
	            	<tr>
						<td>Total</td>
						<td><f:input class="input-label" path="checkoutPayment" /></td>
					</tr>
	        </thead>
			</table>
			<button type="submit" class="buttons">Salva</button>
		</f:form>
	</div>

	<jsp:include page="../fragments/popup.jsp" />

	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script>
        document.querySelector("form").addEventListener("submit", function(event) {
            const gameInput = document.getElementById("gameInput").value;
            const userInput = document.getElementById("userInput").value;
            
            const games = Array.from(document.querySelectorAll("#gameList option")).map(option => option.value);
            const users = Array.from(document.querySelectorAll("#userList option")).map(option => option.value);
            
            if (!games.includes(gameInput)) {
                alert("Il gioco inserito non è valido.");
                event.preventDefault();
            }
            
            if (!users.includes(userInput)) {
                alert("L'utente inserito non è valido.");
                event.preventDefault();
            }
        });
    </script>
</body>
</html>