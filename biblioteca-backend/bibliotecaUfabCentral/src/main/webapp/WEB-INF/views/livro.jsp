<!DOCTYPE	html>
<html>
<head>
	<title>Livro</title>
	<meta charset="utf-8">
	<link type="text/css" href="resources/css/estilo.css" rel="stylesheet" type="text/css"/"> 
</head>
<body>
	<div class="container"> 
		
		<form id = formulario action="" method="post">

			<h3>Cadastro Livro</h3>

			<fieldset>
				<input placeholder="ISBN" type="text" tabindex="1" required>
			</fieldset>

			<fieldset>
				<input placeholder="Titulo" type="text" tabindex="2" required>
			</fieldset>

			<fieldset>
				<input placeholder="Autor" type="text" tabindex="3" required>
			</fieldset>

			<fieldset>
				<input placeholder="Editora" type="text" tabindex="3" required>
			</fieldset>

			Data publicação:
			<input type="date" tabindex="4" required>

			<fieldset>
				<input placeholder="Edição" type="number" tabindex="5" required>
			</fieldset>

			<fieldset>
				<input placeholder="Num. Página" type="number" tabindex="6" required>
			</fieldset>

			<fieldset>
				<input placeholder="Área do conhecimento" type="text" tabindex="6" required>
			</fieldset>

			<fieldset>
				<input placeholder="Tema" type="text" tabindex="7" required>
			</fieldset>

			<fieldset>
				<button name="salvar" type="submit" id="salvar-submit">Salvar</button>
			</fieldset>
		</form>

	</div>
</body>
</html>