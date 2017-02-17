<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title>Teste Receitas e Despesas</title>
<meta charset="utf-8">
<meta content="IE=edge" http-equiv=X-UA-Compatible>
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/navbar-fixed-top.css" />

<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

	<!-- Fixed navbar -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Teste de Receitas e Despesas</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/home">Home</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Financeiro <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/receitasDespesas">Receitas e Despesas</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"
						onclick="document.forms['logoutForm'].submit()">Sair</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<h1>Página inicial</h1>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
		</c:if>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>