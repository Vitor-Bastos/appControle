<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <title>appControle</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="container-fluid" style="margin-top:80px">		
			<c:import url="/WEB-INF/jsp/header.jsp"/>
		</div>			

		<div class="card" style="width:600px">
		  <img class="card-img-top" src="https://www.infnet.edu.br/infnet/wp-content/uploads/sites/6/2018/01/logotipo.png" alt="Instituto Infnet">
		  <div class="card-body">
		    <h4 class="card-title">Vitor Bastos</h4>
		    <p class="card-text">Engenharia de Software</p>
		    <p class="card-text">TP9 - Projeto de Bloco & TP3 - Desenvolvimento Web com Java EE</p>
		    <a target="_blank" href="https://github.com/Vitor-Bastos" class="btn btn-primary">GIT</a>
		  </div>
		</div>

	</div>		
</body>
</html>