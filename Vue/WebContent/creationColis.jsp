<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">
<%@ page
	import="java.util.List, java.util.Date, model.Colis, model.Position"%>

<title>Creation colis</title>
</head>

<body>
	<h1>Cr�ation d'un colis</h1>
	<form method="post" action="CreationColis">
		<div class="form-group">
			<label for="poids">Poids </label> <input type="text" id="poids"
				name="poids" value="" class="form-control" />
		</div>
		<div class="form-group">
			<label for="valeur">Valeur </label> <input type="text" id="valeur"
				name="valeur" value="" class="form-control" />
		</div>
		<div class="form-group">
			<label for="origine">Origine </label> <input type="text" id="origine"
				name="origine" value="" class="form-control" />
		</div>
		<div class="form-group">
			<label for="destination">Destination </label> <input type="text"
				id="destination" name="destination" value="" class="form-control" />
		</div>
		<div class="form-group">
			<label for="client">S�lection d'un client</label>
			<SELECT class="form-control" id="client" name="client" size="1">
			<option selected>Choisissez un client</option>
				<c:forEach items="${Clients}" var="item">
					<OPTION value="${item.idClient}">
						${item.login}
					</OPTION>
				</c:forEach>
			</SELECT>
		</div>
		<input type="submit" value="Cr�er colis" class="btn btn-primary" />
	</form>
	
</body>
</html>