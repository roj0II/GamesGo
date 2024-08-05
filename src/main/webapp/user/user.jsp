<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User</title>
    <!-- Web Icon -->
    <link rel="icon" type="image/x-icon" href="https://www.svgrepo.com/show/37992/male-and-female-symbol.svg">
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" rel="stylesheet">
    <!-- Our CSS -->
    <link href="/css/styleEntity.css" rel="stylesheet">
    <style>
    
	:root {
		--main-color: #FF6666;
	}
	
	#showButton {
		padding: 10px 20px;
		font-size: 16px;
	}
	
	.fa-regular.fa-eye-slash {
		cursor: pointer;
	}
	
	.fa-regular.fa-eye {
		cursor: pointer;
	}
	
	.container-password {
	    position: relative;
	    width: 200px;
	    height: 200px;
	    margin: 20px auto;
	    text-align: center;
	}
	
	.overlay {
	    display: none;
	    position: absolute;
	    top: 50%;
	    left: 50%;
	    transform: translate(-50%, -50%);
	    padding: 20px;
	    background: rgba(0, 0, 0, 0.8);
	    color: #fff;
	    border-radius: 5px;
	    z-index: 10;
	}

    </style>
</head>
<body>
    <div class="container">
        <div class="header-buttons">
            <a href="/admin" class="btn btn-primary"><i class="fas fa-arrow-left"></i> Indietro</a>
            <div class="icons">
	            <i class="fa-solid fa-users fa-2xl"></i>
	         </div>
	            <h1 class="header-title">Lista di Utenti</h1> 
            <a href="/user/insert" class="btn btn-success"><i class="fas fa-plus"></i> Aggiungi</a>
        </div>
        <table class="table table-striped">
            <thead>
		<tr>
			<th>Username</th>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Indirizzo</th>
			<th>Telefono</th>
			<th>E-mail</th>
			<th>Password</th>
			<th>Admin</th>
			<th>Action</th>
		</tr>
		</thead>
            <tbody>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.username}</td>
				<td>${user.name}</td>
				<td>${user.surname}</td>
				<td>${user.address}</td>
				<td>${user.phone}</td>
				<td>${user.email}</td>
				<td>
					<i class="showButton fa-regular fa-eye-slash"></i>
        			<div class="overlay">${user.password}</div>
        		</td>
				<td>${user.admin}</td>
				<td class="table-actions">
	                        <a href="/user/update/${user.id}" class="btn btn-warning btn-sm">
	                        <i class="fas fa-edit"></i> Modifica</a>
	                        <a href="/user/delete/${user.id}" class="btn btn-danger btn-sm" onclick="confirmDelete(event)">
	                        <i class="fas fa-trash"></i> Elimina</a>
	                </td>
				</tr>
				</c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
	    function confirmDelete(event) {
	      event.preventDefault();
	      if (confirm("Sei sicuro di voler eliminare questo elemento?")) {
	    	  window.location.href = event.target.href;
	      }
	    }
	  </script>
	  <script>
		  document.querySelectorAll('.showButton').forEach(function(button) {
		        button.addEventListener('click', function() {
		            var container = button.parentElement;
		            var overlay = container.querySelector('.overlay');
	
		            if (overlay.style.display === 'none' || overlay.style.display === '') {
		                overlay.style.display = 'block';
		                button.classList.remove('fa-eye-slash');
		                button.classList.add('fa-eye');
		                setTimeout(() => {
		                    overlay.style.display = 'none';
		                    button.classList.remove('fa-eye');
		                    button.classList.add('fa-eye-slash');
		                }, 5500);
		            } else {
		                overlay.style.display = 'none';
		                button.classList.remove('fa-eye');
	                    button.classList.add('fa-eye-slash');
		            }
		        });
		    });
	  </script>
</body>
</html>