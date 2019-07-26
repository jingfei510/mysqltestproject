<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<style type="text/css">
		body{text-align:center;background-color: cadetblue}
		span{ color:white;  font-size:200% }
		hr{ margin-bottom:30px }
		tr{ height: 50px;color: white}
		table{ margin-top: 100px}
		td{font-size: 18px;color: white}
		a{font-size: 18px;color: white}
	</style>
</head>
<body>

<span> 学生信息管理系统登录 </span>
<hr color="white"/>
<form action="loginjsp" method="post">
	<table border="1" bordercolor="white" width="40%" cellspacing="0" align="center" >
		<tr>
			<td>请输入用户名：</td>
			<td><input type="text" name="username"/></td>
		</tr>
		<tr>
			<td>请输入密码：</td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<input type="submit" value="登陆"/> <input type="reset" value="重置"/>
				<a href="RegistView.html">注册</a><h5 style="color: darkred;">${error_msg}</h5>
			</td>
		</tr>
	</table>
</form>
</body>
</html>