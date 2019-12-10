<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="news.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看新闻</title>
</head>
<body>
<%
News news = (News)session.getAttribute("news");
%>
<table align="center" border="1" cellspacing="0" cellpadding="0">

<tr>
<td>新闻标题：
<td width="20"><input type="text" size="100" value="<%=news.getTitle() %>">

<tr>
<td>新闻正文：
<td width="20"><textarea rows="10" cols="75"><%=news.getContent() %></textarea>

<tr>
<td>发布人：
<td><input type="text" size="20" value="<%=news.getUsername() %>">
发布时间：
<input type="text"  size="58" value="<%=news.getPubtime() %>">

<tr>
<td colspan="2" align="center" height="10%">
<input type="button" onclick="window.location.href='selectnews.jsp'" name="btn_cancel" value="返回">

</table>
</body>
</html>