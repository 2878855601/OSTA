
function answer(ino){
	var i_no=ino + ".0";
	var uno = $("#uno1").html();
	var radioButton = document.getElementsByName(ino);
	var mycars = new Array();
	var j = 0;
	for (var i=0;i<radioButton.length;i++) {
		if (radioButton[i].type == "radio" || radioButton[i].type == "checkbox") {
			if(radioButton[i].checked) {
				mycars[j] = radioButton[i].value;
				j++;
			}
		}
	}
	$.ajax({
		url:"UserVerifyServert?action=answer&ino=" + i_no + "&answe=" + mycars + "&uno=" + uno,
		type:"post",
		dataType:"json",
		success:function(data){
			if(data == 1){
				$("#th" + ino).css("background-color","blue");
			}
		},
		error:function(){
			alert("失败");
		}
	});
}


$(document).ready(function(){

	window.onload = function(){
		var userno = $("#uno1").html();
		$.ajax({
			url:"AdminManageServert?action=paper&userno="+userno,
			type:"post",
			dataType:"json",
			success:function(data){
				$("#tableItemBank").find("tr").remove();
				$("#pname").html(data.bean.p_name);
				var no = 0;
				var h1 = $("<tr><td><strong>" + data.bean.p_radio + "</strong></tr></td>")
				$("#tableItemBank").append(h1);
				for(var i = 0;i < data.singleChoiceList.length; i++){
					no = no + 1;
					var sino = parseInt(data.singleChoiceList[i].i_no);
					var tr = $("<tr id='tr" + no + "'><td>" + no + "、" + data.singleChoiceList[i].i_content + "</td></tr>");
					$("#tableItemBank").append(tr);
					var tr1 = $("<tr><td>" + "A、" + data.singleChoiceList[i].i_option_A + "</td></tr>");
					$("#tableItemBank").append(tr1);
					var tr2 = $("<tr><td>" + "B、" + data.singleChoiceList[i].i_option_B + "</td></tr>");
					$("#tableItemBank").append(tr2);
					var tr3 = $("<tr><td>" + "C、" + data.singleChoiceList[i].i_option_C + "</td></tr>");
					$("#tableItemBank").append(tr3);
					var tr4 = $("<tr><td>" + "D、" + data.singleChoiceList[i].i_option_D + "</td></tr>");
					$("#tableItemBank").append(tr4);
					var tr5 = $("<tr><td><input type='radio' name=" + sino + " value='A'  onchange='answer("+ data.singleChoiceList[i].i_no +")'  />" + "A"+
							"<input type='radio' name=" + sino + " value='B'   onchange='answer("+ data.singleChoiceList[i].i_no +")'  />" + "B"+
							"<input type='radio' name=" + sino + " value='C'   onchange='answer("+ data.singleChoiceList[i].i_no +")'  />" + "C"+
							"<input type='radio' name=" + sino + " value='D'   onchange='answer("+ data.singleChoiceList[i].i_no +")'  />" + "D"+
					"</tr></td>");
					$("#tableItemBank").append(tr5);
					var no1 = parseInt(data.singleChoiceList[i].i_no);
					var div = $("<div id='th" + no1 + "' style='width: 40px;height: 40px; border: #000 1px solid; float: left;text-align:center;'><a href='#tr" + no + "'>"+no+"</div>")
					$("#divdtk").append(div);
				}
				var h2 = $("<tr><td><strong>" + data.bean.p_multiselect + "</strong></td></tr>")
				$("#tableItemBank").append(h2);
				for(var i = 0;i < data.multipChoiceList.length; i++){
					var mino = parseInt(data.multipChoiceList[i].i_no);
					no = no + 1;
					var tr = $("<tr id='tr" + no + "'><td>" + no + "、" + data.multipChoiceList[i].i_content + "</td></tr>");
					$("#tableItemBank").append(tr);
					var tr1 = $("<tr><td>" + "A、" + data.multipChoiceList[i].i_option_A + "</td></tr>");
					$("#tableItemBank").append(tr1);
					var tr2 = $("<tr><td>" + "B、" + data.multipChoiceList[i].i_option_B + "</td></tr>");
					$("#tableItemBank").append(tr2);
					var tr3 = $("<tr><td>" + "C、" + data.multipChoiceList[i].i_option_C + "</td></tr>");
					$("#tableItemBank").append(tr3);
					var tr4 = $("<tr><td>" + "D、" + data.multipChoiceList[i].i_option_D + "</td></tr>");
					$("#tableItemBank").append(tr4);
					var tr5 = $("<tr><td><input type='checkbox' name=" + mino + " value='A'  onchange='answer(" + data.multipChoiceList[i].i_no + ")' />" + "A"+
							"<input type='checkbox' name=" + mino + " value='B'  onchange='answer(" + data.multipChoiceList[i].i_no + ")'/>" + "B"+
							"<input type='checkbox' name=" + mino + " value='C'  onchange='answer(" + data.multipChoiceList[i].i_no + ")'/>" + "C"+
							"<input type='checkbox' name=" + mino + " value='D'  onchange='answer(" + data.multipChoiceList[i].i_no + ")'/>" + "D"+
					"</tr></td>");
					$("#tableItemBank").append(tr5);
					var no2 = parseInt(data.multipChoiceList[i].i_no);
					var div = $("<div id='th" + no2	 + "' class='divth'><a href='#tr" + no + "'>"+no+"</div>")
					$("#divdtk").append(div);
				}
				for(var i = 0;i < data.resBean.length;i++){
					var daan = data.resBean[i].r_answer;
					var ino = parseInt(data.resBean[i].i_no);
					for(var j = 0;j < daan.split(",").length;j++){
						var rque = daan.split(",")[j];
						$("input[name="+ino+"][value="+ rque +"]").attr("checked","checked");
						$("#th" + ino).css("background-color","blue");
						var th = document.getElementsByName(ino);
					}
				}
			},
			error:function(){
				alert("失败");
			}
		});


		setInterval( function getTime() {
			var userno = $("#uno1").html();
			var cunt = 0;
			$.ajax({
				url:"UserManageServert?action=downTime&uno="+userno,
				type:"post",
				dataType:"json",
				success:function(data){
					$("#divtime").html(data.paperBean.p_sount_down);
					if(data.userBean.u_static == "已交卷"){
						submit();
					}else if(data.userBean.u_static == "作弊"){
						confirm("提示：由于您违反考试纪律，考试结束！");
						submit();
					}else if(data.paperBean.p_state == "考试暂停"){
						document.getElementById("divzt").style.display ="block";
						document.getElementById("divstyl").style.display ='none'; 
					}else if(data.paperBean.p_state == "考试中"){
						document.getElementById("divstyl").style.display ="block";
						document.getElementById("divzt").style.display ='none'; 
					}else if(data.paperBean.p_state == "违纪" && cunt == 0){
						confirm("提示：请注意考场纪律！");
						cunt++;
					}else if(data.paperBean.p_state == "考试结束"){
						confirm("提示：考试已结束！");
						submit();
					}
				}
			});
		},1000);
	}	

	$("#jiaojuan").click(function(){
		if(confirm("提示：请您确认答题信息，一旦交卷，无法继续考试！")){
			submit();
		}
	});

	function submit(){
		var uno = $("#uno1").html();
		window.location.href="UserManageServert?action=submit&uno="+uno;
	}
});
