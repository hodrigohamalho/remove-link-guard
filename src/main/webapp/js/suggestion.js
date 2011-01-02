$(document).ready(function(){
	$('#erro').hide();

	$(".sendme").click(function(){
		$('#erro').show();
	});
	
	$("#load").hide();

	$("#send_suggestion").click(function(){
		var sug = $("textarea#suggestion").val();
		
		$.ajax({
			url: "suggestion.do",
			type: 'POST',
			data: "suggestion="+sug,
			
			beforeSend: function(){
				$("#load").show();
				$("#send_suggestion").hide();
				
			},
			success: function(data){
				$("#load").hide();
				$("#suggestion").val('');
				$("#send_suggestion").show();
				
				$("#sug_msg").html('Email enviado com sucesso');
				$('#erro').hide();
			}
		});
	});
});