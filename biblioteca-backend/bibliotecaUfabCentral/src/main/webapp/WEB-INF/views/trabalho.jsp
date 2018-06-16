<!DOCTYPE	html>
<html>
<head>
	<title>Trabalho de Conclusão</title>
	<meta charset="utf-8">
	<link type="text/css" href="resources/css/estilo.css" rel="stylesheet" type="text/css"/"> 
</head>
<body>
	<div class="container"> 
		
		<form id = formulario action="" method="post">

			<h3>Cadastro Trabalho de Conclusão</h3>

			Tipo:
			<INPUT TYPE="RADIO" NAME="OPCAO" VALUE="tcc"> TCC 
			<INPUT TYPE="RADIO" NAME="OPCAO" VALUE="dissertacao"> Dissertação
			<INPUT TYPE="RADIO" NAME="OPCAO" VALUE="tese"> Tese

			<fieldset>
				<input placeholder="Autor" type="text" tabindex="1" required>
			</fieldset>

			<fieldset>
				<input placeholder="Orientador" type="text" tabindex="2" required>
			</fieldset>

			<fieldset>
				<input placeholder="Título" type="text" tabindex="3" required>
			</fieldset>

			Data de Defesa:
			<input type="date" tabindex="3" required>

			<fieldset>
				<input placeholder="Local da Defesa	" type="text" tabindex="4" required>
			</fieldset>

			<fieldset>
				<button name="salvar" type="submit" id="salvar-submit">Salvar</button>
			</fieldset>
		</form>

	</div>
</body>
</html>