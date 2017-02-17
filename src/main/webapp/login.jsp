<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Informe username e password</title>
	<link rel="stylesheet" type="text/css"
		href="${contextPath}/resources/css/bootstrap.min.css" />
	<link href="${contextPath}/resources/css/testerd.css" rel="stylesheet">
</head>

<body>

	<div class="container">

		<form method="POST" action="${contextPath}/login" class="form-signin">
			<h2 class="form-heading">Entrar</h2>

			<div class="form-group ${error != null ? 'has-error' : ''}">
				<span>${message}</span> 
				<input name="username" type="text"
					class="form-control" placeholder="Login" autofocus /> 
				
				<input
					name="password" type="password" class="form-control"
					placeholder="Password" /> <span>${error}</span> <input type="hidden"
					name="${_csrf.parameterName}" value="${_csrf.token}" />

				<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
				<h4 class="text-center">
					<a href="${contextPath}/registroUsuario">Registrar</a>
				</h4>
			</div>

		</form>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>

</html>
