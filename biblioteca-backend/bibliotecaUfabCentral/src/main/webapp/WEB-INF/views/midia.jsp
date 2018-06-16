<!DOCTYPE	html>
<html>
<head>
	<title>Mídia eletrônica</title>
	<meta charset="utf-8">
	<link type="text/css" href="resources/css/estilo.css" rel="stylesheet" type="text/css"/"> 
</head>
<body>
	<div class="container"> 
		
		<form id = formulario action="" method="post">

			<h3>Cadastro Mídia Eletrônica</h3>

			Tipo:
			<INPUT TYPE="RADIO" NAME="OPCAO" VALUE="artigo"> CD
			<INPUT TYPE="RADIO" NAME="OPCAO" VALUE="resumo"> DVD

			<fieldset>
				<input placeholder="Titulo" type="text" tabindex="1" required>
			</fieldset>

			Data Publicação:
			<input type="date" tabindex="2" required>

			<fieldset>
				<button name="salvar" type="submit" id="salvar-submit">Salvar</button>
			</fieldset>
		</form>

	</div>
</body>
</html>