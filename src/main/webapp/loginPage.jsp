<!DOCTYPE html>
<html lang="it">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Login e Registrazione</title>
	<link rel="stylesheet" href="loginStyle.css">
</head>

<body>
	<div class="container">
		<div class="form-container sign-up-container">
			<form action="/register" method="POST">
				<h1>Crea Account</h1>
        		<input type="email" class="form-control" name="email" placeholder="Email" required>
			    <input type="text" class="form-control" name="username" placeholder="Nome Utente" required>
        		<input type="text" class="form-control" name="name" placeholder="Nome" required>
			    <input type="text" class="form-control" name="surname" placeholder="Cognome" required>
		        <input type="text" class="form-control" name="address" placeholder="Indirizzo completo" required>
		        <input type="text" class="form-control" name="phoneNumber" placeholder="Numero di telefono" required>
				<input type="password" type="password" class="form-control" name="password" placeholder="Password" required/>
				<input type="password" type="password" class="form-control" name="password" placeholder="Conferma Password" required/>
				<button type="submit" value="Registrati"></button>
			</form>
			
    
    
		</div>
		<div class="form-container sign-in-container">
			<form action="#">
				<h1>Accedi</h1>
				<input type="text" placeholder="Nome utente" name="username" id="username" oninput="validateInput()"/>
				<input type="password" placeholder="Password" name="password"/>
				<div class="buttons-container">
                    <button type="button" id=submitButton>Accedi</button>
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
	<script src="loginScript.js"></script>
</body>

</html>