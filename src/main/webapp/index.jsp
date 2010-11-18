<html>

<head>
	<script src="<%=request.getContextPath()%>/js/jquery.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/linkRemove.js" type="text/javascript"></script>
</head>

<body>
	<h2>Protetor de link é meu saco...</h2>
	
	<span>Insira seu link aqui</span>
	<input type="text" name="link" id="link"/>
	<input type="submit" id="submeter" value="Converter"/>
	
	<br />

	Novo Link: <span id="novoLink"> ... </span>
</body>

</html>
