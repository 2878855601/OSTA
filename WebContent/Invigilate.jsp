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
<title>监考管理</title>
<link rel="stylesheet" href="css/invigilate.css" />
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/Invigilate.js"></script>
</head>
<body>


	<div id="divmain1">
		<div id="divtop1">参考人员总成绩列表</div>
		<div id="divtab1">
			<table id="ctable" width="880" border="1" cellspacing="0" cellpadding="0">
				<tr>
					<th>准考证号</th>
					<th>考生姓名</th>
					<th>考试科目</th>
					<th>科目名称</th>
					<th>工种</th>
					<th>等级</th>
					<th>成绩</th>
				</tr>
			</table>
		</div>
		<div id="ddivhig1">
			<table width="500" height="41" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td width="250"><div align="center">
							<input type="button" name="daochu1" id="daochu1" value="导出成绩" />
						</div></td>
					<td width="250"><div align="center">
							<input type="button" name="butno" id="butno"
								value="取&nbsp;&nbsp;&nbsp;&nbsp;消" />
						</div></td>
				</tr>
			</table>
		</div>
	</div>



	<div id="divtop">
		<samp>厦门市职业技能鉴定中心</samp>
			--鉴定站考试管理系统                    欢迎你！
	</div>
	<div id="divmain">
		<div id="divmag"></div>
		<div id="divpname">
			<table width="770" height="90" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td colspan="5"><div id="pname" align="center"
							style="font-size: 30px">
							<strong>考试名称</strong>
						</div></td>
				</tr>
				<tr style="font-size: 14px;">
					<td width="134" height="30"><div id="divtype">考试类型：</div></td>
					<td width="134"><div id="divtime">考试时间：</div></td>
					<td width="120"><div id="divnum">考生人数：</div></td>
					<td width="138"><div id="divgread">鉴定级别：</div></td>
					<td width="144"><div id="divwork">鉴定工种：</div></td>
				</tr>
			</table>
		</div>

		<div id="divstate">
			<table width="200" border="0" cellspacing="0" cellpadding="0"
				height="400">
				<tr>
					<td><div align="center">考试状态：</div></td>
				</tr>
				<tr>
					<td><div align="center" id="pstate"></div></td>
				</tr>
				<tr>
					<td><div align="center">考试时间倒计时：</div></td>
				</tr>
				<tr>
					<td><div align="center" id="pdowntime"></div></td>
				</tr>
				<tr>
					<td><div align="center">
							<input type="button" class="button" name="begin" id="begin"
								value="开始考试" />
						</div></td>
				</tr>
				<tr>
					<td><div align="center">
							<input type="button" class="button" name="jiaojuan" id="jiaojuan"
								value="强制交卷" />
						</div></td>
				</tr>
				<tr>
					<td><div align="center">
							<input type="button" class="button" name="zuobi" id="zuobi"
								value="作    弊" />
						</div></td>
				</tr>
				<tr>
					<td><div align="center">
							<input type="button" class="button" name="weiji" id="weiji"
								value="违    纪" />
						</div></td>
				</tr>
				<tr>
					<td><div align="center">
							<input type="button" class="button" name="zanting" id="zanting"
								value="暂停考试" />
						</div></td>
				</tr>
				<tr>
					<td><div align="center">
							<input type="button" class="button" name="daochu" id="daochu"
								value="考试成绩" />
						</div></td>
				</tr>
			</table>
		</div>

		<div id="divuser">
			<div id="divqx">
				考生列表： <input type="checkbox" name="usercheckbox1" id="usercheckbox" />
				<label for="checkbox">全选/反选</label>
			</div>
			<div id="divstu"></div>
		</div>

	</div>
</body>
</html>