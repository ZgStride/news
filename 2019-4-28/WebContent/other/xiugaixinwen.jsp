<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="news.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
News news = (News)session.getAttribute("news");
%>
<form action="/2019-4-28/updatenews?id=<%=news.getId()%>" method="post">
<table align="center" border="1" cellspacing="0" cellpadding="0">

<tr>
<td>新闻标题：
<td width="20"><input type="text" size="100" value="<%=news.getTitle() %>" name="title">

<tr>
<td>新闻正文：
<td width="20"><textarea rows="10" cols="75" name="content"><%=news.getContent() %></textarea>

<tr>
<td>发布人：
<td><input type="text" size="20" value="<%=news.getUsername() %>" name="username">
发布时间：
<input type="text"  size="58" value="<%=news.getPubtime() %>" name="time">

<tr>
<td colspan="2" align="center" height="10%">
<input type="submit" value="提交">
<input type="button" onclick="window.location.href='selectnews.jsp'" name="btn_cancel" value="返回">

</table>
</form>

</body>
</html>