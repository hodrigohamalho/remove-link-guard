$(document).ready(function(){
	$("#submeter").click(function(){
		
		var link = $("#link").attr('value');
		
		$.ajax({
			url: "removerLink.do",
			type: 'POST',
			data: "link="+link,
			beforeSend: function(){
				$("#novoLink").html("atualizando...");
			},
			success: function(data){
				$("#novoLink").html(data);
			}
		});
	});
});