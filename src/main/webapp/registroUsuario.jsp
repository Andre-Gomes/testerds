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

<title>Registrar novo usuário</title>

<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/bootstrap.min.css" />
<link href="${contextPath}/resources/css/testerd.css" rel="stylesheet">

</head>

<body>

	<div class="container">

		<form:form method="POST" modelAttribute="userForm" class="form-signin">
			<h2 class="form-signin-heading">Registrar usuário</h2>
			<spring:bind path="username">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="username" class="form-control"
						placeholder="Login" autofocus="true"></form:input>
					<form:errors path="username"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="password" class="form-control"
						placeholder="Password"></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="confirmaPassword">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="confirmaPassword"
						class="form-control" placeholder="Confirme o Password"></form:input>
					<form:errors path="confirmaPassword"></form:errors>
				</div>
			</spring:bind>

			<button class="btn btn-lg btn-primary btn-block" type="submit">Registrar</button>
		</form:form>

	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
