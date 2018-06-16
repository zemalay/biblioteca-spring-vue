<!DOCTYPE	html>
<html>
<head>
	<title>Revista</title>
	<meta charset="utf-8">
	<link type="text/css" href="resources/css/estilo.css" rel="stylesheet" type="text/css"/"> 
</head>
<body>
	<div class="container"> 
		
		<form id = formulario action="" method="post">

			<h3>Cadastro Revista</h3>

			<fieldset>
				<input placeholder="Titulo" type="text" tabindex="1" required>
			</fieldset>

			<fieldset>
				<input placeholder="Editora" type="text" tabindex="2" required>
			</fieldset>

			Data Publicação:
			<input type="date" tabindex="2" required>

			<fieldset>
				<input placeholder="Edição" type="number" tabindex="3" required>
			</fieldset>

			<fieldset>
				<input placeholder="Num. de Páginas" type="number" tabindex="4" required>
			</fieldset>

			<fieldset>
				<button name="salvar" type="submit" id="salvar-submit">Salvar</button>
			</fieldset>
		</form>

	</div>
</body>
</html>