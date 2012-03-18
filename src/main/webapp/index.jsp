<html>

<head>
	<title>Remove Protetores de Link</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
	<meta http-equiv="Content-Type" content="text/html;charset=ISO8859-1" >
	<meta name="description" content="Remover protetor de link. Baixar sem precisar cadastrar celular. Remover Protetor de Link. Burlar protetor de link." />
	<meta name="keywords" content="desproteger link, remove protetor de link, remover link protegido, protetor de url, burlar protetor de link, baixar sem precisar cadastrar celular." />
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/linkRemove.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/suggestion.js" type="text/javascript"></script>
</head>

<body>
	
	<div class="box">
		<a href="http://github.com/hodrigohamalho/remove-link-guard">
			<img id="forkme" src="<%=request.getContextPath()%>/images/forkme_left_grey.png" alt="Fork me on GitHub" />
		</a>
		
		<div id="msg_error" style="display: none"></div>
		<div id="msg_notice" style="display: none"></div>
		
		<div id="inputs">
			<table>
				<tr>
					<td width="40%">
						<a href="http://www.jspace.com.br/link">
							<img alt="remover protetor de link" id="logo" src="<%=request.getContextPath()%>/images/link-me.jpg" align="left"/>
						</a>
					</td>
					<td>
						<h3>
							Tentando fazer download e sendo barrado por aqueles "protetores de link" 
							irritantes?
						</h3>
						<h3>
							Insira a url com o protetor de link abaixo, e esse será removido 
							para que você possa continuar com o download.
						</h3>
						<p class="version">
							Versão 2.6
						</p>
						<div id="donation">
							<form action="https://www.paypal.com/cgi-bin/webscr" method="post">
								<input type="hidden" name="cmd" value="_s-xclick">
								<input type="hidden" name="hosted_button_id" value="MSUGUFHLA79VS">
								<input type="image" src="https://www.paypal.com/pt_BR/i/btn/btn_donate_LG.gif" border="0" name="submit" alt="PayPal - A maneira mais fácil e segura de efetuar pagamentos on-line!">
								<img alt="" border="0" src="https://www.paypal.com/pt_BR/i/scr/pixel.gif" width="1" height="1">
							</form>
						</div>
					</td>
				</tr>
			</table>
			<input type="text" name="link" id="link" value="Insira seu link aqui" />
			
			<button id="submeter" class="slick-black">Converter</button>

			<a href="" id="url" > <span id="novoLink"> </span> </a>
			
			<div id="bottom">
				<button class="slick-back sendme" style="cursor: pointer;">Não funcionou? Clique aqui e envie seu link/sugestão, para melhorarmos nossa app :)</button>
				
				<div id='erro'>
					<input type="text" id="email" name="email" value="Seu email aqui" size="60%" class="suggestion"/><br/>
					<textarea id="suggestion" rows="5" cols="60%" name="suggestion" class="suggestion">Sua sugestao aqui</textarea><br/>
					
					<img alt="ajax loader" id="load" src="images/ajax-loader.gif" />
					<button id="send_suggestion" class="slick-black" style="width: 70px; font-size: 14px; margin-top: 3px;">Enviar</button>
				</div>
				
				<div id="midia">
					<div id="facebook" >
						<iframe src="http://www.facebook.com/plugins/like.php?href=http://jspace.com.br/link&layout=standard&
		show_faces=false&width=380&action=like&colorscheme=light&height=25&locale=pt_BR" scrolling="no" height="30" frameborder="0" style="border:none; allowtransparency='true'">
						</iframe>
					</div>
					
					<div id="twitter">
						<a href="http://twitter.com/share" class="twitter-share-button" data-text="Acabei de fazer um download sossegado, graças ao desprotetor de links ;) #recomendo" data-count="vertical" data-via="hodrigohamalho">Tweet</a><script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
					</div>
					
					<div class="clear"></div>
				</div>
			</div>
		</div>
	</div>
	
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
