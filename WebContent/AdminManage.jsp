<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
if(null == session.getAttribute("pno")){
	response.sendRedirect("AdminLogin.jsp");
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试管理</title>
<link rel="stylesheet" href="css/adminManage.css" />
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/AdminManage.js"></script>
</head>
<body>
	<div id="divbig"></div>
	<div id="divbogtop">
		<div id="dimain">
			<p id="pus">考生预览 ：</p>
			<div id="ditop">
				<table width="760" border="1" cellspacing="0" cellpadding="0"
					id="tableUserr">
					<tr>
						<th>序号</th>
						<th>姓名</th>
						<th>身份证号码</th>
						<th>准考证号</th>
						<th>考试名称</th>
						<th>鉴定等级</th>
					</tr>
				</table>
			</div>
		</div>
		<div align="center">
			<input type="button" name="useryes" id="useryes" value="确定" />
		</div>
	</div>

	<div id="divstyl">
		<div id="div1">
			<div id="divstbt">
				职业技能鉴定国家题库
				<p id="pname"></p>
			</div>
			<div id="divxsxx">
				科目代码：
				<samp>KNO</samp>
				&nbsp;&nbsp;科目名称:
				<samp>KNAME</samp>
				&nbsp;&nbsp;准考证号：
				<samp>NNO</samp>
				&nbsp;&nbsp;考生姓名：
				<samp>NNAMME</samp>
			</div>

			<div id="divst">
				<div id="divstx">
					<table id="tableItemBank"></table>
				</div>
				<div id="divstr">
					<div id="divt">
						注&nbsp;&nbsp;意&nbsp;&nbsp;事&nbsp;&nbsp;项 <br />1、本考试依据2005年颁布的《数控车工》国家职业标准命制，考试时间：120分钟。
						<br />2、请在考试之前认真核实自己的姓名、准考证号和所在单位的名称。 <br />3、请仔细阅读答题要求，在规定位置填写答案
					</div>
					<div id="divz">
						<br />
						<table width="498" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="300">剩余时间：
									<div id="divtime"></div>
								</td>
								<td width="198">题目导航栏</td>
							</tr>
						</table>
					</div>
					<div id="divdtk">

					</div>

					<div id="divsy">
						
					</div>
					<br />
					<br />
					<div id="divjuan">
						<input type="button" name="jiaojuan" id="jiaojuan"
							value="交&nbsp;&nbsp;卷" />
					</div>
				</div>
			</div>
		</div>
		<div align="center">
			<input type="button" name="pyes" id="pyes" value="确定" />
		</div>
	</div>



	<div id="divshow">
		<h3 style="margin-bottom: 0px;">请输入密码</h3>
		<br /> <input id="pwd" type="password" /> <br> <br> <input
			id="sub" type="button" value="确定" />
	</div>


	<div id="divmain">
		<div id="divtop">
			<table width="920" height="99" border="0">
				<tr>
					<td colspan="3">试卷导入</td>
				</tr>
				<tr>
					<td width="196">&nbsp;&nbsp;&nbsp;&nbsp;试卷压缩包位置:</td>
					<form id="form1" action="AdminManageServert"
						enctype="multipart/form-data">
						<td width="469"><div align="center">
								<input type="file" name="path" id="path" />
							</div></td>
						<td width="241"><div align="center">
								<input type="button" name="toLead" id="toLead" value="导入" />
							</div></td>
					</form>
				</tr>
			</table>
		</div>
		<div id="divmid">
			<table width="920" height="378" border="0">
				<tr>
					<td colspan="4">考卷信息</td>
				</tr>
				<tr>
					<td width="100"><div align="center">考试名称:</div></td>
					<td width="300"><div align="center" id="name">无</div></td>
					<td width="100"><div align="center">考试试卷:</div></td>
					<td width="300"><div align="center" id="no">无</div></td>
				</tr>
				<tr>
					<td><div align="center">考试时间:</div></td>
					<td><div align="center" id="time">无</div></td>
					<td><div align="center">考试类型:</div></td>
					<td><div align="center" id="type">无</div></td>
				</tr>
				<tr>
					<td><div align="center">鉴定工种:</div></td>
					<td><div align="center" id="work">无</div></td>
					<td><div align="center">鉴定机构:</div></td>
					<td><div align="center" id="institution">无</div></td>
				</tr>
				<tr>
					<td><div align="center">鉴定等级:</div></td>
					<td><div align="center" id="grade">无</div></td>
					<td><div align="center">及格分数:</div></td>
					<td><div align="center" id="score">无</div></td>
				</tr>
				<tr>
					<td><div align="center">考生人数:</div></td>
					<td><div align="center" id="count">无</div></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2"><div align="center">
							<input type="button" name="preview" id="preview" value="预览试卷" />
						</div></td>
					<td colspan="2"><div align="center">
							<input type="button" name="preuser" id="preuser" value="预览考生信息" />
						</div></td>
				</tr>
			</table>
		</div>
		<div id="divdow">
			<div align="center">
				<input type="button" name="yes" id="yes" value="确认考试信息" />
			</div>
		</div>
	</div>
</body>
</html>