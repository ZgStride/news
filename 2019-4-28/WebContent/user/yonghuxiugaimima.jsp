<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../css/public.css">
<link rel="stylesheet" href="../css/login.css">
</head>
<body>
<div class="boxpw">
	<div  class="myform">
		<form action="/2019-4-28/UpdataPasswordServlet"  name="update" method="post">
			<table>
				<tr>
					<td class="ziti">OldPassword:</td>
				</tr>
				<tr>
					<td >
						<input type="password" placeholder="密码有6~12个非空格字符组成" class="inputs" name="password_old" id="password_old">
					</td>
				</tr>
				<tr>
				<tr>
					<td class="ziti">NewPassword:</td>
				</tr>

				</tr>
				<tr>
					<td>
						<input type="password" placeholder="密码有6~12个非空格字符组成" class="inputs" name="password_new" id="password_new">
					</td>
				</tr>
				<tr>
					<td class="ziti">comfirmPassword:</td>
				</tr>
				<tr>
					<td >
						<input type="password" placeholder="密码有6~12个非空格字符组成" class="inputs" name="password_confirm" id="password_confirm">
					</td>
				</tr>

				<tr>
					<td class="mylogin">
						<input type="button" onclick="window.parent.location.href='index.jsp'"  class="reg_btn" name="btn_cancel" value="取消">
						<input type="button" value="确认" class="log_btn" onclick="check();">	
					</td>
				</tr>
				
			</table>
		</form>   
	</div>
</div>
<script type="text/javascript" src="../js/updatepassword.js"></script>
</body>
</html>