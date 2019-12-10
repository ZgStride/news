<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="common.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link rel="stylesheet" href="../css/public.css">
    <link rel="stylesheet" href="../css/register.css">
</head>
<body>
<%
int id = Integer.parseInt(request.getParameter("id"));
%>
<form action="/2019-4-28/ChangeType?id=<%=id %>" name="frm_zhuce" method="post" onsubmit="return test()">
            <table>
<div class="box1">
    <div  class="myform1">
		<div>
			请选择修改的权限：
		</div>
		<div>
			<span span class="allchoose">
				<input type="radio" value="0" name="usertype">普通用户
				<input type="radio" value="1" name="usertype" class="all3">管理员
			</span>
		</div>
		<div class="last">
			<input type="button" onclick="window.location.href='../user/user.jsp'" name="btn_cancel" value="返回" class="reg_btn">
			<input type="submit"  value="确认" class="back_btn">
		</div>
	</div>	
</div>
 </table>
 </form>

</body>
</html>