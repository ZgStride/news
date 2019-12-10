<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String flag = request.getParameter("flag");

if(flag.equals("0")){
%>
新闻发布成功<a href="../user/index.jsp" target="_top">点击返回</a>
<%	
}else if(flag.equals("1")){
%>
新闻发布失败<a href="../news/addnews.jsp" target="content">请重新发布</a>
<%
} 
%>

<%
if(flag.equals("2")){
%>
密码修改成功<a href="denglu.jsp" target="_top">请点击登陆</a>
<%	
}else if(flag.equals("3")){
%>
密码修改失败<a href="../user/yonghuxiugaimima.jsp" target="content">请重新修改</a>
<%
} 
%>

<%
if(flag.equals("4")){
%>
密码重置成功<a href="../user/index.jsp" target="_top">请点击返回</a>
<%	
}else if(flag.equals("5")){
%>
密码重置失败<a href="../user/user.jsp" target="content">请重新尝试</a>
<%
} 
%>

<%
if(flag.equals("6")){
%>
用户删除成功<a href="../user/index.jsp" target="_top">请点击返回</a>
<%	
}else if(flag.equals("7")){
%>
用户删除失败<a href="../user/user.jsp" target="content">请重新尝试</a>
<%
} 
%>

<%
if(flag.equals("8")){
%>
新闻修改成功<a href="/2019-4-28/Selectnews_servlet" target="content">请点击返回</a>
<%	
}else if(flag.equals("9")){
%>
新闻修改失败<a href="../news/xiugaixinwen.jsp" target="content">请重新尝试</a>
<%
} 
%>

<%
if(flag.equals("10")){
%>
新闻删除成功<a href="/2019-4-28/Selectnews_servlet" target="content">请点击返回</a>
<%	
}else if(flag.equals("11")){
%>
新闻删除失败<a href="../news/selectnews.jsp" target="content">请重新尝试</a>
<%
} 
%>

<%
if(flag.equals("12")){
%>
权限修改成功<a href="../user/index.jsp" target="_top">请点击返回</a>
<%	
}else if(flag.equals("13")){
%>
权限修改失败<a href="../news/selectnews.jsp" target="content">请重新尝试</a>
<%
} 
%>


</body>
</html>