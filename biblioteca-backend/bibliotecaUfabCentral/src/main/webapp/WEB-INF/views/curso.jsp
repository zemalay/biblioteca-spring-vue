<!DOCTYPE	html>
<html>
<head>
	<title>Curso</title>
	<meta charset="utf-8">
	<link type="text/css" href="resources/css/estilo.css" rel="stylesheet" type="text/css"/"> 
</head>
<body>
	<div class="container"> 
		
		<form id = formulario action="" method="post">

			<h3>Cadastro Curso</h3>

			Tipo:
			<INPUT TYPE="RADIO" NAME="OPCAO" VALUE="graduacao"> Graduação 
			<INPUT TYPE="RADIO" NAME="OPCAO" VALUE="especializacao"> Especialização
			<INPUT TYPE="RADIO" NAME="OPCAO" VALUE="posgraduacao"> Pós-graduação

			<fieldset>
				<input placeholder="Nome" type="text" tabindex="1" required>
			</fieldset>

			<fieldset>
				<input placeholder="Área do Curso" type="text" tabindex="2" required>
			</fieldset>

			<fieldset>
				<input placeholder="Sigla" type="text" tabindex="3" required>
			</fieldset>

			<fieldset>
				<button name="salvar" type="submit" id="salvar-submit">Salvar</button>
			</fieldset>
		</form>

	</div>
</body>
</html>