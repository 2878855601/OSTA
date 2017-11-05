<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考生登录</title>
<link rel="stylesheet" href="css/userLogin.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/UserLogin.js"></script>
</head>

<body>
<div id="divmain">
            	<form method="post" id="from1" action="UserLoginServert?action=login">
                <div id="divfrom">
            	  <p><samp>厦门市职业技能鉴定中心</samp>-学生考试系统</p>
                  <p>考试名称：
                    <label for="select"></label>
                    <select name="select" id="sel">
                    	<option>--请选择本场考试名称--</option>
                    </select>
                  </p>
            	  <p>
            	    <label for="uno">准考证号：</label>
            	    <input type="text" name="uno" id="uno" />
            	  </p>
            	  <p>
            	    <label for="uid">身份证号：</label>
                    <input type="text" name="uid" id="uid" />
            	  </p>
            	  <p>
            	    <label for="uname">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
                    <input type="text" name="uname" id="uname" />
                  </p>
            	    <table height="30" style=" margin-left: 50px">
            	  	<tr id="hint">
            	  	</tr>
            	  </table>
            	  <input type="button" name="yes" id="yes" value="登录" />
                  </div>
            	</form>
    </div>
</body>
</html>
