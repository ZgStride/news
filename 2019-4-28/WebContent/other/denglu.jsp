<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">新闻发布系统>>用户登录</h1><hr>
<form action="/2019-4-28/login" name="frm_denglu" method="post">
	<table align="center" border="1" widyh="35%" cellspacing="0" cellpadding="0">
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="username" size="31" value="1"></td>
		</tr>
		
		<tr>
			<td>密码：</td>
			<td><input type="password" name="password" size="32" value="666666"></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
			<input type="submit" name="btn_ok" value="登陆">
			<input type="button" onclick="window.location.href='zhuce.jsp'" name="btn_cancel" value="注册">
			</td>
		</tr>
	</table>
</form>
</body>
</html>