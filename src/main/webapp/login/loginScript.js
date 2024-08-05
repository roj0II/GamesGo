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
		document.documentElement.style.setProperty('--button-color', '#000000');
//		document.documentElement.style.setProperty('--right-panel-color', '#000000');
		document.documentElement.style.setProperty('--left-panel-color', '#000000');
		submitButton.innerHTML = "Accedi Admin";
		//submitButton.onclick = function() { window.location.href = 'logAdmin'; };
	} else {
		document.documentElement.style.setProperty('--button-color', '#0171F9');
		document.documentElement.style.setProperty('--right-panel-color', '#0171F9');
		document.documentElement.style.setProperty('--left-panel-color', '#0D90F8');
		submitButton.innerHTML = "Accedi";
		//submitButton.onclick = function() { window.location.href = 'logUser'; };
	}
}