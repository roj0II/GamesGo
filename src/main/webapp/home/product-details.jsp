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
                      <li><a href="/catalog">Our Shop</a></li>
                      <li><a href="contact.html">Contact Us</a></li>
                      <li><a href="/login">Sign In</a></li>
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
          <span class="price"><em>€ ${game.priceRetail}</em>€ ${game.priceDigital}</span>
          <p>${game.description}</p>
          	<button id="button1" onclick="toggleButton(1)"><i class="fa-solid fa-gamepad"></i>Gioco Fisico</button>
    		<button id="button2" onclick="toggleButton(2)"><i class="fa-solid fa-earth-americas"></i>Gioco Digitale</button>

			<br>
			<button id="button3" onclick="toggleButton(3)"><i class="fa fa-shopping-bag"></i>Acquisto</button>
    		<button id="button4" onclick="toggleButton(4)"><i class="fa-solid fa-handshake"></i>Noleggio</button>

            <br>
    		<button id="submit" onclick="handleSubmit()">Submit</button>

          <ul>
            <li><span>Game ID:</span> ${game.id}</li>
            <li><span>Genre:</span> ${game.gameGenres.get(0).genre.name}</li>
            <li><span>Author:</span> ${game.author}</li>
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
                    <button class="nav-link" id="reviews-tab" data-bs-toggle="tab" data-bs-target="#reviews" type="button" role="tab" aria-controls="reviews" aria-selected="false">Reviews (3)</button>
                  </li>
                </ul>
              </div>              
              <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="description" role="tabpanel" aria-labelledby="description-tab">
                  <p>You can search for more templates on Google Search using keywords such as "templatemo digital marketing", "templatemo one-page", "templatemo gallery", etc. Please tell your friends about our website. If you need a variety of HTML templates, you may visit Tooplate and Too CSS websites.</p>
                  <br>
                  <p>Coloring book air plant shabby chic, crucifix normcore raclette cred swag artisan activated charcoal. PBR&B fanny pack pok pok gentrify truffaut kitsch helvetica jean shorts edison bulb poutine next level humblebrag la croix adaptogen. Hashtag poke literally locavore, beard marfa kogi bruh artisan succulents seitan tonx waistcoat chambray taxidermy. Same cred meggings 3 wolf moon lomo irony cray hell of bitters asymmetrical gluten-free art party raw denim chillwave tousled try-hard succulents street art.</p>
                </div>
                <div class="tab-pane fade" id="reviews" role="tabpanel" aria-labelledby="reviews-tab">
                  <p>Coloring book air plant shabby chic, crucifix normcore raclette cred swag artisan activated charcoal. PBR&B fanny pack pok pok gentrify truffaut kitsch helvetica jean shorts edison bulb poutine next level humblebrag la croix adaptogen. <br><br>Hashtag poke literally locavore, beard marfa kogi bruh artisan succulents seitan tonx waistcoat chambray taxidermy. Same cred meggings 3 wolf moon lomo irony cray hell of bitters asymmetrical gluten-free art party raw denim chillwave tousled try-hard succulents street art.</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="section categories related-games">
    <div class="container">
      <div class="row">
        <div class="col-lg-6">
          <div class="section-heading">
            <h6>Action</h6>
            <h2>Related Games</h2>
          </div>
        </div>
        <div class="col-lg-6">
          <div class="main-button">
            <a href="shop.html">View All</a>
          </div>
        </div>
        <div class="col-lg col-sm-6 col-xs-12">
          <div class="item">
            <h4>Action</h4>
            <div class="thumb">
              <a href="product-details.html"><img src="../home/assets/images/categories-01.jpg" alt=""></a>
            </div>
          </div>
        </div>
        <div class="col-lg col-sm-6 col-xs-12">
          <div class="item">
            <h4>Action</h4>
            <div class="thumb">
              <a href="product-details.html"><img src="../home/assets/images/categories-05.jpg" alt=""></a>
            </div>
          </div>
        </div>
        <div class="col-lg col-sm-6 col-xs-12">
          <div class="item">
            <h4>Action</h4>
            <div class="thumb">
              <a href="product-details.html"><img src="../home/assets/images/categories-03.jpg" alt=""></a>
            </div>
          </div>
        </div>
        <div class="col-lg col-sm-6 col-xs-12">
          <div class="item">
            <h4>Action</h4>
            <div class="thumb">
              <a href="product-details.html"><img src="../home/assets/images/categories-04.jpg" alt=""></a>
            </div>
          </div>
        </div>
        <div class="col-lg col-sm-6 col-xs-12">
          <div class="item">
            <h4>Action</h4>
            <div class="thumb">
              <a href="product-details.html"><img src="../home/assets/images/categories-05.jpg" alt=""></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <footer>
    <div class="container">
      <div class="col-lg-12">
        <p>Copyright © 2048 LUGX Gaming Company. All rights reserved. &nbsp;&nbsp; <a rel="nofollow" href="https://templatemo.com" target="_blank">Design: TemplateMo</a></p>
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
        // Variabili di stato per controllare i bottoni selezionati
        let selectedButtons = [];

        // Funzione per gestire la selezione/deselezione dei bottoni
        function toggleButton(buttonId) {
            const button = document.getElementById(`button${buttonId}`);
            
            if (selectedButtons.includes(buttonId)) {
                // Se già selezionato, lo deseleziono
                selectedButtons = selectedButtons.filter(id => id !== buttonId);
                button.classList.remove("selected");
            } else {
                // Se non selezionato, aggiungo il bottone all'array di selezione
                if (selectedButtons.length < 2) {
                    selectedButtons.push(buttonId);
                    button.classList.add("selected");
                } else {
                    alert("Puoi selezionare solo due bottoni!");
                }
            }
        }

        // Funzione per gestire il submit e le azioni in base alla selezione
        function handleSubmit() {
            if (selectedButtons.length !== 2) {
                alert("Devi selezionare esattamente due bottoni.");
                return;
            }

            // Ordinare i bottoni per garantire coerenza nelle condizioni
            selectedButtons.sort();

            // Logica per eseguire le azioni a seconda dei bottoni selezionati
            if (selectedButtons.includes(1) && selectedButtons.includes(2)) {
                alert("Hai selezionato Button 1 e Button 2! Azione 1.");
                // Azione 1
            } else if (selectedButtons.includes(1) && selectedButtons.includes(3)) {
                alert("Hai selezionato Button 1 e Button 3! Azione 2.");
                // Azione 2
            } else if (selectedButtons.includes(2) && selectedButtons.includes(4)) {
                alert("Hai selezionato Button 2 e Button 4! Azione 3.");
                // Azione 3
            } else if (selectedButtons.includes(3) && selectedButtons.includes(4)) {
                alert("Hai selezionato Button 3 e Button 4! Azione 4.");
                // Azione 4
            } else {
                alert("Combinazione non valida.");
            }

            // Resetto i bottoni dopo il submit
            resetButtons();
        }

        // Funzione per resettare la selezione dei bottoni
        function resetButtons() {
            selectedButtons = [];
            document.querySelectorAll("button").forEach(button => {
                button.classList.remove("selected");
            });
        }
    </script>
  </body>
</html>