<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>监考员登陆</title>
<link rel="stylesheet" href="css/adminLogin.css" />
</head>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/AdminLogin.js"></script>
<body>
<div id="divmain">
    	<div id="divleft">
        	
        </div>
        <div id="divright">	
  	    <div id="divlon">
            	<form method="post" id="from1" action="AdminLoginServert?action=login">
            	  <p>考试登录系统</p>
            	    <label for="pno">账&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
            	    <input type="text" name="pno" id="pno" placeholder="请输入账号..." />
            	  </p>
            	  <p>
            	    <label for="ppwd">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
                    <input type="password" name="ppwd" id="ppwd" placeholder="请输入密码..." />
                  </p>
            	  <p>验证码：
            	    <input type="text" name="ptext" id="ptext"  placeholder="输入验证码..." />
            	    <input type="button" name="bttext" id="bttext" value="验证码"/>
            	  </p>
            	  <table height="30" style=" margin-left: 0px">
            	  	<tr id="divhint">
            	  	</tr>
            	  </table>
            	  <table width="323" border="0">
            	    <tr>
            	      <td><input type="button" name="yes" id="yes" value="登录" /></td>
            	      <td><input type="reset" name="no" id="no" value="重置" /></td>
          	      </tr>
          	    </table>
            	</form>
          </div>
        </div>
    </div>
</body>
</html>
