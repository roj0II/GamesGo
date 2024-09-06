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
							<li><a href="/catalog">Our Shop</a></li>
							<li><a href="contact.html">Contact Us</a></li>
							<li><a href="/login">Sign In</a></li>
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
			<div class="row">
				<div class="col-lg-6">
					<div class="left-image">
                        <img src="${check.gamePhotoUrl}" alt="" style="margin-top: 30px;">
                    </div>
                </div>

                <f:form id="contact-form" modelAttribute="check" action="/?"
                    method="post" class="col-lg-6 align-self-center">
					<div class="carousel">


						<c:if test="${check.rent}">
							<div class="slide active">
								<h2>Slide Rent</h2>
								<p>Contenuto per la prima slide.</p>
								<div style="display: flex; justify-content: end; margin-top: 20px;">
                                	<a class="btn-next next-prev">Avanti</a>
                            	</div>
							</div>
						</c:if>


						<div class="slide <c:if test="${!check.rent}">active</c:if>">
							<div class="row">
								<h4 style="margin-left: 20px;">Informazioni di spedizione e
									fatturazione</h4>
								<div class="col-lg-6">
									<span style="margin-left: 50px"><b>Nome</b></span>
									<fieldset style="margin-bottom: 20px">
										<input type="text" name="userName" id="userName"
											value="${check.userName}" autocomplete="on" required
											style="width: 300px">
									</fieldset>
								</div>
								<div class="col-lg-6">
									<span style="margin-left: 50px"><b>Cognome</b></span>
									<fieldset>
										<input type="text" name="userSurname" id="userSurname"
											value="${check.userSurname}" autocomplete="on" required
											style="width: 300px">
									</fieldset>
								</div>
								<div class="col-lg-6">
									<span style="margin-left: 50px"><b>Email</b></span>
									<fieldset style="margin-bottom: 20px">
										<input type="text" name="userEmail" id="userEmail"
											pattern="[^ @]*@[^ @]*" value="${check.userEmail}"
											autocomplete="on" required style="width: 400px">
									</fieldset>
								</div>
								<div class="col-lg-6">
									<span style="margin-left: 150px"><b>Telefono</b></span>
									<fieldset>
										<input type="text" name="userPhone" id="userPhone"
											value="${check.userPhone}" autocomplete="on" required
											style="width: 200px; margin-left: 100px;">
									</fieldset>
								</div>
								<div class="col-lg-6">
									<span style="margin-left: 50px"><b>Indirizzo</b></span>
									<fieldset>
										<input type="text" name="userAddress" id="userAddress"
											value="${check.userAddress}" required style="width: 630px">
									</fieldset>
								</div>
							</div>
							<% String justif = ""; %>
                            <c:if test="${check.rent}"><% justif = "space-between"; %></c:if>
                            <c:if test="${!check.rent}"><% justif = "end"; %></c:if>
                            <div style="display: flex; justify-content: <%= justif%>; margin-top: 20px;">
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
										<input type="text" name="userName" id="userName"
											value="${check.userName}" autocomplete="on" required
											style="width: 300px">
									</fieldset>
								</div>
								<div class="col-lg-6">
									<span style="margin-left: 50px"><b>Cognome</b></span>
									<fieldset>
										<input type="text" name="userSurname" id="userSurname"
											value="${check.userSurname}" autocomplete="on" required
											style="width: 300px">
									</fieldset>
								</div>
								<div class="col-lg-6">
									<span style="margin-left: 50px"><b>Email</b></span>
									<fieldset style="margin-bottom: 20px">
										<input type="text" name="userEmail" id="userEmail"
											pattern="[^ @]*@[^ @]*" value="${check.userEmail}"
											autocomplete="on" required style="width: 400px">
									</fieldset>
								</div>
								<div class="col-lg-6">
									<span style="margin-left: 150px"><b>Telefono</b></span>
									<fieldset>
										<input type="text" name="userPhone" id="userPhone"
											value="${check.userPhone}" autocomplete="on" required
											style="width: 200px; margin-left: 100px;">
									</fieldset>
								</div>
								<div class="col-lg-6">
									<span style="margin-left: 50px"><b>Indirizzo</b></span>
									<fieldset>
										<input type="text" name="userAddress" id="userAddress"
											value="${check.userAddress}" required style="width: 630px">
									</fieldset>
								</div>
                                <div style="display: flex; justify-content: space-between; margin-top: 20px;">
	                                <a class="btn-prev next-prev">Indietro</a>
	                                <a class="btn-next next-prev">Avanti</a>
                            	</div>
                           	</div>
                        </div>


						<div class="slide">
							<div style="align-items: center;">
								<label class="transaction-button" id="button3"
									style="margin-top: 5px;"> <input type="checkbox"
									name="transactionType" value="paypal"> <i
									class="fa fa-shopping-bag"></i> PayPal
								</label> <label class="transaction-button" id="button4"
									style="margin-top: 5px; margin-left: 40px;"> <input
									type="checkbox" name="transactionType" value="card"> <i
									class="fa-solid fa-handshake"></i> Carta
								</label>
							</div>
							<div id="carta"
								style="display: none; justify-content: center; align-items: center;">
								<h2>Payment Details</h2>
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
											<p id="card-name">Mrs Kate Smith</p>
										</div>

										<div class="card__expiry">
											<h3>Valid Thru</h3>
											<p>
												<span id="month">MM</span>/<span id="year">YY</span>
											</p>
										</div>
									</div>
									<form class="form">

										<div class="form__name form__detail">
											<label for="name">Nome</label>
											<ion-icon name="person-outline" role="img"
												class="md hydrated" aria-label="person outline"></ion-icon>
											<input type="text" placeholder="Mrs Kate Smith" id="name"
												maxlength="24">
											<div class="alert" id="alert-1">
												<svg width="12" height="12" viewBox="0 0 12 12" fill="none"
													xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd" clip-rule="evenodd"
														d="M11.3163 9.00362C11.8593 10.0175 11.1335 11.25 9.99343 11.25H2.00657C0.866539 11.25 0.140732 10.0175 0.683711 9.00362L4.67714 1.54691C5.24618 0.484362 6.75381 0.484362 7.32286 1.54691L11.3163 9.00362ZM5.06238 4.49805C5.02858 3.95721 5.4581 3.5 6 3.5C6.5419 3.5 6.97142 3.95721 6.93762 4.49805L6.79678 6.75146C6.77049 7.17221 6.42157 7.5 6 7.5C5.57843 7.5 5.22951 7.17221 5.20322 6.75146L5.06238 4.49805ZM6 8C5.44772 8 5 8.44772 5 9C5 9.55229 5.44772 10 6 10C6.55228 10 7 9.55229 7 9C7 8.44772 6.55228 8 6 8Z"
														fill="#FF6A96"></path>
                </svg>
												Full name required
											</div>
										</div>

										<div class="form__number form__detail">
											<label for="number">Card Number</label>
											<ion-icon name="card-outline" role="img" class="md hydrated"
												aria-label="card outline"></ion-icon>
											<input type="text" placeholder="0000 0000 0000 0000"
												id="number" onkeypress="return isNumeric(event)">
											<div class="alert" id="alert-2">
												<svg width="12" height="12" viewBox="0 0 12 12" fill="none"
													xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd" clip-rule="evenodd"
														d="M11.3163 9.00362C11.8593 10.0175 11.1335 11.25 9.99343 11.25H2.00657C0.866539 11.25 0.140732 10.0175 0.683711 9.00362L4.67714 1.54691C5.24618 0.484362 6.75381 0.484362 7.32286 1.54691L11.3163 9.00362ZM5.06238 4.49805C5.02858 3.95721 5.4581 3.5 6 3.5C6.5419 3.5 6.97142 3.95721 6.93762 4.49805L6.79678 6.75146C6.77049 7.17221 6.42157 7.5 6 7.5C5.57843 7.5 5.22951 7.17221 5.20322 6.75146L5.06238 4.49805ZM6 8C5.44772 8 5 8.44772 5 9C5 9.55229 5.44772 10 6 10C6.55228 10 7 9.55229 7 9C7 8.44772 6.55228 8 6 8Z"
														fill="#FF6A96"></path>
                </svg>
												Invalid card number
											</div>
										</div>

										<div class="form__expiry form__detail">
											<label for="date">Exp Date</label>
											<ion-icon name="calendar-outline" role="img"
												class="md hydrated" aria-label="calendar outline"></ion-icon>
											<input type="text" placeholder="MM/YY" id="date"
												onkeypress="return isNumeric(event)">
											<div class="alert" id="alert-3">
												<svg width="12" height="12" viewBox="0 0 12 12" fill="none"
													xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd" clip-rule="evenodd"
														d="M11.3163 9.00362C11.8593 10.0175 11.1335 11.25 9.99343 11.25H2.00657C0.866539 11.25 0.140732 10.0175 0.683711 9.00362L4.67714 1.54691C5.24618 0.484362 6.75381 0.484362 7.32286 1.54691L11.3163 9.00362ZM5.06238 4.49805C5.02858 3.95721 5.4581 3.5 6 3.5C6.5419 3.5 6.97142 3.95721 6.93762 4.49805L6.79678 6.75146C6.77049 7.17221 6.42157 7.5 6 7.5C5.57843 7.5 5.22951 7.17221 5.20322 6.75146L5.06238 4.49805ZM6 8C5.44772 8 5 8.44772 5 9C5 9.55229 5.44772 10 6 10C6.55228 10 7 9.55229 7 9C7 8.44772 6.55228 8 6 8Z"
														fill="#FF6A96"></path>
                </svg>
												Invalid date
											</div>
										</div>

										<div class="form__cvv form__detail">
											<label for="cvv">CVV <ion-icon
													name="information-circle" class="info md hydrated"
													role="img" aria-label="information circle"></ion-icon></label>
											<ion-icon name="lock-closed-outline" role="img"
												class="md hydrated" aria-label="lock closed outline"></ion-icon>
											<input type="password" placeholder="0000" id="cvv"
												maxlength="4" onkeypress="return isNumeric(event)">
											<div class="alert" id="alert-4">
												<svg width="12" height="12" viewBox="0 0 12 12" fill="none"
													xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd" clip-rule="evenodd"
														d="M11.3163 9.00362C11.8593 10.0175 11.1335 11.25 9.99343 11.25H2.00657C0.866539 11.25 0.140732 10.0175 0.683711 9.00362L4.67714 1.54691C5.24618 0.484362 6.75381 0.484362 7.32286 1.54691L11.3163 9.00362ZM5.06238 4.49805C5.02858 3.95721 5.4581 3.5 6 3.5C6.5419 3.5 6.97142 3.95721 6.93762 4.49805L6.79678 6.75146C6.77049 7.17221 6.42157 7.5 6 7.5C5.57843 7.5 5.22951 7.17221 5.20322 6.75146L5.06238 4.49805ZM6 8C5.44772 8 5 8.44772 5 9C5 9.55229 5.44772 10 6 10C6.55228 10 7 9.55229 7 9C7 8.44772 6.55228 8 6 8Z"
														fill="#FF6A96"></path>
                </svg>
												Invalid CVV
											</div>
										</div>

										<button type="submit" class="form__btn">Confirm</button>

									</form>
								</div>
							</div>
							<div style="display: none" id="paypal"></div>
							<a class="btn-prev">Indietro</a>
							<button type="submit">Invia</button>
						</div>
					</div>
				</f:form>

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
</script>
</body>
</html>