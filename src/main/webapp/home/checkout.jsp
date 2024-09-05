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

						<form style="display: flex; justify-content: space-between;">
							<fieldset style="display: inline;">
								<input value="${check.gameTitle}" disabled
									style="width: 250px; font-weight: bold;">
							</fieldset>
							<fieldset style="display: inline;">
								<input value="€${check.gamePrice}" disabled
									style="width: 100px; font-weight: bold;">
							</fieldset>
						</form>

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
								<a class="btn-next">Avanti</a>
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
							<div style="display: flex; justify-content: end;">
								<a class="btn-next next-prev">Avanti</a>
							</div>
						</div>


						<div class="slide">
							<div class="row">
									<h4 style="margin-left: 20px;">Informazioni di
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
							<a class="btn-prev">Indietro</a> <a class="btn-next">Avanti</a>
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
						<div id="cartacredito" style="display:none"></div>
						<div style="display:none" id="paypal"></div>
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
				<script>
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