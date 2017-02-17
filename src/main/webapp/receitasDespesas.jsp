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
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/datepicker.css" />
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/navbar-fixed-top.css" />

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap-datepicker.js"></script>


<script type="text/javascript"
	src="${contextPath}/resources/js/jquery_price_format/jquery.price_format.1.7.js"></script>

<script type="text/javascript"
	src="${contextPath}/resources/js/inputmask/jquery.inputmask.js"></script>
<script type="text/javascript"
	src="${contextPath}/resources/js/inputmask/jquery.inputmask.date.extensions.js"></script>
<script type="text/javascript"
	src="${contextPath}/resources/js/inputmask/jquery.inputmask.extensions.js"></script>
<script type="text/javascript"
	src="${contextPath}/resources/js/inputmask/jquery.inputmask.numeric.extensions.js"></script>
<script type="text/javascript"
	src="${contextPath}/resources/js/inputmask/jquery.inputmask.phone.extensions.js"></script>
<script type="text/javascript"
	src="${contextPath}/resources/js/inputmask/jquery.inputmask.regex.extensions.js"></script>

</head>
<body>
	<div class="container">
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
						<li><a href="/home">Home</a></li>
						<li class="active dropdown"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown" role="button"
							aria-haspopup="true" aria-expanded="false">Financeiro <span
								class="caret"></span></a>
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
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
		</c:if>




		<h2>Receitas e Despesas</h2>

		<div class="alert alert-info">
			<spring:message var="message"></spring:message>
		</div>

		<form:form action="/receitaDespesa/adicionar"
			commandName="receitaDespesa">


			<form:errors path="*" class="alert alert-warning" element="div" />

			<div class="form-group">
				<form:label path="evento" for="evento">Evento:</form:label>
				<form:input type="text" class="form-control" id="evento"
					path="evento" />
			</div>
			<div class="form-group">
				<form:label path="codigoEvento" for="codigoEvento">Código Evento:</form:label>
				<form:input type="text" class="form-control" id="codigoEvento"
					path="codigoEvento" />
			</div>
			<div class="form-group">
				<form:label path="creditoDebito" for="creditoDebito">Crédito/Débito</form:label>
				<form:select id="creditoDebito" path="creditoDebito">
					<form:option value="">Selecione</form:option>
					<form:option value="1">Credito</form:option>
					<form:option value="4">Debito</form:option>
				</form:select>
			</div>
			<div class="form-group">
				<form:label path="categoria" for="categoria">Categoria</form:label>
				<form:select id="categoria" path="categoria">
					<form:option value="">Selecione</form:option>
					<form:option value="2">Pagamento</form:option>
					<form:option value="5">Reembolso</form:option>
				</form:select>
			</div>

			<div class="form-group">
				<form:label path="subCategoria" for="subCategoria">SubCategoria</form:label>
				<form:select id="subCategoria" path="subCategoria">
					<form:option value="">Selecione</form:option>
					<form:option value="3">Venda</form:option>
					<form:option value="8">Despesas</form:option>
				</form:select>
			</div> 

			
			<div class="form-group">
				<form:label path="valor" for="valor">Valor:</form:label>
				<form:input type="text" path="valor" class="form-control" id="valor" />
			</div>

			<div class="form-group">
				<form:label path="dtLancamento" for="valor">Data Lançamento:</form:label>
				<form:input class="form-control" size="16" type="text"
					id="dtLancamento" path="dtLancamento" />
			</div>

			<div class="form-group">
				<form:label path="status" for="status">Status:</form:label>
				<form:select path="status">
					<form:option value="ATIVO">ATIVO</form:option>
					<form:option value="INATIVO">INATIVO</form:option>
				</form:select>
			</div>
			<div class="form-group">
				<form:label path="comentario" for="comment">Comentário:</form:label>
				<form:textarea path="comentario" class="form-control" rows="5"
					id="comentario"></form:textarea>
			</div>

			<form:hidden path="id" />

			<button type="button" class="btn btn-primary">Novo</button>
			<button type="button" class="btn btn-primary ">Remover</button>
			<button type="submit" class="btn btn-primary ">Salvar</button>
			<button type="button" class="btn btn-primary">Fechar</button>

		</form:form>


		<div class="table-responsive">
			<table class="table table-hover table-condensed table-striped">
				<thead>
					<tr>
						<th>Evento</th>
						<th>Cod Evento</th>
						<th>Categoria</th>
						<th>SubCategoria</th>
						<th>Crédito/Débito</th>
						<th>Valor</th>
						<th>Dt Lançamento</th>
						<th>Status</th>
						<th>Comentário</th>
						<th>Dt Criação</th>
						<th>Dt Atualização</th>
						<th>Funcionário</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${receitasDespesas}">
						<tr>
							<td>${item.evento}</td>
							<td>${item.codigoEvento}</td>
							<td>${item.categoria.valor}</td>
							<td>${item.subCategoria.valor}</td>
							<td>${item.creditoDebito.valor}</td>
							<td>${item.valor}</td>
							<td>${item.dtLancamento}</td>
							<td>${item.status}</td>
							<td>${item.comentario}</td>
							<td>${item.dhCriacao}</td>
							<td>${item.dhAtualizacao}</td>
							<td>${item.login}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<script>
		$(function() {
			$('#valor').priceFormat({
				prefix : '',
				centsSeparator : ',',
				thousandsSeparator : '.'
			});
		});

		$(document).ready(function() {
			$("#dtLancamento").inputmask("mask", {
				"mask" : "d/m/y"
			});
		});
	</script>


</body>
</html>