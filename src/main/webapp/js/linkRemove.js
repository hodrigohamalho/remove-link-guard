$(document).ready(function(){
	$('input#link').focus();

	$("#submeter").click(function(){
		submitLink();
	});
	
	$('input#link').keypress(function(event) {
	  if (event.which == '13') {
		  submitLink();
	  }
	});

	$('#url').click(function(){
		$(this).attr('href',$('#novoLink').html());
		window.open(this.href);
		return false;
	});

	$('#link').focus(function(){
		if ($(this).attr('value') == 'Insira seu link aqui'){
			$(this).attr('value', ' ');
		}
	});

	$('#link').blur(function(){
		if ($(this).attr('value') == ' '){
			$(this).attr('value', 'Insira seu link aqui');
		}
	});

	// Se o browser for i.e, remove a classe dos botoes
	if ( $.browser.msie ) {
		$("#submeter").removeClass();
		$("#send_suggestion").removeClass();
	}
});

function submitLink(){
	var link = $("#link").attr('value');

	$.ajax({
		url: "removeLink.do",
		type: 'POST',
		data: "link="+link,
		beforeSend: function(){
			$("#novoLink").html("atualizando...");
		},
		success: function(data){
			$("#novoLink").html(data);
		}
	});
}