<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" import="user.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 处理登陆页面数据 -->
<%
//一、接受登陆页面传递的数据
request.setCharacterEncoding("utf-8");
String username = request.getParameter("username");
String password = request.getParameter("password");
%>

	<%
	UserBean user = new UserBean(username,password);
	UserService us = new UserService(user);
	boolean result = us.islogin();
	if(result){		
			UserBean userBean = us.doSelectByUsername(username);
			
			//登陆成功
			session.setAttribute("userBean", userBean);//int username = 1;
			//获取登陆成功上线人数
			int num;//当前在线人数
			String count = (String)application.getAttribute("count");
			if(count == null){
				//第一人上线为空
				num = 1;
			}else{
				num = Integer.parseInt(count)+1;//把字符串转换为整型
			}
			//更新在线人数
			count = String.valueOf(num);
			application.setAttribute("count", count);
			response.sendRedirect("index.jsp");
			out.print("登陆成功！！！！！");
	%>
	<% 
	}else{
	%>
		登陆失败，请<a href="denglu.jsp">重新登陆</a>
	<%	
	}	
	%>











































</body>
</html>