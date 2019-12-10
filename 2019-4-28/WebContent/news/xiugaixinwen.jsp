<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="news.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/public.css">
<link rel="stylesheet" href="../css/addNews.css">

</head>
<body>
<%
News news = (News)session.getAttribute("news");
%>
<div class="box" style="height: 500px;">
	<div  class="myform">
		<form action="/2019-4-28/updatenews?id=<%=news.getId()%>" method="post">
			<table>
				<tr>
					<td class="ziti">title:</td>
				</tr>
				<tr>
					<td >
						<input type="text" name="title" class="inputs" value="<%=news.getTitle() %>">
					</td>
				</tr>
				<tr>
					<td class="ziti">
						content:	
					</td>

				</tr>
				<tr>
					<td>
						<textarea name="content" style="width: 500px ; height: 150px; margin-bottom: 10px;text-align: left;"><%=news.getContent()%></textarea>
					</td>
				</tr>

				<tr>
					<td class="user">															
						<span class="ziti" style="float: left"><%=news.getUsername() %></span>
						<span class="ziti" style="float: right"><%=news.getPubtime() %></span>
					</td>
				</tr>
				<tr>
					<td class="mylogin">
					<input type="submit" value="提交" class="log_btn">
					<input type="button" onclick="window.location.href='selectnews.jsp'" name="btn_cancel" value="返回" class="reg_btn" >
					</td>
				</tr>
				
			</table>
		</form>   
	</div>
</div>
</body>
</html>