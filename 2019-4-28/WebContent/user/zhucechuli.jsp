<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,user.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String username = request.getParameter("username");
String password = request.getParameter("password");
String password_1 = request.getParameter("password_1");
String sex = request.getParameter("sex");
String profession = request.getParameter("profession");
String[] favourite_s = request.getParameterValues("favourite");
String note = request.getParameter("note");
%>
<%
if(!password.equals(password_1)){
%>
	两次密码不一致！<a href="zhuce.jsp">重新填写</a>
<% 
}else{

	String favourite = "";
	for(int i = 0;i<favourite_s.length;i++){
		favourite+=favourite_s[i]+" ";
	}

	UserBean user = new UserBean();
	user.setUsername(username);
	user.setPassword(password);
	user.setSex(sex);
	user.setProfession(profession);
	user.setFavourite(favourite);
	user.setNote(note);
	UserService us = new UserService(user);
	int row = us.doReigster();
%>	
<%
	if(row>=1){
		 %>
		添加成功<a href="denglu.jsp">登陆</a>
		<%
	}else{
		 %>
		添加失败<a href="zhuce.jsp">重新填写</a>
		<% 
	}
	
}
%>

</body>
</html>