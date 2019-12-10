<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="background">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../css/public.css">
<link rel="stylesheet" href="../css/login.css">

</head>
<body>
<div class="box">
	<div  class="myform">
		<form action="/2019-4-28/login"  name="register" id="register" method="post">
			<table>
				<tr>
					<td class="ziti">Username:</td>
				</tr>
				<tr>
					<td>
						<input type="text" placeholder="用户名由6~12个字母数字或下划线组成" class="inputs" name="username" id="uname" onblur="checkIt()"/>						
						
					</td>
					<td>
						<span id="errorAccount" style="color:red;display:inline;width:10px"></span>
					</td>
				</tr>
				<tr>
					<td class="ziti">
						Password:
					</td>

				</tr>
				<tr>
					<td>
						<input type="password" placeholder="密码有6~12个非空格字符组成" class="inputs" name="password" id="pwd">
					</td>
				</tr>

				<tr>
					<td class="mylogin">
						<input type="button" onclick="window.location.href='zhuce.jsp'" class="reg_btn" name="btn_cancel" value="注册">
						<input type="button" value="登录" class="log_btn"  id="denglu" onclick="onclic();">	
					</td>
				</tr>				
			</table>
		</form>   
	</div>
</div>


<script src="../js/login.js"></script>
<script type="text/javascript">
var xmlHttp;
function checkIt(){
	var uname=document.getElementById("uname").value;

	
	if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
	    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	var url = "/2019-4-28/usercheck";
	xmlHttp.open("POST",url,true);
	xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlHttp.send("uname="+uname);
	
	xmlHttp.onreadystatechange=function(){
		if (xmlHttp.readyState==4 && xmlHttp.status==200){
			 document.getElementById("errorAccount").innerHTML = xmlHttp.responseText;
		}
	}
}
</script>
</body>
</html>