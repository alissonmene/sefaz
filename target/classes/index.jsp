<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuario</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>

<script type="text/javascript" src="resource/js/jquery.mask.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#ddd').mask('(999)');
	});

	$(document).ready(function() {
		$('#numero').mask('999-999-999');
	});

	$(document).ready(function() {

		$('#email').blur(function() {

			var email = $('#email').val();

			$.ajax({
				url : 'usuarioemailajax',
				method : 'get',
				dataType : 'json',
				data : {
					'email' : email,
				},
				success : function(data, textStatus, jqXHR) {
					if (data.isExisteEmail) {
						alert("email já existe");
						document.getElementById("email").value = "";
					}
				},
				statusCode : {
					400 : function() {
						alert("Chamada inválida!");
					}
				}
			});

		});

	});

	function validar() {
		var emailValido = document.getElementById("emailValido").value;
		var email = document.getElementById("email").value;
		if (email != '' && emailValidor) {
			alert("email já existe");
			return;
		}
	}

	function checarRadioButton() {

		var rates = document.getElementsByName('radio');
		var rate_value = false;
		for (var i = 0; i < rates.length; i++) {
			if (rates[i].checked) {
				rate_value = true;
			}
		}

		if (!rate_value) {
			alert("selecione um usuário para remover ou alterar");
		}

		return rate_value; 

	}
</script>

</head>
<body>
	
	<h1>Usuários</h1>
		
	<form action="/sefaz/logout" method="get">	
		<button class="float-right" value="Logout"> Logout</button>	
	</form>
	
	<form action="usuariolist" method="post">

		
		
		<div class="form-group">
			<label for="Nome">Nome </label> <input type="text"
				class="form-control" id="nome" name="nome" required>
		</div>
		<div class="form-group">
			<label for="email">Email </label> <input type="email"
				class="form-control" id="email" aria-describedby="emailHelp"
				name="email" placeholder="informe o email" required>
		</div>
		<div class="form-group">
			<label for="senha">Senha</label> <input name="senha" type="password"
				class="form-control" id="senha" placeholder="Senha" required>
		</div>

		<input name="emailValido" type="hidden" id="emailValido" value="true" />
		<!--  
		<div class="form-group row" id="contato">

			<label for="ddd" class="col-sm-2 col-form-label">DDD</label> <div class="col-sm-2"><input
				name="ddd" type="text" class="form-control" id="ddd" />
			</div>
			<label for="numero" class="col-sm-2 col-form-label">Número</label>
			<div class="col-sm-2">
				<input name="numero" type="text" class="form-control" id="numero">
			</div>
			<label for="tipo" class="col-sm-2 col-form-label">Tipo</label>
			<div class="col-sm-2">
				<input name="tipo" type="text" class="form-control" id="tipo"
					size="4">
			</div>
		</div>
-->
		<button type="submit" class="btn btn-primary" onclick="validar()">Adicionar</button>
	</form>

	<form action="usuarioalterardeletar" method="get" onsubmit="return checarRadioButton();">
		<table class="table">
			<th>X</th>
			<th>ID</th>
			<th>Nome</th>
			<th>Email</th>
			<th>Senha</th>
			<th>Alterar</th>
			<th>Remover</th>

			<c:forEach items="${usuarios}" var="usu">
				<tr>
					<td><input type="radio" name="radio" value="${usu.id}" /></td>
					<td>${usu.id}</td>
					<td>${usu.nome}</td>
					<td>${usu.email}</td>
					<td>${usu.senha}</td>
					<td>
						<button type="submit" name="ACTION" value="ALTERAR" >
							Alterar</button>
					</td>
					<td>
						<button  type="submit" name="ACTION" value="REMOVER" >
							Remover</button>
					</td>
					<td></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>