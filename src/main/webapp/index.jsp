<html>

<head>
	<script src="<%=request.getContextPath()%>/js/jquery.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/linkRemove.js" type="text/javascript"></script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
	<meta http-equiv="Content-Type" content="text/html;charset=ISO8859-1" >
</head>

<body>
	
	<div class="box">
		<a href="http://github.com/hodrigohamalho/remove-link-guard">
			<img id="forkme" src="<%=request.getContextPath()%>/images/forkme_left_grey.png" alt="Fork me on GitHub" />
		</a>
		<div id="inputs">
			<img alt="remove link" src="images/link-me.jpg" align="left" />
			
			<h3>
				Tentando fazer download e sendo barrado por aqueles "protetores de link" 
				irritantes?
			</h3>
			<h3>
				Insira a url com o protetor de link abaixo, e o protetor de link será removido 
				para que você possa continuar com o download.
			</h3>
			<input type="text" name="link" id="link" value="Insira seu link aqui" />
			
			<button id="submeter" class="slick-black">Converter</button>
			
			<a href="" id="url" > <span id="novoLink"> </span> </a>
		</div>
	</div>
	
</body>

</html>
