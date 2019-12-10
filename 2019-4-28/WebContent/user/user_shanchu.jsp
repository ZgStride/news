<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1  align="center">新闻发布系统>>用户删除</h1><hr border="1" color="blue">
<%
//获取被删除用户编号
String userid = request.getParameter("id");
int id = Integer.parseInt(userid);
//操作数据库（把指定用户编号的用户删除）
UserService us = new UserService();
 int row = us.doDelete(id);
 if(row >=0){
	 response.sendRedirect("../user/result.jsp?flag=6");
 }else{
	 response.sendRedirect("../user/result.jsp?flag=7");
 }
%>
</body>
</html>