<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="user.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="left">新闻发布>>密码重置</h1>
<%
int id = Integer.parseInt(request.getParameter("id"));
UserService us = new UserService();
int row = us.doResetPassword(id);
if(row >= 0){
	response.sendRedirect("../user/result.jsp?flag=4");
}else{
	response.sendRedirect("../user/result.jsp?flag=5");

}

%>

</body>
</html>