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
<title>考生信息核实</title>
<link rel="stylesheet" href="css/userVerify.css" />
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/UserVerify.js"></script>
</head>
<body>
	<div id="divmain">
		<div id="divtop">
			<strong>信息核实</strong>
		</div>
		<div id="divmes">
			<table width="800" height="200" border="1" cellspacing="0"
				cellpadding="0">
				<tr>
					<td width="120"><div align="right">准考证号：</div></td>
					<td width="280"><div id="divuno" align="center">${sessionScope.uno}</div></td>
					<td width="120"></td>
					<td width="280" rowspan="3"></td>
				</tr>
				<tr>
					<td><div align="right">考生姓名：</div></td>
					<td><div id="divuname" align="center">${sessionScope.uname}</div></td>
					<td><div align="right">照片：</div></td>
				</tr>
				<tr>
					<td><div align="right">身份证号：</div></td>
					<td><div id="divuid" align="center">${sessionScope.uid}</div></td>
					<td><div align="right"></div></td>
				</tr>
				<tr>
					<td><div align="right">考试科目代码：</div></td>
					<td><div id="divpno" align="center">${sessionScope.bean.p_no}</div></td>
					<td><div align="right">考试科目名称：</div></td>
					<td><div id="divpname" align="center">${sessionScope.bean.p_name}</div></td>
				</tr>
				<tr>
					<td><div align="right">考试工种：</div></td>
					<td><div id="divpstype" align="center">${sessionScope.bean.p_work}</div></td>
					<td><div align="right">等级：</div></td>
					<td><div id="divpgreat" align="center">${sessionScope.bean.p_grade}</div></td>
				</tr>
			</table>
		</div>
		<div>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请核实上方表格中的信息是否属于个人信息，若信息正确则进入下一步考场信息核实！若信息错误请与考场的监考员联系！
			<br />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;考生请认真核实上方信息是否正确，确定正确之后方可开始考试，如信息错误就开始考试最终没有成绩或成绩为0，由考生自己负责。
			<div id="divkq">
				<strong>考前须知</strong>
			</div>
			<br /> 1.请认真核实考生信息。<br /> 2.请认真核对考场信息。<br /> 3.请遵守考场纪律。<br />
			<div id="divyes">
				<input type="button" name="yes" id="yes" value="确定" />
			</div>
		</div>
	</div>
</body>
</html>
