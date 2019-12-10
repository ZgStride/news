<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/public.css">
<link rel="stylesheet" href="../css/index.css">

</head>
<body>
<%
UserBean userBean = (UserBean)session.getAttribute("userBean");
String username = userBean.getUsername();
String type = userBean.getType();
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
    <div class="left">
        <table class="tab">
        <%
		if(type.equals("1")){	
		%>
		<tr class="all">
		<td><a href="/2019-4-28/SelectUser" target="content" class="all1">用户管理</a></td>
		</tr>
		<%
		}
		%>
        <tr class="all">
            <td ><a href="../news/addnews.jsp" target="content"  class="all1">新闻发布</a></td>
        </tr>
        <tr class="all">
            <td ><a href="/2019-4-28/Selectnews_servlet" target="content"  class="all1">新闻查询</a></td>
        </tr>
        <tr class="all">
            <td ><a href="../user/yonghuxiugaimima.jsp" target="content"  class="all1">修改密码</a></td>
        </tr>

        <tr class="all">
            <td><a href="denglu_tuichu.jsp" target="_top"  class="all1">退出登陆</a></td>
        </tr>
        </table>
    </div>

    <div class="right">
        <div class="top">
        	<h2 align="center">新闻发布系统</h2>
            <span class="num">[<%=username %>]你好！[<%=count %>]人在线</span>
        </div>
        <iframe class="content" id="content" name="content">
          
        </iframe>
    </div>
    <div class="clears"></div>
</div>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
</body>
</html>