$(document).ready(function(){
	$('#erro').hide();

	$(".sendme").click(function(){
		$('#erro').show("slow");
	});
	
	$("#load").hide();
	
	$("#email").focus(function(){
		$(this).removeClass();
		$(this).attr('value', '');
	});
	
	$("#suggestion").focus(function(){
		$(this).removeClass();
		$(this).attr('value', '');
	});

	$("#send_suggestion").click(function(){
		var params = [];
		params['email'] = $("input#email").attr('value');
		params['suggestion'] = $("textarea#suggestion").attr('value');
		
		$.ajax({
			url: "suggestion.do",
			type: 'POST',
			data: "suggestion="+params['suggestion']+"&email="+params['email'],
			beforeSend: function(){
				$("#load").show();
				$("#send_suggestion").hide("slow");
			},
			success: function(data){
				$("#load").hide();
				$("#suggestion").val('');
				$("#send_suggestion").show();
				
				jQuery("#msg_notice").html("Email enviado com sucesso").slideDown("slow").delay(3000).slideUp("slow", function(){
					jQuery(this).html("");
				}); 
				$('#erro').hide("slow");
			},
			error: function(jqXHR, textStatus, errorThrown){
				$("#send_suggestion").show("slow");
				$("#load").hide();
				
				jQuery("#msg_error").html("Campo email e sugest&atilde;o obrigat&oacute;rios").slideDown("slow").delay(3000).slideUp("slow", function(){
					jQuery(this).html("");
				}); 
			}
		});
	});
});