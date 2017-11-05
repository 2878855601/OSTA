$(document).ready(function(){

	window.onload = user();
	/**创建考生信息*/
	function user(){
		$.ajax({
			url:"InvigilateServert?action=userMessage",
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.paperBean.p_state == "考试中"){
					beg();
				}
				$("#divtype").html("考试类型：" + data.paperBean.p_type);
				$("#divtime").html("考试时间：" + data.paperBean.p_time);
				$("#divnum").html("考生人数：" + data.tbUserBean.length + "人");
				$("#divgread").html("鉴定级别：" + data.paperBean.p_grade);
				$("#divwork").html("鉴定工作：" + data.paperBean.p_work);
				$("#pname").html(data.paperBean.p_name);
				$("#pstate").html(data.paperBean.p_state);
				$("#pdowntime").html(data.paperBean.p_sount_down);
				for(var i = 0; i<data.tbUserBean.length; i++){
					var div = $("<div id='"+ "div" + data.tbUserBean[i].u_no +"'" +
							"style='width: 170px; height: 110px; margin-top: 15px; margin-left: 15px; border: #000 1px solid; float: left;'> " + 
							"<div style='width: 20px; height: 110px; float: left;'>" +
							"<input type='checkbox' name='checkbox' id='" + data.tbUserBean[i].u_no + "' /></div>" + 
							"<div style='width: 50px; height: 50px; float: left;'></div>" +
							"<div id= 'user"+ data.tbUserBean[i].u_no +"'style='width: 100px; height: 25px; float: left;'>" + data.tbUserBean[i].u_no +"</div>" +
							"<div  style='width: 100px; height: 25px; float: left;'>" + data.tbUserBean[i].u_name +"</div>" +
							"<div style='width: 150px; height: 30px; float: left;'>" +
							"<div style='width: 50px; height: 30px; float: left;'>状态：</div>" +
							"<div id='state" + data.tbUserBean[i].u_no +"' style='width: 100px; height: 30px; float: left;'>" + data.tbUserBean[i].u_static +"</div></div>" +
							"<div style='width: 150px; height: 30px; float: left;'>" +
							"<div style='width: 50px; height: 30px; float: left;'>成绩：</div>" +
							"<div style='width: 100px; height: 30px; float: left;' id='sco" + data.tbUserBean[i].u_no + "'></div></div></div>");
					$("#divstu").append(div);
				}
			}
		});

	}
	/**实时更新监考界面*/
	window.onload = setInterval( function getTime() {
		$.ajax({
			url:"InvigilateServert?action=state",
			type:"post",
			dataType:"json",
			success:function(data){
				$("#pdowntime").html(data.paperBean.p_sount_down);
				$("#pstate").html(data.paperBean.p_state);
				if(data.paperBean.p_state == "考试结束"){
					$("#begin").attr("disabled", true);
					$("#jiaojuan").attr("disabled", true); 
					$("#zuobi").attr("disabled", true); 
					$("#weiji").attr("disabled", true); 
					$("#zanting").attr("disabled", true); 
				}
				for(var i = 0; i<data.tbUserBean.length; i++){
					var stat = "state" + data.tbUserBean[i].u_no;
					var mig = "div" + data.tbUserBean[i].u_no;
					$("#" + stat).html(data.tbUserBean[i].u_static);
					if(data.tbUserBean[i].u_static == "作弊"){
						$("#" + mig).css("background-color","red");
						$("#sco" + data.tbUserBean[i].u_no).html(data.tbUserBean[i].u_total_points);
					}else if(data.tbUserBean[i].u_static == "违纪"){
						$("#" + mig).css("background-color","yellow");
					}else if(data.tbUserBean[i].u_static == "已交卷"){
						$("#" + mig).css("background-color","blue");
						$("#sco" + data.tbUserBean[i].u_no).html(data.tbUserBean[i].u_total_points);
					}else if(data.tbUserBean[i].u_static == "等待考试"){
						$("#" + mig).css("background-color","green");
					}
				}
			}
		});

	},1000);

	/**开始考试操作*/
	$("#begin").click(function(){
		if(confirm("提示：您确定要执行开始考试操作吗？")){
			beg();
		}
	});

	function beg(){
		$("#begin").attr("disabled", true); 
		$.ajax({
			url:"InvigilateServert?action=begin",
			type:"post",
			dataType:"json",
			success:function(data2){
				confirm("提示：考试已开始，请注意考场秩序！")
			},
			error:function(){
				alert("失败");
			}
		});
	}

	/**暂停考试*/
	$("#zanting").click(function(){
		if($("#zanting").val() == "暂停考试"){
			$.ajax({
				url:"InvigilateServert?action=stop",
				type:"post",
				dataType:"json",
				success:function(data1){
					$("#zanting").val("恢复考试");
				},
				error:function(){
					alert("失败");
				}
			});
		}else if($("#zanting").val() == "恢复考试"){
			$.ajax({
				url:"InvigilateServert?action=go",
				type:"post",
				dataType:"json",
				success:function(data1){
					$("#zanting").val("暂停考试");
				},
				error:function(){
					alert("失败");
				}
			});
		}
	});

	/**全选/反选*/
	$("#usercheckbox").click(function(){
		var cbox = document.getElementsByName("checkbox");
		var aa = $("#usercheckbox").attr("checked");
		for(var i = 0; i < cbox.length; i++){
			if(aa != "checked"){
				document.getElementsByName("checkbox")[i].checked = false;
			}else{
				document.getElementsByName("checkbox")[i].checked = true;
			}
		}
	});
	/**作弊处理*/
	$("#zuobi").click(function(){
		var r = confirm("提示：您确定要执行作弊处理吗？");
		if(r){
			var cbox = document.getElementsByName("checkbox");
			for(var i = 0; i < cbox.length; i++){
				if(document.getElementsByName("checkbox")[i].checked == true){
					var userno = cbox[i].getAttribute("id");
					var id = "#state" + userno;
					var state = $(id).html();
					if(state != "作弊"){
						$.ajax({
							url:"InvigilateServert?action=del&uno=" + userno,
							type:"post",
							dataType:"json",
							success:function(data){
								if(data == "1"){
									alert("已进行作弊操作");
								}else{
									alert("失败");
								}
							}
						});
					}else{
						alert("该考生已经进行作弊处理！");
					}
				}
			}
		}
	});
	/**违纪处理*/
	$("#weiji").click(function(){
		var r = confirm("提示：您确定要执行违纪处理吗？");
		if(r){
			var cbox = document.getElementsByName("checkbox");
			for(var i = 0; i < cbox.length; i++){
				var userno = cbox[i].getAttribute("id");
				var id = "#state" + userno;
				var state = $(id).html();
				if(state != "作弊"){
					if(state != "违纪"){
						if(document.getElementsByName("checkbox")[i].checked == true){
							var userno = cbox[i].getAttribute("id");
							$.ajax({
								url:"InvigilateServert?action=weiji&uno=" + userno,
								type:"post",
								dataType:"json",
								success:function(data){
									if(data == "1"){
										alert("已进行违纪操作！");
									}else{
										alert("失败");
									}
								}
							});
						}
					}else{
						alert("该同学已经违纪过！");
					}
				}else{
					alert("该同学已作弊！");
				}
			}
		}
	});
	/**强制交卷处理*/
	$("#jiaojuan").click(function(){
		var r = confirm("提示：您确定要执行强制交卷处理吗？");
		if(r){
			var cbox = document.getElementsByName("checkbox");
			for(var i = 0; i < cbox.length; i++){
				if(document.getElementsByName("checkbox")[i].checked == true){
					var userno = cbox[i].getAttribute("id");
					$.ajax({
						url:"InvigilateServert?action=qiangzhi&uno=" + userno,
						type:"post",
						dataType:"json",
						success:function(data){
							if(data == "1"){
								alert("该考生已经交卷！");
							}
						}
					});
				}
			}
		}
	});

	/**所有人员总成绩列表*/
	$("#daochu").click(function(){
		if(confirm("提示：执行此操作考试将会停止，请确定执行此操作！")){
			$.ajax({
				url:"InvigilateServert?action=totalPoints",
				type:"post",
				dataType:"json",
				success:function(data){
					$("#ctable").find("td").remove();
					for(var i = 0;i < data.tbUserBean.length;i++){
						var tr = $("<tr></tr>");
						var td0 = $("<td>"+data.tbUserBean[i].u_no+"</td>");
						var td1 = $("<td>"+data.tbUserBean[i].u_name+"</td>");
						var td2 = $("<td>"+data.paperBean.p_no+"</td>");
						var td3 = $("<td>"+data.paperBean.p_name+"</td>");
						var td4 = $("<td>"+data.paperBean.p_work+"</td>");
						var td5 = $("<td>"+data.paperBean.p_grade+"</td>");
						var td6 = $("<td>"+data.tbUserBean[i].u_total_points+"</td>");
						tr.append(td0);
						tr.append(td1);
						tr.append(td2);
						tr.append(td3);
						tr.append(td4);
						tr.append(td5);
						tr.append(td6);
						$("#ctable").append(tr);
					}
				}
			});
			document.getElementById("divmain1").style.display ="block";
			document.getElementById("divmain").style.display ='none'; 
			document.getElementById("divtop").style.display ='none'; 
		}
	})

	/**导出成绩*/
	$("#daochu1").click(function(){
		$.ajax({
			url:"AdminManageServert?action=downFile",
			type:"post",
			processData:false,
			contentType:false,
			dataType:"text",
			success:function(data){
				parent.location.href=data;
			}
		});
	});

	$("#butno").click(function(){
		document.getElementById("divmain1").style.display ="none";
		document.getElementById("divmain").style.display ='block'; 
		document.getElementById("divtop").style.display ='block'; 
	});


});