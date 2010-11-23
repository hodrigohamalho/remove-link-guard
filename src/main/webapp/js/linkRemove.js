$(document).ready(function(){
	$("#submeter").click(function(){
		
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
});