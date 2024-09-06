<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GameGenre</title>
    <!-- Web Icon -->
    <link rel="icon" type="image/x-icon" href="https://icons.veryicon.com/png/o/miscellaneous/yuanql/icon-admin.png">
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" rel="stylesheet">
    <!-- Our CSS -->
    <link href="/css/styleEntity.css" rel="stylesheet">
    <style>
    	:root {
    		--main-color: #FF66FF;
    	}
    </style>
</head>
<body>
    <div class="container">
        <div class="header-buttons">
            <a href="/gamegenre/" class="btn btn-primary"><i class="fas fa-arrow-left"></i> Indietro</a>
            <div class="icons">
	            <i class="fa-solid fa-mars-and-venus-burst fa-2xl"></i>
	         </div>   
	            <h1 class="header-title">Inserisci Gioco e Genere</h1>
            <a href="/admin" class="btn btn-success"><i class="fas fa-home"></i> Home</a>
        </div>
        
        <f:form modelAttribute="gameGenreForm" method="POST" action="/gamegenre/insert">
	    <table class="table table-striped">
	        <thead>
	            <tr>
	                <td>Game</td>
	                <td>
	                    <input id="gameInput" class="input-label" list="gameList" name="idGame" />
	                    <datalist id="gameList">
	                        <c:forEach items="${games}" var="game">
	                            <option value="${game.id}">${game.title}</option>
	                        </c:forEach>
	                    </datalist>
	                </td>
	            </tr>
	            <tr>
	                <td>Genre</td>
	                <td>
	                    <input id="genreInput" class="input-label" list="genreList" name="idGenre" />
	                    <datalist id="genreList">
	                        <c:forEach items="${genres}" var="genre">
	                            <option value="${genre.id}">${genre.name}</option>
	                        </c:forEach>
	                    </datalist>
	                </td>
	            </tr>
	        </thead>
	    </table>
	    <button type="submit" class="buttons">Salva</button>
	</f:form>
    </div>

    <!-- Include il file popup -->
    <jsp:include page="../fragments/popup.jsp" />
    
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <!-- Script di validazione -->
    <script>
        document.querySelector("form").addEventListener("submit", function(event) {
            const gameInput = document.getElementById("gameInput").value;
            const genreInput = document.getElementById("genreInput").value;
            
            const games = Array.from(document.querySelectorAll("#gameList option")).map(option => option.value);
            const genres = Array.from(document.querySelectorAll("#genreList option")).map(option => option.value);
            
            var gameIncludesed = games.includes(gameInput);
            var genreIncludesed = genres.includes(genreInput);
            
            if (!gameIncludesed && !genreIncludesed) {
            	alert("Il gioco e il genere inseriti non sono validi.");
                event.preventDefault();
            } else if (!gameIncludesed) {
                alert("Il gioco inserito non è valido.");
                event.preventDefault();
            } else if (!genreIncludesed) {
                alert("Il genere inserito non è valido.");
                event.preventDefault();
            }
        });
    </script>
</body>
</html>
