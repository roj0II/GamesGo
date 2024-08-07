<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="it">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/popup.css">
	<link rel="stylesheet" href="login/loginStyle.css">
	<link rel="icon" type="image/x-icon" href="https://icons.veryicon.com/png/o/miscellaneous/esgcc-basic-icon-library/1-login.png">
	<title>Login e Registrazione</title>
	
</head>

<body>
	<div class="container ${registerForm}">
		<div class="form-container sign-up-container">
			<form action="/register" method="POST">
				<h1>Crea Account</h1>
        		<input type="email" class="form-control" name="email" placeholder="Email" required>
			    <input type="text" class="form-control" name="username" placeholder="Nome Utente" required>
        		<input type="text" class="form-control" name="name" placeholder="Nome" required>
			    <input type="text" class="form-control" name="surname" placeholder="Cognome" required>
		        <input type="text" class="form-control" name="address" placeholder="Indirizzo completo" required>
		        <input type="text" class="form-control" name="phoneNumber" placeholder="Numero di telefono" required>
				<input type="password" class="form-control" name="password" placeholder="Password" required/>
				<input type="password" class="form-control" name="confermaPassword" placeholder="Conferma Password" required/>
				<button type="submit" value="Registrati">Registrati</button>
			</form>
			
    
		</div>
		<div class="form-container sign-in-container">
			<form class="${accediForm}" action="/login" method="POST">
				<h1>Accedi</h1>
				<input type="text" placeholder="Nome utente" name="username" id="username" oninput="validateInput()"/>
				<input type="password" placeholder="Password" name="password"/>
				<div class="buttons-container">
                    <button type="submit" id=submitButton>Accedi</button>
                </div>
			</form>
			
			<form class="${otpForm}" action="/logAdmin">
				<h1>Verifica Otp</h1>
				<input type="text" placeholder="Codice Otp" name="otp" id="otp"/>
				<div class="buttons-container">
                    <button type="submit">Verifica</button>
                </div>
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>Sei già dei nostri?</h1>
					<p>Bentornato, accedi al tuo account.</p>
					<button class="ghost" id="signIn">Accedi</button>
				</div>
				<div class="overlay-panel overlay-right">
					<h1>Sei nuovo da queste parti?</h1>
					<p>Crea un account gratuitamente.</p>
					<button class="ghost" id="signUp">Registrati</button>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${error}">
        <div class="popup-item show">
            <div class="popup ${color}">
                <label class="close"></label>
                <h3>${title}</h3>
                <p>${message}</p>
            </div>
        </div>
    </c:if>
	<script src="login/loginScript.js"></script>
	<script src="javascript/popup.js"></script>
</body>

</html>