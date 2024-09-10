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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

<title>GamesGo</title>

<link rel="icon" href="/home/assets/images/icona.png" type="image/png">

<!-- Bootstrap core CSS -->
<link href="home/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">


<!-- Additional CSS Files -->
<link rel="stylesheet" href="home/assets/css/fontawesome.css">
<link rel="stylesheet" href="home/assets/css/templatemo-lugx-gaming.css">
<link rel="stylesheet" href="home/assets/css/owl.css">
<link rel="stylesheet" href="home/assets/css/animate.css">
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

.avatar{
	filter: drop-shadow(0 4px 6px rgba(0, 0, 0, 0.4));
}

.avatar:hover{
   	filter: drop-shadow(0 4px 6px rgba(0, 0, 0, 0.8));
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
						<a href="/" class="logo"> <img
							src="home/assets/images/logo.png" alt="" style="width: 180px;">
						</a>
						<!-- ***** Logo End ***** -->
						<!-- ***** Menu Start ***** -->
						<ul class="nav">
							<li><a href="/" class="active">Home</a></li>
							<li><a href="/catalog">Catalogo</a></li>
							<li><a href="/contact">Contattaci</a></li>

							<c:if test="${loggedUser != null}">
								<li><a
									style="cursor: pointer; text-decoration: underline; display: flex;"
									id="showFlag"><i style="padding-top: 12px;"
										class="fa-solid fa-user"></i>&nbsp;${loggedUser.username}</a>
									<div style="display: none;" id="flag">
										<button id="logout-btn">
											<i style="padding-top: 12px;"
												class="fa-solid fa-right-from-bracket"></i>&nbsp;Logout
										</button>
									</div></li>

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

	<div class="main-banner">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 align-self-center">
					<div class="caption header-text">
						<h6>Benvenuto in GamesGo</h6>
						<h2>INIZIA LA TUA NUOVA ESPERIENZA GAMING!</h2>
						<p>GamesGo è il tuo punto di riferimento per i giochi che
							contano: dai grandi classici ai nuovi successi, scopri un mondo
							di intrattenimento e sfide emozionanti, tutto a portata di click!</p>
						<div class="search-input">
							<form id="search" action="/catalog" method="post">
								<input type="hidden" name="opType" value="titleAndAuthor">
								<input type="text" placeholder="Cerca gioco per titolo o autore"
									id='searchText' name="input" onkeypress="handle" />
								<button role="button">
									<i class="fa-solid fa-magnifying-glass"></i>
								</button>
							</form>
						</div>
					</div>
				</div>
				<div class="col-lg-4 offset-lg-2">
					<div class="right-image">
						<a href="/detail/${randomGame.id}"><img
							src="${randomGame.photoUrl}" alt="${randomGame.title}"></a> <span
							class="price">€ ${randomGame.priceRetail}</span> <span
							class="offer">-20%</span>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="features">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-6">
					<a href="#">
						<div class="item">
							<div class="icon">
								<i class="fa-solid fa-shield"></i>
							</div>
							<h4>Pagamenti Sicuri</h4>
						</div>
					</a>
				</div>
				<div class="col-lg-3 col-md-6">
					<a href="#">
						<div class="item">
							<div class="icon">
								<i class="fa-solid fa-truck-fast"></i>
							</div>
							<h4>Consegna Rapida</h4>
						</div>
					</a>
				</div>
				<div class="col-lg-3 col-md-6">
					<a href="#">
						<div class="item">
							<div class="icon">
								<i class="fa-solid fa-hand-holding-dollar"></i>
							</div>
							<h4>I Migliori Prezzi</h4>
						</div>
					</a>
				</div>
				<div class="col-lg-3 col-md-6">
					<a href="#">
						<div class="item">
							<div class="icon">
								<i class="fa-solid fa-arrow-up-wide-short"></i>
							</div>
							<h4>Ampia Selezione</h4>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>

	<div class="section categories">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="section-heading">
						<h6>Categorie</h6>
						<h2>Categorie Popolari</h2>
					</div>
				</div>
				<c:if test="${not empty top5GenresGenre}">
				<c:forEach var="genre" items="${top5GenresGenre}"
					varStatus="status">
					<c:set var="game" value="${top5GenresGame[status.index]}" />
					<div class="col-lg col-sm-6 col-xs-12">
						<div class="item">
							<h4>${genre.name}</h4>
							<div class="thumb">
								<a href="/detail/${game.id}"><img src="${game.photoUrl}"
									alt=""></a>
							</div>
						</div>
					</div>
				</c:forEach>
				</c:if>
			</div>
		</div>
	</div>

	<div class="section most-played">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="section-heading">
						<h6>IN TENDENZA</h6>
						<h2>I Più Venduti</h2>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="main-button">
						<a href="/catalog">Vedi tutti</a>
					</div>
				</div>
				<c:forEach var="game" items="${topGames}">
					<div class="col-lg-2 col-md-6 col-sm-6">
						<div class="item">
							<div class="thumb">
								<a href="/detail/${game.id}"><img src="${game.photoUrl}"
									alt=""></a>
							</div>
							<div class="down-content">
								<span class="category">${game.gameGenres.get(0).genre.name}</span>
								<h4>${game.title}</h4>
								<a href="/detail/${game.id}">Esplora</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>


	<div class="section trending">
		<div class="container">
			<div class="row">
				<div class="container">
					<div class="row">
						<div class="col-lg-6">
							<div class="section-heading">
								<h6>CHI SIAMO?</h6>
								<h2>IL NOSTRO TEAM</h2>
							</div>
						</div>
						<div></div>
						<div class="col-lg-3 col-md-6">
							<div class="item">
								<div class="thumb">
								<a href="https://www.linkedin.com/in/marino-alessio/">
									<img class="avatar" src="/home/assets/images/alessio.png" alt="">
								</a>
								</div>
								<div class="down-content">
									<span class="category">ERRORISTA</span>
									<h4>Alessio Marino</h4>
									<a href="https://www.linkedin.com/in/marino-alessio/"><i
										class="fa-brands fa-linkedin"></i></a>
								</div>
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="item">
								<div class="thumb">
								<a href="https://www.linkedin.com/in/michele-di-mezza-cutillo-b839a6268/">
									<img class="avatar" src="/home/assets/images/michele.png" alt="">
								</a>
								</div>
								<div class="down-content">
									<span class="category">BACKENDISTA</span>
									<h4>Michele Di Mezza Cutillo</h4>
									<a href="https://www.linkedin.com/in/michele-di-mezza-cutillo-b839a6268/"><i
										class="fa-brands fa-linkedin"></i></a>
								</div>
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="item">
								<div class="thumb">
								<a href="https://www.linkedin.com/in/andrse/">
									<img class="avatar" src="/home/assets/images/andrea.png" alt="">
								</a>
								</div>
								<div class="down-content">
									<span class="category">ENTITISTA</span>
									<h4>Andrea Sessa</h4>
									<a href="https://www.linkedin.com/in/andrse/"><i
										class="fa-brands fa-linkedin"></i></a>
								</div>
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="item">
								<div class="thumb">
								<a href="https://www.linkedin.com/in/roccosantorsa/">
									<img class="avatar" src="/home/assets/images/rocco.png" alt="">
								</a>
								</div>
								<div class="down-content">
									<span class="category">FRONTENDISTA</span>
									<h4>Rocco Santorsa</h4>
									<a href="https://www.linkedin.com/in/roccosantorsa/"><i
										class="fa-brands fa-linkedin"></i></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<footer>
		<div class="container">
			<div class="col-lg-12">
				<p>Copyright © 2024 GamesGo Gaming Company. All rights reserved.</p>
			</div>
		</div>
	</footer>

	<!-- Scripts -->
	<!-- Bootstrap core JavaScript -->
	<script src="home/vendor/jquery/jquery.min.js"></script>
	<script src="home/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="home/assets/js/isotope.min.js"></script>
	<script src="home/assets/js/owl-carousel.js"></script>
	<script src="home/assets/js/counter.js"></script>
	<script src="home/assets/js/custom.js"></script>
	<script>
		document.getElementById('showFlag').addEventListener(
				'click',
				function(event) {
					var flag = document.getElementById('flag');
					if (flag.style.display === 'none'
							|| flag.style.display === '') {
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

		document.getElementById('logout-btn').addEventListener('click',
				function() {
					window.location.href = '/logout';
				});

		document.getElementById('flag').addEventListener('click',
				function(event) {
					event.stopPropagation();
				});
	</script>

</body>
</html>