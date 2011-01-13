<html>

<head>
	<title>Remove Protetor de Link</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
	<meta http-equiv="Content-Type" content="text/html;charset=ISO8859-1" >
	<meta name="description" content="Remover protetor de link. Baixar sem precisar cadastrar celular. Remover Protetor de Link. Burlar protetor de link." />
	<meta name="keywords" content="desproteger link, remove protetor de link, remover link protegido, protetor de url, burlar protetor de link, baixar sem precisar cadastrar celular." />
</head>

<body>
	
	<div class="box">
		<a href="http://github.com/hodrigohamalho/remove-link-guard">
			<img id="forkme" src="<%=request.getContextPath()%>/images/forkme_left_grey.png" alt="Fork me on GitHub" />
		</a>
		
		<div id="inputs">
			<table>
				<tr>
					<td width="40%">
						<a href="http://www.jspace.com.br/link">
							<img alt="remover protetor de link" id="logo" src="images/link-me.jpg" align="left"/>
						</a>
					</td>
					<td>
						<h3>
							Tentando fazer download e sendo barrado por aqueles "protetores de link" 
							irritantes?
						</h3>
						<h3>
							Insira a url com o protetor de link abaixo, e o protetor de link será removido 
							para que você possa continuar com o download.
						</h3>
					</td>
				</tr>
			</table>
			<input type="text" name="link" id="link" value="Insira seu link aqui" />
			
			<button id="submeter" class="slick-black">Converter</button>
			
			<a href="" id="url" > <span id="novoLink"> </span> </a>
			
			<p class="sendme">Não funcionou? Envie seu link/sugestão, para melhorarmos nossa app :)</p>
			<span id="sug_msg"></span>	
			
			<div id='erro'>
				<textarea id="suggestion" rows="5" cols="60%"></textarea><br/>
				<img alt="ajax loader" id="load" src="images/ajax-loader.gif" />
				<button id="send_suggestion" class="slick-black" style="width: 70px; font-size: 14px; margin-top: 3px;">Enviar</button>
			</div>
		</div>
	</div>
	
	<script src="<%=request.getContextPath()%>/js/jquery.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/linkRemove.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/suggestion.js" type="text/javascript"></script>
	<script type="text/javascript">
	  var _gaq = _gaq || [];
	  _gaq.push(['_setAccount', 'UA-20624035-1']);
	  _gaq.push(['_trackPageview']);
	
	  (function() {
	    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
	    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
	    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
	  })();
	</script>	
</body>

</html>
