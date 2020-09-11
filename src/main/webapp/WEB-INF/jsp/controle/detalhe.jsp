<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <title>AppControle</title>
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
	
		<h3>Controle: ${operacao}</h3>
	
		<form action="/controle/incluir" method="post">
		
		    <div class="form-group">
		      <label for="usr">Solicitante:</label>
		      <select class="form-control" name="solicitante.id">
		      	<c:forEach var="s" items="${solicitantes}">
					<option value="${s.id}">${s.nome}</option>
				</c:forEach>
		      </select>
		    </div>
		
		    <div class="form-group">
		      <label for="usr">Descri��o:</label>
		      <input type="text" class="form-control" name="descricao">
		    </div>
	
			<div class="form-group">
				<label for="usr">Remedios:</label>
				<c:if test="${not empty remedios}">
					<div class="form-check">
						<label class="form-check-label">
							<c:forEach var="p" items="${remedios}">
								<input type="checkbox" class="form-check-input" name="remediosIds" value="${p.id}"> ${p.descricao}<br>
							</c:forEach>
						</label>
					</div>
				</c:if>
				<c:if test="${empty remedios}">
				<label for="usr">Nenhum rem�dio cadastrado!</label>
				</c:if>
			</div>
	
		<c:if test="${empty remedios || empty solicitantes}">
			<c:set var="disabled" value="disabled"/>
		</c:if>
		
	
	    <button ${disabled} type="submit" class="btn btn-primary">Gravar</button>
	  </form>
	</div>
</body>
</html>