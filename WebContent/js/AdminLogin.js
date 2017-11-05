/**
 * 用于处理监考员登陆的网页事件
 */
$(document).ready(function(){
	window.onload = authCode();
	/**通过服务器获取4位字母或数字组成的验证码并显示在界面上*/
	function authCode(){
		$.ajax({
			url:"AdminLoginServert?action=authCode",
			type:"post",
			dataType:"text",
			success:function(data){
				document.getElementById("bttext").value=data;
			}
		});
	}
	/**刷新验证码*/
	$("#bttext").click(function(){
		authCode();
	});
	/**账号框失去焦点时验证账号*/
	$("#pno").blur(function(){
		var pno = document.getElementById("pno").value;
		if(pno == ""){
			document.getElementById('divhint').innerHTML = '*账号不能为空';
			$("#yes").attr('disabled',true);
		}else{
			$.ajax({
				url:"AdminLoginServert?action=pnoCode&pno="+pno,
				type:"post",
				dataType:"text",
				success:function(data){
					if(data == 1){
						document.getElementById('divhint').innerHTML = '';
						$("#yes").attr('disabled',false);
					}else{
						document.getElementById('divhint').innerHTML = '*账号不存在';
						$("#yes").attr('disabled',true);
					}
				}
			});
		}
	});
	/**密码框失去焦点时验证账号*/
	$("#ppwd").blur(function(){
		var ppwd = document.getElementById("ppwd").value;
		if(ppwd == ""){
			document.getElementById('divhint').innerHTML = '*密码不能为空';
			$("#yes").attr('disabled',true);
		}else if(ppwd.length != 6){
			document.getElementById('divhint').innerHTML = '*请输入正确的密码';
			$("#yes").attr('disabled',true);
		}else{
			document.getElementById('divhint').innerHTML = '';
			$("#yes").attr('disabled',false);
		}
	});
	/**验证框失去焦点时验证验证码*/
	$("#ptext").blur(function(){
		var bttext = $("#bttext").val();
		var ptext = document.getElementById('ptext').value;
		if(ptext == ""){
			document.getElementById('divhint').innerHTML = '*请输入验证码';
			$("#yes").attr('disabled',true);
		}else if(ptext != bttext){
			document.getElementById('divhint').innerHTML = '*验证码输入错误，请重新输入';
			$("#yes").attr('disabled',true);
			authCode();
		}else{
			document.getElementById('divhint').innerHTML = '';
			$("#yes").attr('disabled',false);
		}
	});
	/**点击登录时的验证*/
	$("#yes").click(function(){
		var pno = document.getElementById("pno").value;
		var ppwd = document.getElementById("ppwd").value;
		var ptext = document.getElementById('ptext').value;
		document.getElementById('divhint').innerHTML = '正在登录中...';
		if(pno == ""){
			document.getElementById('divhint').innerHTML = '*账号不能为空';
			$("#yes").attr('disabled',true);
		}else if(ppwd == ""){
			document.getElementById('divhint').innerHTML = '*密码不能为空';
			$("#yes").attr('disabled',true);
		}else if(ptext == ""){
			document.getElementById('divhint').innerHTML = '*请输入验证码';
			$("#yes").attr('disabled',true);
		}else{
			document.getElementById('from1').submit();
		}
	});
});