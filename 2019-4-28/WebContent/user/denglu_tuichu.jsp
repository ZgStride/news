<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 退出处理页面，退出时跳转到改页面，做清空用户（session）处理，然后返回登陆页面 -->
<%
session.setAttribute("username", null);//清空session变量
int num;//当前在线人数
String count = (String)application.getAttribute("count");
num = Integer.parseInt(count);//把字符串转换为整型
num--;
//更新在线人数
count = String.valueOf(num);
application.setAttribute("count", count);
response.sendRedirect("denglu.jsp");
%>
</body>
</html>