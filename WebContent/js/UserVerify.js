	$(document).ready(function(){
	
		$("#yes").click(function(){
			setInterval(function getTime() {
				$.ajax({
					url:"UserVerifyServert?action=verify",
					type:"post",
					dataType:"json",
					success:function(data){
						if(data.p_state == "等待考试"){
							$("#divyes").html("等待考试中...");
						}else if(data.p_state == "考试中"){
							window.location.href="UserManage.jsp";
						}
					}
				});
			},1000)
	
		});
	
	});