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

	<link rel="icon" type="image/x-icon" href="${game.photoUrl}">
    <title>${game.title}</title>

    <!-- Bootstrap core CSS -->
    <link href="../home/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="../home/assets/css/fontawesome.css">
    <link rel="stylesheet" href="../home/assets/css/templatemo-lugx-gaming.css">
    <link rel="stylesheet" href="../home/assets/css/owl.css">
    <link rel="stylesheet" href="../home/assets/css/animate.css">
    <link rel="stylesheet"href="https://unpkg.com/swiper@7/swiper-bundle.min.css"/>

	<style>
       button {
            margin: 10px;
            padding: 10px;
        }
        .selected {
            background-color: lightgreen;
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
                    <a href="index.html" class="logo">
                        <img src="../home/assets/images/logo.png" alt="" style="width: 158px;">
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
      <div class="row">
        <div class="col-lg-12">
          <h3>${game.title}</h3>
        </div>
      </div>
    </div>
  </div>

  <div class="single-product section">
    <div class="container">
      <div class="row">
        <div class="col-lg-6">
          <div class="left-image">
            <img src="${game.photoUrl}" alt="">
          </div>
        </div>
        <div class="col-lg-6 align-self-center">
          <h4>${game.title}</h4>
          <span class="price"><em>€ ${game.priceRetail + game.priceRetail/100*20}</em>€ ${game.priceRetail}</span>
          <br>
        <form action="/checkout/${game.id}" method="post"> <!-- bottoni -->
        
          	<label class="checkbox-button <c:if test="${game.storage.amountRetail <= 0}">out</c:if>" id="button1" style="margin-top: 20px; margin-right: 15px; width: 190px;">
			    <input type="checkbox" name="formatType" value="retail" 
			           <c:if test="${game.storage.amountRetail <= 0}">disabled</c:if>>
			    <i class="fa-solid fa-gamepad"></i> Gioco Fisico
			</label>

			<label class="checkbox-button <c:if test="${game.storage.amountDigital <= 0}">out</c:if>" id="button2" style="margin-top: 20px; margin-right: 15px; width: 190px;">
			    <input type="checkbox" name="formatType" value="digital" 
			           <c:if test="${game.storage.amountDigital <= 0}">disabled</c:if>>
			    <i class="fa-solid fa-key"></i> Gioco Digitale
			</label>
			<br>
			<div style="display: flex;">
				<label class="transaction-button" id="button3" style="
				    margin-top: 20px; 
				    margin-right: 18px; 
				    width: 190px; 
				    display: flex; 
				    align-items: center; 
				    justify-content: center; 
				    text-align: center;">
				    <input type="checkbox" name="transactionType" value="buy">
				    <i class="fa fa-shopping-bag"></i>&nbsp;Acquisto
				</label>
		        <label class="transaction-button" id="button4" style="
				    margin-top: 20px; 
				    margin-right: 10px; 
				    width: 190px; 
				    display: flex; 
				    align-items: center; 
				    justify-content: center; 
				    text-align: center;">
				    <input type="checkbox" name="transactionType" value="rent" style="margin-right: 5px;">
				    <i class="fa-solid fa-handshake"></i>&nbsp;Noleggio
				</label>
			</div>
            <br>
	    	<button id="submit"  style="margin-top: 20px; width: 380px;">Procedi</button>
	     </form>

		<ul>
			<li><span>Data rilascio:</span> ${game.releaseDate}</li>
			<li><span>Generi:</span> 
				<c:forEach var="gameGenre" items="${game.gameGenres}" varStatus="status">
					${gameGenre.genre.name}
				<c:if test="${!status.last}">
        			,&nbsp;
    			</c:if>
				</c:forEach>
			</li>
			<li><span>Autore:</span> ${game.author}</li>
		</ul>
        </div>
        <div class="col-lg-12">
          <div class="sep"></div>
        </div>
      </div>
    </div>
  </div>

  <div class="more-info">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="tabs-content">
            <div class="row">
              <div class="nav-wrapper ">
                <ul class="nav nav-tabs" role="tablist">
                  <li class="nav-item" role="presentation">
                    <button class="nav-link active" id="description-tab" data-bs-toggle="tab" data-bs-target="#description" type="button" role="tab" aria-controls="description" aria-selected="true">Description</button>
                  </li>
                  <li class="nav-item" role="presentation">
                    <button class="nav-link" id="reviews-tab" data-bs-toggle="tab" data-bs-target="#reviews" type="button" role="tab" aria-controls="reviews" aria-selected="false">Reviews (0)</button>
                  </li>
                </ul>
              </div>              
              <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="description" role="tabpanel" aria-labelledby="description-tab">
                  	<p>
                  		${game.description}
                  	</p>
                  </div>
                <div class="tab-pane fade" id="reviews" role="tabpanel" aria-labelledby="reviews-tab">
                	<p>
                		Al momento non ci sono recensioni per questo gioco.
                	</p>  
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
  <script src="../home/vendor/jquery/jquery.min.js"></script>
  <script src="../home/vendor/bootstrap/js/bootstrap.min.js"></script>
  <script src="../home/assets/js/isotope.min.js"></script>
  <script src="../home/assets/js/owl-carousel.js"></script>
  <script src="../home/assets/js/counter.js"></script>
  <script src="../home/assets/js/custom.js"></script>
  <script>
    document.querySelectorAll('.checkbox-button input').forEach((checkbox) => {
        checkbox.addEventListener('change', () => {
            if (checkbox.checked) {
                document.querySelectorAll('.checkbox-button input').forEach((otherCheckbox) => {
                    if (otherCheckbox !== checkbox) {
                        otherCheckbox.checked = false;
                        otherCheckbox.parentElement.classList.remove('active');
                    }
                });
            }
            checkbox.parentElement.classList.toggle('active', checkbox.checked);
        });
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

    // Gestione del submit del form
    document.getElementById('submit').addEventListener('click', (event) => {
        const formatChecked = Array.from(document.querySelectorAll('.checkbox-button input')).some(checkbox => checkbox.checked);
        const transactionChecked = Array.from(document.querySelectorAll('.transaction-button input')).some(checkbox => checkbox.checked);

        if (!formatChecked && !transactionChecked) {
            event.preventDefault();
            alert('Per favore, seleziona un formato e un tipo di transazione prima di procedere.');
        } else if (!formatChecked ) {
            event.preventDefault();
        	alert('Per favore, seleziona un tipo di formato.');
        }else if (!transactionChecked ) {
        	event.preventDefault();
        	alert('Per favore, seleziona un tipo di transazione.');
        }
    });

	//login/logou
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