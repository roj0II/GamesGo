<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <title>Catalogo</title>
    
    <link rel="icon" href="/home/assets/images/icona.png" type="image/png">

    <!-- Bootstrap core CSS -->
    <link href="home/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="home/assets/css/fontawesome.css">
    <link rel="stylesheet" href="home/assets/css/templatemo-lugx-gaming.css">
    <link rel="stylesheet" href="home/assets/css/owl.css">
    <link rel="stylesheet" href="home/assets/css/animate.css">
    <link rel="stylesheet"href="https://unpkg.com/swiper@7/swiper-bundle.min.css"/>

	<style>
	.thumb a img {
		width: 336px;
		height: 235.200px;
		object-fit: cover;
	}
	
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
        <span></span>
        <span></span>
        <span></span>
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
                    <a href="/" class="logo">
                        <img src="home/assets/images/logo.png" alt="" style="width: 158px;">
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
                    <a class='menu-trigger'>
                        <span>Menu</span>
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
          <div class="search-input">
              <form class="ricerca" id="search" action="/catalog" method="post" style="margin: auto;">
              <input type="hidden" name="opType" value="titleAndAuthor">
                <input type="text" placeholder="Cerca gioco per titolo o autore" id='searchText' name="input" onkeypress="handle" value="${input}" />
                <button role="button"><i class="fa-solid fa-magnifying-glass"></i></button>
              </form>
            </div>
        </div>
  </div>

  <div class="section trending">
    <div class="container">
      <ul class="trending-filter">
        <li>
          <a class="is_active" href="#!" data-filter="*">Show All</a>
        </li>
        <c:forEach var="genre" items="${genres}">
        <li>
          <a href="#!" data-filter=".${genre.name}">${genre.name}</a>
        </li>
      </c:forEach>
      </ul>
      <div class="row trending-box">
      <c:forEach var="game" items="${games}">
        <div class="col-lg-3 col-md-6 align-self-center mb-30 trending-items col-md-6 ${game.gameGenres.get(0).genre.name}">
          <div class="item">
            <div class="thumb">
              <a href="/detail/${game.id}"><img src="${game.photoUrl}" alt="---"></a>
              <span class="price">€ ${game.priceDigital}</span>
              <span class="price">€ ${game.priceDigital}</span>
            </div>
            <div class="down-content">
              <span class="category">${game.gameGenres.get(0).genre.name}</span>
              <h4>${game.title}</h4>
              <a href="/detail/${game.id}"><i class="fa fa-shopping-bag"></i></a>
            </div>
          </div>
        </div>
      </c:forEach>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <ul class="pagination">
          <li><a href="#"> &lt; </a></li>
            <li><a class="is_active" href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#"> &gt; </a></li>
          </ul>
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
  </script>

  </body>
</html>