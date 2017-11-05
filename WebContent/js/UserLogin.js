$(document).ready(function(){

	window.onload = function(){
		$.ajax({
			url:"UserLoginServert?action=load",
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.p_state == "考试结束"){
					confirm("提示：考试已结束");
					window.location.href="Index.jsp";
				}else{
					document.getElementById("sel").length = 1;
					var oop = document.createElement("option");
					oop.innerText = data.p_name;
					document.getElementById("sel").appendChild(oop);
				}
			}
		});
	}

	/**对考生端账号进行验证*/
	$("#uno").blur(function(){
		var uno = document.getElementById("uno").value;
		if(uno == ""){
			document.getElementById("hint").innerHTML = '*准考证号不能为空';
			$("#yes").attr('disabled',true);
		}else{
			document.getElementById("hint").innerHTML = "",
			$("#yes").attr('disabled',false);
		}
	});
	/**对考生身份证号码进行验证*/
	$("#uid").blur(function(){
		var uid = document.getElementById("uid").value;
		if(uid.length != 18){
			document.getElementById("hint").innerHTML = "*请输入正确的身份证号码";
			$("#yes").attr('disabled',true);
		}else{
			document.getElementById("hint").innerHTML = "";
			$("#yes").attr('disabled',false);
		}
	});
	/**对考生名进行验证*/
	$("#uname").blur(function(){
		var uname = document.getElementById("uname").value;
		if(uname == ""){
			document.getElementById("hint").innerHTML = "*姓名不得为空";
			$("#yes").attr('disabled',true);
		}else{
			document.getElementById("hint").innerHTML = "";
			$("#yes").attr('disabled',false);
		}
	});

	$("#yes").click(function(){
		var pname = document.getElementById("sel").value;
		var uno = document.getElementById("uno").value;
		var uid = document.getElementById("uid").value;
		var uname = document.getElementById("uname").value;
		if(pname == "--请选择本场考试名称--"){
			document.getElementById("hint").innerHTML = "*请选择本场考试名称";
			$("#yes").attr('disabled',false);
		}else if(uno == ""){
			document.getElementById("hint").innerHTML = '*准考证号不能为空';
			$("#yes").attr('disabled',false);
		}else if(uid.length != 18){
			document.getElementById("hint").innerHTML = "*请输入正确的身份证号码";
			$("#yes").attr('disabled',false);
		}else if(uname == ""){
			document.getElementById("hint").innerHTML = "*姓名不得为空";
			$("#yes").attr('disabled',false);
		}else{
			document.getElementById('from1').submit();
		}
	});
});