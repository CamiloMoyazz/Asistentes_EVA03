<%-- 
    Document   : header
    Created on : 20 jun. 2021, 19:14:06
    Author     : Chalabera
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro de Asistentes</title>
<link rel="stylesheet" href="vendor/bulma/css/bulma.min.css">
</head>
<body>
	
	<header>
		<nav class="navbar is-dark has-background-dark is-spaced" role="navigation" aria-label="main navigation">
			<div class="navbar-brand">
				<img class="image is-64x64 mr-5" src="https://iconmonstr.com/wp-content/g/gd/makefg.php?i=../assets/preview/2017/png/iconmonstr-photo-camera-12.png&r=255&g=255&b=255">
				<a role="button" class="navbar-burger" aria-label="menu"
					aria-expanded="false" data-target="navbarBasicExample"> <span
					aria-hidden="true"></span> <span aria-hidden="true"></span> <span
					aria-hidden="true"></span>
				</a>
			</div>

			<div id="navbarBasicExample" class="navbar-menu">
				<div class="navbar-start">
					<a class="navbar-item" href="index.jsp"> Home </a> 
					<a class="navbar-item" href="IngresarAsistentesController.do"> Ingresar Asistente</a> 
					<a class="navbar-item" href="MostrarAsistentesController.do"> Asistentes Registrados</a> 
					
				</div>
			</div>
		</nav>
	</header>
