<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
UserBean userBean = (UserBean)session.getAttribute("userBean");
String type = userBean.getType();
%>
<table>
<%
if(type.equals("1")){	
%>
<tr>
<td>---<a href="../user/user.jsp" target="right">用户管理</a>---</td>
</tr>
<%
}
%>
<tr>
<td>---<a href="../news/addnews.jsp" target="right">新闻发布</a>---</td>
</tr>
<tr>
<td>---<a href="/2019-4-28/Selectnews_servlet" target="right">新闻查询</a>---</td>
</tr>
<tr>
<td>---<a href="../user/yonghuxiugaimima.jsp" target="right">修改密码</a>---</td>
</tr>
<tr>
<td>---修改信息---</td>
</tr>
<tr>
<td>---<a href="denglu_tuichu.jsp" target="_top">退出登陆</a>---</td>
</tr>

</table>

</body>
</html>