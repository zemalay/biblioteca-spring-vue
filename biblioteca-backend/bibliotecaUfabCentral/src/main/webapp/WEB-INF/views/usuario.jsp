<!DOCTYPE	html>
<html>
<head>
	<title>Usuario</title>
	<meta charset="utf-8">
	<link type="text/css" href="resources/css/estilo.css" rel="stylesheet" type="text/css"/"> 
</head>
<body>
	<div class="container"> 
		
		<form id = formulario action="" method="post">

			<h3>Cadastro Usuário</h3>

			Tipo:
			<INPUT TYPE="RADIO" NAME="OPCAO" VALUE="operador"> Operador 
			<INPUT TYPE="RADIO" NAME="OPCAO" VALUE="administrador"> Administrador

			<fieldset>
				<input placeholder="CPF	" type="text" tabindex="1" required>
			</fieldset>

			<fieldset>
				<input placeholder="Nome Completo" type="text" tabindex="2" required>
			</fieldset>

			<fieldset>
				<input placeholder="RG" type="text" tabindex="3" required>
			</fieldset>

			<fieldset>
				<input placeholder="Naturalidade" type="text" tabindex="4" required>
			</fieldset>

			<fieldset>
				<input placeholder="Endereço" type="text" tabindex="5" required>
			</fieldset>

			<fieldset>
				<input placeholder="Telefone" type="tel" tabindex="6" required>
			</fieldset>

			<fieldset>
				<input placeholder="E-mail" type="e-mail" tabindex="7" required>
			</fieldset>

			<fieldset>
				<input placeholder="Nome do Usuário" type="text" tabindex="8" required>
			</fieldset>

			<fieldset>
				<input placeholder="Senha" type="password" tabindex="8" required>
			</fieldset>

			<fieldset>
				<button name="salvar" type="submit" id="salvar-submit">Salvar</button>
			</fieldset>
		</form>

	</div>
</body>
</html>