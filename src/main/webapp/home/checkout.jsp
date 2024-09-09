<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">

<link rel="icon" type="image/x-icon" href="${check.gamePhotoUrl}">
<title>${check.gameTitle}</title>

<!-- Bootstrap core CSS -->
<link href="../home/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Additional CSS Files -->
<link rel="stylesheet" href="../home/assets/css/fontawesome.css">
<link rel="stylesheet"
	href="../home/assets/css/templatemo-lugx-gaming.css">
<link rel="stylesheet" href="../home/assets/css/checkout.css">
<link rel="stylesheet" href="../home/assets/css/owl.css">
<link rel="stylesheet" href="../home/assets/css/animate.css">
<link rel="stylesheet" href="../home/assets/css/transact.css">
<link rel="stylesheet"
	href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />

	<style>
	#logout-btn {
		background-color: #474a51;
		margin-top: 10px;
		display: flex;
		justify-content: end;
		padding-left: 20px;
		padding-right: 20px;
		border-radius: 20px;
		font-weight: 300;
		font-size: 15px;
		height: 40px;
		line-height: 40px;
		text-transform: capitalize;
		color: #fff;
		-webkit-transition: all 0.4s ease 0s;
		-moz-transition: all 0.4s ease 0s;
		-o-transition: all 0.4s ease 0s;
		transition: all 0.4s ease 0s;
		border: transparent;
		letter-spacing: .25px;
	}
	</style>

</head>

<body>

	<!-- ***** Preloader Start ***** -->
	<div id="js-preloader" class="js-preloader">
		<div class="preloader-inner">
			<span class="dot"></span>
			<div class="dots">
				<span></span> <span></span> <span></span>
			</div>
		</div>
	</div>
	<!-- ***** Preloader End ***** -->

	<!-- ***** Header Area Start ***** -->
	<header class="header-area header-sticky">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<nav class="main-nav">
						<!-- ***** Logo Start ***** -->
						<a href="index.html" class="logo"> <img
							src="../home/assets/images/logo.png" alt="" style="width: 158px;">
						</a>
						<!-- ***** Logo End ***** -->
						<!-- ***** Menu Start ***** -->
						<ul class="nav">
	                      <li><a href="/">Home</a></li>
	                      <li><a href="/catalog" class="active">Catalogo</a></li>
	                      <li><a href="/contact">Contattaci</a></li>
	                      
	                      <c:if test="${loggedUser != null}">
	                      	<li><a style="cursor: pointer; text-decoration: underline; display: flex;" id="showFlag"><i style="padding-top: 12px;" class="fa-solid fa-user"></i>&nbsp;${loggedUser.username}</a>
	                      		<div style="display: none;" id="flag">
						        	<button id="logout-btn"><i style="padding-top: 12px;" class="fa-solid fa-right-from-bracket"></i>&nbsp;Logout</button>
						    	</div>
	                      	</li>
	                      	
	                      </c:if>
	                      <c:if test="${loggedUser == null}">
	                      	<li><a href="/login">Sign in</a></li>
	                      </c:if>
                      
                  </ul> 
						<a class='menu-trigger'> <span>Menu</span>
						</a>
						<!-- ***** Menu End ***** -->
					</nav>
				</div>
			</div>
		</div>
	</header>
	<!-- ***** Header Area End ***** -->

	<div class="page-heading header-text">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h3>${check.gameTitle}</h3>
				</div>
			</div>
		</div>
	</div>

	<div class="single-product section">
		<div class="container">
			<div class="row" style="height: 40rem;">
				<div class="col-lg-6">

					<img src="${check.gamePhotoUrl}" alt=""
						style="background-size: cover; border-radius: 25px; height: 100%;">
				</div>

				<f:form id="contact-form" modelAttribute="check" action="/final"
					method="post" class="col-lg-6 align-self-center"
					style="height: 100%; display: flex; flex-direction: column;">

					<div style="display: flex; justify-content: space-between;">
						<fieldset style="display: inline;">
							<f:input path="gameTitle" disabled="true"
								style="width: 320px; font-weight: bold;"/>
						</fieldset>
						<fieldset style="display:flex; margin:auto;">
						TOTALE:						
						</fieldset>
						<fieldset style="display: inline;">
							<c:if test="${check.rent}">
								<f:input path="gamePrice" id="gamePrice" value="€${check.gamePrice}" disabled="true" style="width: 180px; font-weight: bold;"/>
							</c:if>
							<c:if test="${!check.rent}">
								<f:input path="gamePrice" id="gamePrice" value="€${check.gamePrice}" disabled="true"
									style="width: 180px; font-weight: bold;"/>
							</c:if>
						</fieldset>
					</div>
					<div class="carousel">

						<c:if test="${check.rent}">
							<div class="slide active">
								<h2 style="margin-top: 20px;">Numero giorni del fitto</h2>

								<div style="display: flex; justify-content: space-between;">
									<fieldset style="display: inline;">
										<f:input type="number" id="rentDays" path="rentDays" value="1"
											style="margin-top: 40px; width: 180px; font-weight: bold;" onchange="daysChange()"/>
									</fieldset>
									<fieldset style="display: inline;">
										<input value="€${check.gamePrice}/giorno" id="pricePerDay" disabled
											style="margin-top: 40px; width: 180px; font-weight: bold;">
									</fieldset>
								</div>
								<div
									style="display: flex; justify-content: end; margin-top: 20px;">
									<a class="btn-next next-prev">Avanti</a>
								</div>
							</div>
						</c:if>


						<div class="slide <c:if test="${!check.rent}">active</c:if>">
							<div class="row">
								<h4 style="margin-left: 20px;">Informazioni di spedizione</h4>
								<div class="col-lg-6">
								    <span style="margin-left: 50px"><b>Nome</b></span>
								    <fieldset style="margin-bottom: 20px">
								        <f:input class="input-label" path="shippingName" required="true" style="width: 300px"/>
								    </fieldset>
								</div>
								<div class="col-lg-6" <c:if test="${check.online}">style="display:none;"</c:if>>
									<span style="margin-left: 50px"><b>Cognome</b></span>
									<fieldset>
									<f:input class="input-label" path="shippingSurname" required="true" style="width: 300px"/>
									</fieldset>
								</div>
								<div class="col-lg-6" >
									<span style="margin-left: 50px"><b>Email</b></span>
									<fieldset style="margin-bottom: 20px">
										<f:input type="email" path="shippingEmail" required="true" style="width: 400px"/>
									</fieldset>
								</div>
								<div class="col-lg-6">
									<span style="margin-left: 150px"><b>Telefono</b></span>
									<fieldset>
										<f:input type="text" path="shippingPhone"
											required="true"
											style="width: 200px; margin-left: 100px;"/>
									</fieldset>
								</div>
								<div class="col-lg-6" <c:if test="${check.online}">style="display:none;"</c:if>>
									<span style="margin-left: 50px"><b>Indirizzo</b></span>
									<fieldset>
										<f:input type="text" path="shippingAddress" required="true" style="width: 610px"/>
									</fieldset>
								</div>
								<div class="col-lg-6"></div>
								<div class="col-lg-6" style="margin-top:50px;" <c:if test="${check.online}">style="display:none;"</c:if>>
								    <label for="shippingMethod"><b>Spedizione</b></label>
									<fieldset style="margin-bottom: 20px">
									    <f:select path="shippingMethod" class="input-label" id="shippingMethod" style="margin-top: 10px;" onchange="deliveryChange()">
									        <f:option value="def" disabled="true" selected="true">Seleziona</f:option>
									        <f:option value="normale">Normale (€4)</f:option>
									        <f:option value="veloce">Veloce (€6)</f:option>
									        <f:option value="due_giorni">Due giorni (€12)</f:option>
									    </f:select>
									</fieldset>
								
								
								</div>
								<div class="col-lg-6" style="margin-top:30px;" <c:if test="${check.online}">style="display:none;"</c:if>>
								    <span><b>Note per il corriere</b></span>
								    <fieldset>
								        <f:textarea path="shippingNotes" required="false" style="width: auto; height: 100px;"></f:textarea>
								    </fieldset>
								</div>
							</div>
							<%
							String justif = "";
							%>
							<c:if test="${check.rent}">
								<%
								justif = "space-between";
								%>
							</c:if>
							<c:if test="${!check.rent}">
								<%
								justif = "end";
								%>
							</c:if>
							<div
								style="display: flex; justify-content: <%=justif%>; margin-top: 20px;">
								<c:if test="${check.rent}">
									<a class="btn-prev next-prev">Indietro</a>
								</c:if>
								<a class="btn-next next-prev">Avanti</a>
							</div>
						</div>


						<div class="slide">
							<div class="row">
								<h4 style="margin-left: 20px;">Informazioni di fatturazione</h4>
								<div class="col-lg-6">
									<span style="margin-left: 50px"><b>Nome</b></span>
									<fieldset style="margin-bottom: 20px">
										<f:input type="text" path="transactionName" required="true"
											style="width: 300px"/>
									</fieldset>
								</div>
								<div class="col-lg-6">
									<span style="margin-left: 50px"><b>Cognome</b></span>
									<fieldset>
										<f:input type="text" path="transactionSurname" required="true"
											style="width: 300px"/>
									</fieldset>
								</div>
								<div class="col-lg-6">
									<span style="margin-left: 50px"><b>Email</b></span>
									<fieldset style="margin-bottom: 20px">
										<f:input type="email" path="transactionEmail" required="true" style="width: 400px"/>
									</fieldset>
								</div>
								<div class="col-lg-6">
									<span style="margin-left: 150px"><b>Telefono</b></span>
									<fieldset>
										<f:input type="text" path="transactionPhone" required="true"
											style="width: 200px; margin-left: 100px;"/>
									</fieldset>
								</div>
								<div class="col-lg-6">
									<span style="margin-left: 50px"><b>Indirizzo</b></span>
									<fieldset>
										<f:input type="text" path="transactionAddress" required="true" style="width: 610px"/>
									</fieldset>
								</div>
							</div>
							<div
								style="display: flex; justify-content: space-between; margin-top: 20px;">
								<a class="btn-prev next-prev">Indietro</a> <a
									class="btn-next next-prev">Avanti</a>
							</div>
						</div>


						<div class="slide">

							<div id="carta"
								style="display: none; justify-content: center; align-items: center;">
								<h2
									style="margin-top: 20px; margin-bottom: 20px; align-items: end; display: flex;">Dettagli
									di Pagamento</h2>
								<div class="payment" style="display: grid;">

									<div class="card">

										<div class="card__visa">
											<svg class="visa" enable-background="new 0 0 291.764 291.764"
												version="1.1" viewBox="5 70 290 200" xml:space="preserve"
												xmlns="http://www.w3.org/2000/svg">
                <path class="svgcolor"
													d="m119.26 100.23l-14.643 91.122h23.405l14.634-91.122h-23.396zm70.598 37.118c-8.179-4.039-13.193-6.765-13.193-10.896 0.1-3.756 4.24-7.604 13.485-7.604 7.604-0.191 13.193 1.596 17.433 3.374l2.124 0.948 3.182-19.065c-4.623-1.787-11.953-3.756-21.007-3.756-23.113 0-39.388 12.017-39.489 29.204-0.191 12.683 11.652 19.721 20.515 23.943 9.054 4.331 12.136 7.139 12.136 10.987-0.1 5.908-7.321 8.634-14.059 8.634-9.336 0-14.351-1.404-21.964-4.696l-3.082-1.404-3.273 19.813c5.498 2.444 15.609 4.595 26.104 4.705 24.563 0 40.546-11.835 40.747-30.152 0.08-10.048-6.165-17.744-19.659-24.035zm83.034-36.836h-18.108c-5.58 0-9.82 1.605-12.236 7.331l-34.766 83.509h24.563l6.765-18.08h27.481l3.51 18.153h21.664l-18.873-90.913zm-26.97 54.514c0.474 0.046 9.428-29.514 9.428-29.514l7.13 29.514h-16.558zm-160.86-54.796l-22.931 61.909-2.498-12.209c-4.24-14.087-17.533-29.395-32.368-36.999l20.998 78.33h24.764l36.799-91.021h-24.764v-0.01z"
													fill="#FFFFFF"></path>
                <path class="svgtipcolor"
													d="m51.916 111.98c-1.787-6.948-7.486-11.634-15.226-11.734h-36.316l-0.374 1.686c28.329 6.984 52.107 28.474 59.821 48.688l-7.905-38.64z"
													fill="#FFFFFF"></path>
                </svg>
										</div>

										<div class="card__number">0000&nbsp;0000&nbsp;0000&nbsp;0000</div>
										<div class="card__name">
											<h3>Card Holder</h3>
											<p id="card-name">${check.userName} ${check.userSurname}</p>
										</div>

										<div class="card__expiry">
											<h3>Valid Thru</h3>
											<p>
												<span id="month">MM</span>/<span id="year">YY</span>
											</p>
										</div>
									</div>

									<div></div>

									<form class="form">

										<div class="form__name form__detail">
											<label for="name">Nome</label>
											<ion-icon name="person-outline" role="img"
												class="md hydrated" aria-label="person outline"></ion-icon>
											<f:input type="text" path="paymentNameAndSurname" id="name"
												maxlength="24" style="width: 400px"/>
										</div>

										<div class="form__expiry form__detail">
											<label for="date">Exp Date</label>
											<ion-icon name="calendar-outline" role="img"
												class="md hydrated" aria-label="calendar outline"></ion-icon>
											<f:input type="text" path="paymentCardExpiration" placeholder="MM/YY" id="date" onkeypress="return isNumeric(event)" style="width: 150px"/>

										</div>

										<div class="form__number form__detail">
											<label for="number">Card Number</label>
											<ion-icon name="card-outline" role="img" class="md hydrated"
												aria-label="card outline"></ion-icon>
											<f:input type="text" path="paymentCardCode" placeholder="0000 0000 0000 0000" id="number" onkeypress="return isNumeric(event)" style="width: 400px"/>
										</div>

										<div class="form__cvv form__detail">
											<label for="cvv">CVV <ion-icon
													name="information-circle" class="info md hydrated"
													role="img" aria-label="information circle"></ion-icon></label>
											<ion-icon name="lock-closed-outline" role="img"
												class="md hydrated" aria-label="lock closed outline"></ion-icon>
											<f:input type="password" placeholder="0000" path="paymentCvv" id="cvv"
												maxlength="4" onkeypress="return isNumeric(event)"
												style="width: 150px"/>

										</div>

										<div class="form__btn"
											style="display: flex; justify-content: space-between; margin-top: 20px;">
										</div>


									</form>
								</div>
							</div>
							
							<div style="display: none; margin:auto;" id="paypal">
								<a href="https://paypal.me/rojetti?country.x=IT&locale.x=it_IT" target="_blank" class="checkbox-button pp-btn">Premi quì per pagare con paypal <i class="fa-brands fa-paypal"></i>.</a>
								<div> Pagamenti sicuri al 100% <i class="fa-solid fa-shield-halved"></i></div>
							</div>
							
							<div></div>
							<div
								style="display: flex; justify-content: space-between; align-items: baseline;">
								<a class="btn-prev next-prev">Indietro</a> <label
									class="transaction-button" id="button3"
									style="margin-top: 5px;"> <input type="checkbox"
									name="transactionType" value="paypal"> <i
									class="fa fa-shopping-bag"></i> PayPal
								</label> <label class="transaction-button" id="button4"
									style="margin-top: 5px; margin-left: 40px;"> <input
									type="checkbox" name="transactionType" value="card"> <i
									class="fa-solid fa-handshake"></i> Carta
								</label> <button type="submit" id="concludi" class="next-prev out" onclick="submitForm()" disabled>Conferma</button>
							</div>
						</div>
					</div>
				</f:form>
			</div>
			<div class="col-lg-12">
				<div class="sep"></div>
			</div>

			<footer>
				<div class="container">
					<div class="col-lg-12">
						<p>Copyright © 2024 GamesGo Gaming Company. All rights
							reserved.</p>
					</div>
				</div>
			</footer>

			<!-- Scripts -->
			<!-- Bootstrap core JavaScript -->
			<script src="../home/vendor/jquery/jquery.min.js"></script>
			<script src="../home/vendor/bootstrap/js/bootstrap.min.js"></script>
			<script src="../home/assets/js/isotope.min.js"></script>
			<script src="../home/assets/js/owl-carousel.js"></script>
			<script src="../home/assets/js/counter.js"></script>
			<script src="../home/assets/js/custom.js"></script>
			<script src="/transact/transactScript.js"></script>


			<script>
			let basePrice = 0;
			let currentDeliveryPrice = 0;
			// Ormai non sò cosa sto facendo, aiutatemi
			document.addEventListener('DOMContentLoaded', () => {
	    const submitButton = document.getElementById('concludi');
	    const paypalLink = document.querySelector('.pp-btn');
	    const nameInput = document.getElementById('name');
	    const dateInput = document.getElementById('date');
	    const numberInput = document.getElementById('number');
	    const cvvInput = document.getElementById('cvv');
    

    // Function to enable the submit button
    function enableSubmitButton() {
        if (submitButton) {
            submitButton.classList.remove('out');

            submitButton.disabled = false;
        }
    }

    // Function to check if all card fields are filled
    function checkCardFields() {
        if (nameInput && dateInput && numberInput && cvvInput) {
            if (nameInput.value.trim() !== '' &&
                dateInput.value.trim() !== '' &&
                numberInput.value.trim() !== '' &&
                cvvInput.value.trim() !== '') {
                enableSubmitButton();
            }
        }
    }

    // Add event listener to the PayPal link
    if (paypalLink) {
        paypalLink.addEventListener('click', (event) => {
            // Prevent the link from navigating immediately
            event.preventDefault();
            enableSubmitButton();
            // Optionally, navigate to the PayPal link
            window.open(paypalLink.href, '_blank');
        });
    }

    // Add input event listeners to the card fields
    if (nameInput) nameInput.addEventListener('input', checkCardFields);
    if (dateInput) dateInput.addEventListener('input', checkCardFields);
    if (numberInput) numberInput.addEventListener('input', checkCardFields);
    if (cvvInput) cvvInput.addEventListener('input', checkCardFields);
});
			
			// Funzione per aggiornare il contenuto della carta
			  function updateCard() {
			    // Otteniamo i valori dai campi di input
			    const cardName = document.getElementById('name').value;
			    const cardDate = document.getElementById('date').value;
			    const cardNumber = document.getElementById('number').value;
			    const cardCvv = document.getElementById('cvv').value;

			    // Aggiorniamo il contenuto della card
			    document.getElementById('card-name').textContent = cardName;
			    document.getElementById('month').textContent = cardDate.split('/')[0] || 'MM';
			    document.getElementById('year').textContent = cardDate.split('/')[1] || 'YY';
			    document.querySelector('.card__number').textContent = cardNumber || '0000 0000 0000 0000';
			  }

			  // Aggiungiamo gli eventi agli input
			  document.getElementById('name').addEventListener('input', updateCard);
			  document.getElementById('date').addEventListener('input', updateCard);
			  document.getElementById('number').addEventListener('input', updateCard);
			  document.getElementById('cvv').addEventListener('input', updateCard);
			  
				document.addEventListener('DOMContentLoaded', () => {
			        const paypalCheckbox = document.querySelector('input[value="paypal"]');
			        const cardCheckbox = document.querySelector('input[value="card"]');
			        const paypalDiv = document.getElementById('paypal');
			        const cardDiv = document.getElementById('carta');

			        function updateDisplay() {
			            if (paypalCheckbox.checked) {
			                paypalDiv.style.display = 'block';
			                cardDiv.style.display = 'none';
			            } else if (cardCheckbox.checked) {
			                cardDiv.style.display = 'block';
			                paypalDiv.style.display = 'none';
			            } else {
			                paypalDiv.style.display = 'none';
			                cardDiv.style.display = 'none';
			            }
			        }

			        // Aggiungi l'evento change ai checkbox
			        paypalCheckbox.addEventListener('change', updateDisplay);
			        cardCheckbox.addEventListener('change', updateDisplay);
			    });
				
				fetch('/transact/transact.jsp')
			    .then(response => response.text())
			    .then(data => {
			      const shadowRoot = document.getElementById('cartacredito').attachShadow({mode: 'open'});
			      shadowRoot.innerHTML = data;
			    });
				
  document.addEventListener('DOMContentLoaded', () => {
	    const slides = document.querySelectorAll('.slide');
	    let currentSlide = 0;

	    function showSlide(index) {
	        slides.forEach((slide, i) => {
	            slide.classList.toggle('active', i === index);
	        });
	    }

	    document.querySelectorAll('.btn-next').forEach(button => {
	        button.addEventListener('click', () => {
	            currentSlide = (currentSlide + 1) % slides.length;
	            showSlide(currentSlide);
	        });
	    });

	    document.querySelectorAll('.btn-prev').forEach(button => {
	        button.addEventListener('click', () => {
	            currentSlide = (currentSlide - 1 + slides.length) % slides.length;
	            showSlide(currentSlide);
	        });
	    });

	    showSlide(currentSlide);
	});
  
    document.querySelectorAll('.transaction-button input').forEach((checkbox) => {
        checkbox.addEventListener('change', () => {
            if (checkbox.checked) {
                document.querySelectorAll('.transaction-button input').forEach((otherCheckbox) => {
                    if (otherCheckbox !== checkbox) {
                        otherCheckbox.checked = false;
                        otherCheckbox.parentElement.classList.remove('active');
                    }
                });
            }
            checkbox.parentElement.classList.toggle('active', checkbox.checked);
        });
    });

    document.getElementById('submit').addEventListener('click', (event) => {
        const transactionChecked = Array.from(document.querySelectorAll('.transaction-button input')).some(checkbox => checkbox.checked);
		
        if (!transactionChecked ) {
        	event.preventDefault();
        	alert('Per favore, seleziona un metodo di pagamento.');
        }
    });

	//login/logout
	  document.getElementById('showFlag').addEventListener('click', function(event) {
	      var flag = document.getElementById('flag');
	      if (flag.style.display === 'none' || flag.style.display === '') {
	          flag.style.display = 'block';
	      } else {
	          flag.style.display = 'none';
	      }
	      
	      event.stopPropagation();
	  });
	
	  document.addEventListener('click', function() {
	      var flag = document.getElementById('flag');
	      if (flag.style.display === 'block') {
	          flag.style.display = 'none';
	      }
	  });
	
	  document.getElementById('logout-btn').addEventListener('click', function() {
	      window.location.href = '/logout';
	  });
	
	  document.getElementById('flag').addEventListener('click', function(event) {
	      event.stopPropagation();
	  });
	  
	  function daysChange() {
		    const rentDaysInput = document.getElementById('rentDays');
		    const gamePriceInput = document.getElementById('gamePrice');
		    const pricePerDayInput = document.getElementById('pricePerDay');
		    const shippingMethodSelect = document.getElementById('shippingMethod');
		    
		    shippingMethodSelect.value = 'def';
		    
		    const rentDays = parseInt(rentDaysInput.value, 10);
		    let pricePerDay = parseFloat(pricePerDayInput.value.replace('€', '').replace('/giorno', '').trim());
		    basePrice = 0;
		    
		    if (isNaN(rentDays) || rentDays < 1) {
		        alert('Inserisci un numero di giorni valido.');
		        rentDaysInput.value = 1;
		        gamePriceInput.value = '€0.00';
		        return;
		    }
		    
		    const gamePrice = parseFloat(rentDays * (pricePerDay));
		    gamePriceInput.value = '€' + gamePrice.toFixed(2);
		}

	  function deliveryChange() {
	      const shippingMethodSelect = document.getElementById('shippingMethod');
	      const gamePriceInput = document.getElementById('gamePrice');
	      const selectedValue = shippingMethodSelect.value;
	      
	      if (basePrice === 0) {
	          basePrice = parseFloat(gamePriceInput.value.replace('€', '').trim());
	      }

	      let priceDelivery;
	      
	      switch (selectedValue) {
	          case 'normale':
	              priceDelivery = 4;
	              break;
	          case 'veloce':
	              priceDelivery = 6;
	              break;
	          case 'due_giorni':
	              priceDelivery = 12;
	              break;
	          default:
	              alert('Seleziona una spedizione.');
	              return;
	      }
	      
	      const gamePrice = basePrice + priceDelivery;
	      
	      gamePriceInput.value = '€' + gamePrice.toFixed(2);

	      currentDeliveryPrice = priceDelivery;
	  }
	  
		function submitForm() {
			var form = document.getElementById('contact-form');
			form.submit();
		}
</script>
</body>
</html>