<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">用户登陆>>修改密码</h3>
<form action="/2019-4-28/UpdataPasswordServlet" method="post" name="update">
<table align="center">
<tr>
<td>旧密码：
<td><input type="password" name="password_old" id="password_old" value="">

<tr>
<td>新密码：
<td><input type="password" name="password_new" id="password_new" value="" onchange="check_old();">

<tr>
<td>确认密码：
<td><input type="password" name="password_confirm" id="password_confirm" value="" onchange="check_confirm();">

<tr>
<td colspan="2" align="center">
			<input type="submit" name="btn_ok" value="确认">
			<input type="reset"  name="" value="取消">
			
</table>

</form>

<script type="text/javascript" src="../js/updatepassword.js"></script>

</body>
</html>