<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>你还未登陆</h1>
<h1>
		界面将在<span id="s">5</span>s后跳转
	</h1>
</body>

<script type="text/javascript">

var time = 5;
window.onload = function() {
	setInterval('changetime()', 1000);
	setTimeout('window.parent.location="../user/denglu.jsp"',5000);
}
function changetime() {
	time--;
	document.getElementById("s").innerHTML = time;
}


</script>
</html>