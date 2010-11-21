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
});