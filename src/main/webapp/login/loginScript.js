// Login Script
const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.querySelector('.container');

signUpButton.addEventListener('click', () => {
	container.classList.add('right-panel-active');
});

signInButton.addEventListener('click', () => {
	container.classList.remove('right-panel-active');
});

function validateInput() {
	var inputField = document.getElementById("username");
	var submitButton = document.getElementById("submitButton");
	var inputValue = inputField.value;

	var targetWord = "admin_";

	if (inputValue.toLowerCase().includes(targetWord)) {
		submitButton.innerHTML = "Accedi Admin";
		submitButton.onclick = function() { window.location.href = 'admin.jsp'; };
	} else {
		submitButton.innerHTML = "Accedi Utente";
		submitButton.onclick = function() { window.location.href = 'user.jsp'; };
	}
}