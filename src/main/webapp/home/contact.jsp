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

    <title>Lugx Gaming Template - Contact Page</title>

    <!-- Bootstrap core CSS -->
    <link href="home/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="home/assets/css/fontawesome.css">
    <link rel="stylesheet" href="home/assets/css/templatemo-lugx-gaming.css">
    <link rel="stylesheet" href="home/assets/css/owl.css">
    <link rel="stylesheet" href="home/assets/css/animate.css">
    <link rel="stylesheet"href="https://unpkg.com/swiper@7/swiper-bundle.min.css"/>

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
                      <li><a href="/catalog">Our Shop</a></li>
                      <li><a href="/contact" class="active">Contact Us</a></li>
                      
                      <c:if test="${loggedUser != null}">
                      	<li><a style="cursor: pointer; text-decoration: underline; display: flex;" id="showFlag">${loggedUser.username}</a>
                      		<div style="display: none;" id="flag">
					        	<button id="logout-btn">Logout</button>
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
      <div class="row">
        <div class="col-lg-12">
          <h3>Contact Us</h3>
        </div>
      </div>
    </div>
  </div>

  <div class="contact-page section">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 align-self-center">
          <div class="left-text">
            <div class="section-heading">
              <h6>Contact Us</h6>
              <h2>Say Hello!</h2>
            </div>
            <p>Hai bisogno di assistenza o hai qualche domanda? Siamo qui per aiutarti! Che tu abbia bisogno di supporto tecnico, informazioni sui nostri giochi o suggerimenti su come migliorare la tua esperienza di gioco, il team di <a href="/" style="color: blue;">GamesGo</a> è a tua disposizione. Compila il modulo qui sotto o contattaci direttamente via email. Non vediamo l'ora di sentirti e di rendere la tua avventura di gioco ancora più straordinaria. A presto!</p>
            <ul>
              <li><span>Indirizzo</span> Via Salvo D'Acquisto, 87042 Altomonte CS, Italy</li>
              <li><span>Telefono</span> +39 0981 94 88 22</li>
              <li><span>Email</span> gamesgo@libero.it</li>
            </ul>
          </div>
        </div>
        <div class="col-lg-6">
          <div class="right-content">
            <div class="row">
              <div class="col-lg-12">
                <div id="map">
					<iframe style="border-radius: 25px;" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d323.776493332698!2d16.1247023!3d39.6984271!2m3!1f357.26927939317244!2f20.870722720054623!3f0!3m2!1i1024!2i768!4f35!3m3!1m2!1s0x133f12e3821d4739%3A0x38c8e601b941aa59!2sFarmacia%20D'Agostino%20Giampiero!5e1!3m2!1sen!2sth!4v1642869952544!5m2!1sen!2sth" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
					
				</div>
              </div>
              <div class="col-lg-12">
                <form id="contact-form" action="/contact" method="post">
                  <div class="row">
                    <div class="col-lg-6">
                    <span style="margin-left: 50px"><b>Nome</b></span>
                      <fieldset>
                        <input type="name" name="name" id="name" placeholder="Nome" value="${loggedUser.name}" autocomplete="on" required>
                      </fieldset>
                    </div>
                    <div class="col-lg-6">
                    <span style="margin-left: 50px"><b>Cognome</b></span>
                      <fieldset>
                        <input type="surname" name="surname" id="surname" placeholder="Cognome" value="${loggedUser.surname}" autocomplete="on" required>
                      </fieldset>
                    </div>
                    <div class="col-lg-6">
                    <span style="margin-left: 50px"><b>E-Mail</b></span>
                      <fieldset>
                        <input type="text" name="email" id="email" pattern="[^ @]*@[^ @]*" value="${loggedUser.email}" required>
                      </fieldset>
                    </div>
                    <div class="col-lg-6">
                    <span style="margin-left: 50px"><b>Oggetto</b></span>
                      <fieldset>
                        <input type="subject" name="subject" id="subject" placeholder="Oggetto" autocomplete="on" required>
                      </fieldset>
                    </div>
                    <div class="col-lg-12">
                    <span style="margin-left: 50px"><b>Messaggio</b></span>
                      <fieldset>
                        <textarea name="message" id="message" placeholder="Messaggio" required></textarea>
                      </fieldset>
                    </div>
                    <div class="col-lg-12">
                      <fieldset>
                        <button type="submit" id="form-submit" class="orange-button">Inviaci il messaggio</button>
                      </fieldset>
                    </div>
                  </div>
                </form>
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