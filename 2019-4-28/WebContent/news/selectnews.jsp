<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,java.util.*" import="news.*" import="user.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../css/public.css">
<link rel="stylesheet" href="../css/user.css">

</head>
<body>
</head>
<body>
<h2 align="center">新闻发布系统>>新闻查询</h2>
<%
String pages = request.getParameter("pages");
int add = 0;
int delete = 0;
if(pages==null){
	int i=1;
}else{
	int num = Integer.parseInt(pages);
	 add = num+1;
	 delete = num-1;
}
%>



<table align="center" cellspacing="0" cellpadding="0" class="tab">

<tr class="selectuser">
<td>新闻标题：
<td width="15"><input type="text" name="title" size="15" class="inputs">
<td class="selectuser">发布人：
<td width="15"><input type="text" name="username" size="15" class="inputs">
<td><input type="submit" value="查询" name="ok" class="reg_btn">
<td><input type="button" onclick="window.location.href='../news/addnews.jsp'" target="content" value="发布" class="reg_btn">
	

</table>

<br>

<table border="2" cellpadding="0" cellspacing="0" width="65%" align="center" class="tab" id="person">
<div class="check">
<span style="float:right;">
	<input type="button" value="全部删除" onclick="del();" class="reg_btn">
</span>
</div>

<div class="clears"></div>

<tr align="center" class="cloum">
<td><input type="checkbox" onchange="checkAll()" id="check">全选</td>
<td>新闻编号</td>
<td>新闻标题</td>
<td width="10%" height="15">发布人</td>
<td>发布时间</td>

<td width="35%" colspan="4" align="center">操作</td>
<%
UserBean userBean = (UserBean)session.getAttribute("userBean");
String type = userBean.getType();

ArrayList<News> list = (ArrayList<News>)session.getAttribute("list");
if(list == null){
	return;
}
Iterator<News> it = list.iterator();
while(it.hasNext()){
	News news = it.next();
%>
	<tr align="center" class="cloum">
	<td><input type="checkbox" name="ms" value="<%=news.getId() %>"></td>
	<td><%=news.getId() %></td>
	<td><%=news.getTitle() %></td>
	<td><%=news.getUsername() %></td>
	<td><%=news.getPubtime() %></td>
	<%
	if(type.equals("1")|| userBean.getId() == news.getUserid()){
	%>
	<a href="/2019-4-28/Searchnews_servlet?operation=view&id=<%=news.getId()%>" class="bg">查看</a>
	<td><a href="/2019-4-28/Searchnews_servlet?operation=updata&id=<%=news.getId()%>" class="bg">修改</a></td>
	<td><a href="/2019-4-28/Deletenews?operation=delete&id=<%=news.getId()%>" class="bg">删除</a></td>
	<%
	}else{
	%>
	<td><a href="/2019-4-28/Searchnews_servlet?operation=view&id=<%=news.getId()%>" class="bg">查看</a></td>
	<% 
	}
	%>	
	
<%
}
%>

</table>

<div class="news_end" align="center">
	<ul class="new_end">
	<li>
		<a href="/2019-4-28/Selectnews_servlet?currPage=<%=delete%>" class="first">上一页</a>	
	</li>

	<li>
		<a href="/2019-4-28/Selectnews_servlet?currPage=<%=add%>" class="last">下一页</a>
	</li>		
</ul>
</div>

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
    function del(){
		var ms=document.getElementsByName("ms");
		var del=new Array();
		for(var i=0;i<ms.length;i++){
			if(ms[i].checked==true){
				del.push(ms[i].value);
			}
		}
		if(del.length>0){
			var b = del.join(",");
			window.location.href="/2019-4-28/Deletenews?operation=alldelete&allid="+b;
		}
	}
    function checkAll() {
		var check=document.getElementById("check");
		var ms=document.getElementsByName("ms");
		if(check.checked==true){
			for(var i=0;i<ms.length;i++){
				ms[i].checked=true;
			}
		}else{
			for(var i=0;i<ms.length;i++){
				ms[i].checked=false;
			}
		}
	}

</script>  
</body>
</html>