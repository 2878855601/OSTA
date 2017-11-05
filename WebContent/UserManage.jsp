<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (null == session.getAttribute("uno")) {
		response.sendRedirect("UserLogin.jsp");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考生考试</title>
<link rel="stylesheet" href="css/UserManage.css" />
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/UserManage.js"></script>
</head>
<body>
	<div id="divzt"><div id="divzzt">考试暂停中，请等待开始继续....</div></div>
	<div id="divstyl">
		<div id="div1">
			<div id="divstbt">
				职业技能鉴定国家题库
				<p id="pname"></p>
			</div>
			<div id="divxsxx">
				科目代码：
				<samp>${sessionScope.bean.p_no}</samp>
				&nbsp;&nbsp;科目名称:
				<samp>${sessionScope.bean.p_name}</samp>
				&nbsp;&nbsp;准考证号：
				<samp id="uno1">${sessionScope.uno}</samp>
				&nbsp;&nbsp;考生姓名：
				<samp>${sessionScope.uname}</samp>
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
					<div id="divdtk"></div>

					<div id="divsy">
						
					</div>
					<br /> <br />
					<div id="divjuan">
						<input type="button" name="jiaojuan" id="jiaojuan"
							value="交&nbsp;&nbsp;卷" />
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>