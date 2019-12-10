<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../css/public.css">
<link rel="stylesheet" href="../css/top.css">

</head>
<body>
<h1 align="center">新闻发布系统</h1><hr>
<%
UserBean userBean = (UserBean)session.getAttribute("userBean");
String username = userBean.getUsername();
//String username = (String)session.getAttribute("username"); 
String count = (String)application.getAttribute("count");
%>
<%
if(username == null){
	response.sendRedirect("denglu.jsp");
	return;
}
%>

<div class="box">

<span class="num">[<%=username %>]你好！[<%=count %>]人在线</span>

</div>

</body>
</html>