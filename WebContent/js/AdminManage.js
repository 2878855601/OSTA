$(document).ready(function(){
	//判断是否有选择导入的文件
	$("#toLead").click(function(){
		if(document.getElementById("path").value == ""){
			alert("请选择您要导入的文件路径");
		}else{
			document.getElementById("divbig").style.display ="block"; 
			document.getElementById("divshow").style.display ="block"; 
		}
	});
	//文件上传并显示考试信息
	$("#sub").click(function(){
		document.getElementById("divbig").style.display ='none'; 
		document.getElementById("divshow").style.display ='none'; 
		//获取from标签内容
		var from = new FormData(document.getElementById("form1"));
		var pwd = document.getElementById("pwd").value;
		$.ajax({
			url:"AdminManageServert?action=toLead&pwd="+pwd,
			type:"post",
			//将获取的from标签内容都提交
			data:from,
			processData:false,
			contentType:false,
			dataType:"json",
			success:function(back){
				$("#name").html(back.bean.p_name);
				$("#no").html(back.bean.p_no);
				$("#time").html(back.bean.p_time);
				$("#type").html(back.bean.p_type);
				$("#work").html(back.bean.p_work);
				$("#institution").html(back.bean.p_institution);
				$("#grade").html(back.bean.p_grade);
				$("#score").html(back.bean.p_score);
				$("#count").html(back.count);
				document.getElementById("preview").style.display ="block";
				document.getElementById("preuser").style.display ="block";
				document.getElementById("yes").style.display ="block";
			},
			error:function(){
				alert("错误");
			}
		});
	});
	//预览考生信息
	$("#preuser").click(function(){
		$.ajax({
			url:"AdminManageServert?action=user",
			type:"post",
			dataType:"json",
			success:function(back){
				$("#tableUserr").find("td").remove();
				for(var i = 0;i < back.tbUserBean.length;i++){
					var tr = $("<tr></tr>");
					var td0 = $("<td>"+(i+1)+"</td>");
					var td1 = $("<td>"+back.tbUserBean[i].u_name+"</td>");
					var td2 = $("<td>"+back.tbUserBean[i].u_id+"</td>");
					var td3 = $("<td>"+back.tbUserBean[i].u_no+"</td>");
					var td4 = $("<td>"+back.paperBean.p_name+"</td>");
					var td5 = $("<td>"+back.paperBean.p_grade+"</td>");
					var td6 = $("<td>"+back.tbUserBean[i].u_total_points+"</td>");
					tr.append(td0);
					tr.append(td1);
					tr.append(td2);
					tr.append(td3);
					tr.append(td4);
					tr.append(td5);
					tr.append(td6);
					$("#tableUserr").append(tr);
				}
			},
			error:function(){
				alert("错误");
			}
		});
		document.getElementById("divbogtop").style.display ="block";
		document.getElementById("divmain").style.display ='none'; 
	});
	//返回
	$("#useryes").click(function(){
		document.getElementById("divmain").style.display ='block'; 
		document.getElementById("divbogtop").style.display ="none";
	});
	//试卷预览
	$("#preview").click(function(){
		$.ajax({
			url:"AdminManageServert?action=paper",
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
					var tr5 = $("<tr><td><input type='radio' name=" + data.singleChoiceList[i].i_no + " />" + "A"+
							"<input type='radio' name=" + data.singleChoiceList[i].i_no + " />" + "B"+
							"<input type='radio' name=" + data.singleChoiceList[i].i_no + " />" + "C"+
							"<input type='radio' name=" + data.singleChoiceList[i].i_no + " />" + "D"+
							"</tr></td>");
					$("#tableItemBank").append(tr5);
					var div = $("<div id='divth'><a href='#tr" + no + "'>"+no+"</div>")
					$("#divdtk").append(div);
				}
				var h2 = $("<tr><td><strong>" + data.bean.p_multiselect + "</strong></td></tr>")
				$("#tableItemBank").append(h2);
				for(var i = 0;i < data.multipChoiceList.length; i++){
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
					var tr5 = $("<tr><td><input type='checkbox' name=" + data.multipChoiceList[i].i_no + " />" + "A"+
							"<input type='checkbox' name=" + data.multipChoiceList[i].i_no + " />" + "B"+
							"<input type='checkbox' name=" + data.multipChoiceList[i].i_no + " />" + "C"+
							"<input type='checkbox' name=" + data.multipChoiceList[i].i_no + " />" + "D"+
							"</tr></td>");
					$("#tableItemBank").append(tr5);
					var div = $("<div id='divth'><a href='#tr" + no + "'>"+no+"</div>")
					$("#divdtk").append(div);
				}
			},
			error:function(){
				alert("失败");
			}
		});
		document.getElementById("divstyl").style.display ="block";
		document.getElementById("divmain").style.display ='none'; 
	});
	//返回
	$("#pyes").click(function(){
		document.getElementById("divmain").style.display ='block'; 
		document.getElementById("divstyl").style.display ="none";
	});
	//确认考试信息
	$("#yes").click(function(){
		window.location.href="AdminManageServert?action=ok";
	});
});