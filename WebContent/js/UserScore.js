$(document).ready(function(){
	$("#button").click(function(){
		if(confirm("提示：您确定要离开考试系统吗？")){
			window.location.href="Index.jsp";
		}
	});
});