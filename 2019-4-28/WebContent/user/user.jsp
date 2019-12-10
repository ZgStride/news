<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,java.util.*" import="user.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../css/public.css">
<link rel="stylesheet" href="../css/user.css">

</head>
<body>
<h1  align="center" class="tab">用户管理</h1>
<form action="/2019-4-28/SelectUser" method="post">
	<table class="tab" border="0">
		<tr class="selectuser">
		<td>发布人：
		<td><input type="text" name="username" class="inputs">
		<td><input type="submit" value="查询" name="ok" class="reg_btn">
		<td><input type="submit" value="返回" name="ok" class="reg_btn">
	</table>
</form> 
<br>

<table border="1" cellpadding="0" cellspacing="0" width="70%" class="tab" id="person">
<tr class="cloum">
<td width="5%">编号</td>
<td width="10%">用户名</td>
<td width="5%">性别</td>
<td width="10%">职业</td>
<td width="30%">爱好</td>
<td width="10%">用户类别</td>
<td colspan="4" align="center" width="40%">操作</td>
</td>
<%
	ArrayList<UserBean> list = (ArrayList<UserBean>)session.getAttribute("list");	
	Iterator<UserBean> it = list.iterator();
	while(it.hasNext()){
		UserBean user = it.next();
%>
		<tr class="cloum">
		<td><%=user.getId() %></td>
		<td><%=user.getUsername() %></td>
		<td><%=user.getSex() %></td>
		<td><%=user.getProfession() %></td>
		<td><%=user.getFavourite() %></td>
		<td><%=user.getType() %></td>
		<td><a href="../user/user_chongzhimima.jsp?id=<%=user.getId()%>" class="bg">重置密码</a></td>
		<td><a href="../user/NewFile.jsp?id=<%=user.getId()%>" class="bg">修改权限</a></td>
		<td><a href="../user/user_shanchu.jsp?id=<%=user.getId()%>" class="bg">删除用户</a></td>
		</tr>
<% 
}	
%>
</table>
<script type = "text/javascript">  
    window.onload = function color(){//窗口加载时调用  
	    var table = document.getElementById("person");//根据table的 id 属性值获得对象  
	    var rows = table.getElementsByTagName("tr");//获取table类型的tr元素的列表  
	    for(var i = 0; i < rows.length; i++){  
	       if(i % 2 == 0){  
	            rows[i].style.backgroundColor = "#EAF2D3";//偶数行时背景色为#EAF2D3  
	       }else{  
	            rows[i].style.backgroundColor = "White";//单数行时背景色为white  
	       }  
	    }  
    }  
</script>  
</body>
</html>