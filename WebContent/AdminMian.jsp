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
<title>监考主界面</title>
<link rel="stylesheet" href="css/adminMian.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/AdminMain.js"></script>
</head>

<body>

	<div id="divhelp">
    	<div id="helptop">帮&nbsp;&nbsp;&nbsp;&nbsp;助</div>
        <div id="helpright">
        欢迎您使用OSTA考试管理系统：<br /><br />
        1.请您先点击新建考试进行试卷的导入<br />
        2.导入之后，请核实试卷信息，点击确认考试按钮<br />
        3.点击开始考试方可进行开始考试操作<br />
        4.在系统的左边，可对考试进行监控，可以进行作弊，违纪等操作<br />
        5.考试结束之后，可以在导出成绩功能把成绩进行导出<br />
        5.一旦考试结束，将无法再次登录本场考试<br />
        
        *注意，在导入之前系统会自动清除上一场考试的数据，请及时导出学生成绩
        </div>
        <div id="helpyes">
          <div align="center">
            <input type="button" name="helpbutton" id="helpbutton" value="确定" />
          </div>
        </div>
    </div>

	<div id="divmain">
		<div id="divtop">
			<samp>厦门市职业技能鉴定中心</samp>
			--鉴定站考试管理系统
			<p id="ptop">欢迎你！</p>
		</div>
		<div id="divmid">
			<table width="900" height="199" border="0">
				<tr>
					<td width="330"><div align="center">
							<a href="AdminManage.jsp"><input type="button" name="new"
								id="new" value="新建考试" /></a>
						</div></td>
					<td width="200"><div align="center">
							<a href="#"><input type="button" name="help" id="help"
								value="帮助" /></a>
						</div></td>
					<td width="370" id="time"></td>
				</tr>
				<tr>
					<td colspan="3">欢迎您使用鉴定站考试系统,你可以点击<samp
							style="font-size: 24px;">
							<strong>新建考试</strong>
						</samp>按钮来安排考试，如果在使用中，遇到问题，请点击帮助来获取帮助。
					</td>
				</tr>
			</table>
		</div>
		<div id="divdow"></div>
	</div>
</body>
</html>