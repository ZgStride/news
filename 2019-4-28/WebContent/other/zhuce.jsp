<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">新闻发布>>用户注册</h1>
<form action="zhucechuli.jsp" name="frm_zhuce" method="post" onsubmit="return test()">
<table border="1" cellpadding="0" cellspacing="0" align="center">
<tr>
<td>用户名：
<td colspan="3"><input type="text" size="68" name="username">

<tr>
<td>密码：
<td><input type="password" size="25" name="password">
<td>确认密码：
<td><input type="password" size="25" name="password_1">

<tr>
<td>性别：
<td><input type="radio" value="0" name="sex">男
	<input type="radio" value="1" name="sex">女
<td>职业：
<td><select name="profession">
<option value="0">学生
<option value="1">教师
<option value="2">工人
</select>

<tr>
<td>个人爱好：
<td colspan="3">
<input type="checkbox" value="0" name="favourite">电脑网络
<input type="checkbox" value="1" name="favourite">影视娱乐
<input type="checkbox" value="2" name="favourite">棋牌娱乐

<tr>
<td>个人说明：
<td colspan="3">
<textarea rows="6" cols="52%" name="note"></textarea>

<tr>
<td colspan="4" align="center">
<input type="submit" value="注册">
<input type="button" onclick="window.location.href='denglu.jsp'" name="btn_cancel" value="取消">
</table>
</form>

</body>
</html>