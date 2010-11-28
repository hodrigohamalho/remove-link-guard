<html>

<head>
	<script src="<%=request.getContextPath()%>/js/jquery.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/linkRemove.js" type="text/javascript"></script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
</head>

<body>
	<div class="box">
		<div id="inputs">
			<img alt="remove link" src="images/link-me.jpg" align="left" />
			<input type="text" name="link" id="link" value="Insira seu link aqui" />
			
			<input type="submit" id="submeter" value="Converter" class="button black"/>
			
			<br />	
			<a href="" id="url" > <span id="novoLink"> </span> </a>
		</div>
	</div>
</body>

</html>
