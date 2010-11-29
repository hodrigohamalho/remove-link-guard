<html>

<head>
	<script src="<%=request.getContextPath()%>/js/jquery.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/linkRemove.js" type="text/javascript"></script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
	<meta http-equiv="Content-Type" content="text/html;charset=ISO8859-1" >
</head>

<body>
	<div class="box">
		<div id="inputs">
			<img alt="remove link" src="images/link-me.jpg" align="left" />
			<p>Esta aplicação remove o protetor de link da url.</p>
			<p>
				Exemplo: Você vai baixar o seu filme/seriado favorito e quando 
				clica no link abre aquela maldita página "Cadastre o seu celular..."<br/> 
				Para contornar esse problema basta colocar a url dessa página no campo 
				abaixo que será gerado o link direto para o download.
			</p>
			<input type="text" name="link" id="link" value="Insira seu link aqui" />
			
			<button id="submeter" class="slick-black">Converter</button>
			
			<a href="" id="url" > <span id="novoLink"> </span> </a>
		</div>
	</div>
</body>

</html>
