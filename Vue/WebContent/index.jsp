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
<title>Connexion</title>
</head>
<body>
<h1>Connexion</h1>
	<form method="post" action="Connexion">
		<div class="form-group">
			<label for="login">Login </label> <input type="text" id="login"
				name="login" value="" class="form-control" />
		</div>
		<div class="form-group">
			<label for="password">Password </label> <input type="password" id="password"
				name="password" value="" class="form-control" />
		</div>
		<input type="submit" value="Connexion" class="btn btn-primary" />
	</form>
	<c:if test="${not empty loginError}">
    <script>
    window.addEventListener("load",function(){
         alert("${loginError}");
    })
    </script>
</c:if>

</body>
</html>