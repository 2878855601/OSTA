<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if(null == session.getAttribute("uno")){
	response.sendRedirect("UserLogin.jsp");
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试成绩</title>
<link rel="stylesheet" href="css/userScore.css" />
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/UserScore.js"></script>
</head>

<body>

	<div id="divmain">
		<table width="600" height="300" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td colspan="2"><div id="divte" align="center">考&nbsp;&nbsp;&nbsp;&nbsp;试&nbsp;&nbsp;&nbsp;&nbsp;成&nbsp;&nbsp;&nbsp;&nbsp;绩</div></td>
			</tr>
			<tr>
				<td><div align="center" id="uno">准考证号：${requestScope.userBean.u_no}</div></td>
				<td><div align="center" id="uname">考生姓名：${requestScope.userBean.u_name}</div></td>
			</tr>
			<tr>
				<td><div align="center" id="pid">考试科目：${requestScope.paperBean.p_no}</div></td>
				<td><div align="center" id="pname">科目名称：${requestScope.paperBean.p_name}</div></td>
			</tr>
			<tr>
				<td><div align="center" id="pword">考试工种：${requestScope.paperBean.p_work}</div></td>
				<td><div align="center" id="pgreat">等级：${requestScope.paperBean.p_grade}</div></td>
			</tr>
			<tr>
				<td colspan="2"><div align="center" id="uscore">科目成绩：${requestScope.score}</div></td>
			</tr>
			<tr>
				<td colspan="2"><div align="center">
						<input type="button" name="button" id="button" value="完成" />
					</div></td>
			</tr>
		</table>
	</div>
</body>
</html>