<!DOCTYPE	html>
<html>
<head>
	<title>Anais de Congresso</title>
	<meta charset="utf-8">
	<link type="text/css" href="resources/css/estilo.css" rel="stylesheet" type="text/css"/"> 
</head>
<body>
	<div class="container"> 
		
		<form id = formulario action="" method="post">

			<h3>Cadastro Anais de Congresso</h3>

			Tipo:
			<INPUT TYPE="RADIO" NAME="OPCAO" VALUE="artigo"> Artigo
			<INPUT TYPE="RADIO" NAME="OPCAO" VALUE="resumo"> Resumo
			<INPUT TYPE="RADIO" NAME="OPCAO" VALUE="poster"> Poster

			<fieldset>
				<input placeholder="Titulo" type="text" tabindex="1" required>
			</fieldset>

			<fieldset>
				<input placeholder="Autor" type="text" tabindex="2" required>
			</fieldset>

			<fieldset>
				<input placeholder="Nome do Congresso" type="text" tabindex="3" required>
			</fieldset>

			Data Publicação:
			<input type="date">

			<fieldset>
				<input placeholder="Local do Evento	" type="text" tabindex="4" required>
			</fieldset>

			<fieldset>
				<button name="salvar" type="submit" id="salvar-submit">Salvar</button>
			</fieldset>
		</form>

	</div>
</body>
</html>