<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新闻发布</title>
<meta http-equiv="CONTENT-TYPE" content="text/html;charest=utf-8">
<script type="text/javascript" charset="utf-8" src="../ueditor2/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="../ueditor2/ueditor.all.js"></script>
<link href="../../ueditor2/themes/default/css/ueditor.css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="../ueditor2/lang/zh-cn/zh-cn.js"></script>

</head>
<body>
<h2>新闻发布系统>>发布新闻</h2>
<form action="/2019-4-28/addnwes" method="post" name="frm_addnews">
<table align="center" border="1" cellspacing="0" cellpadding="0">

<tr>
<td>新闻标题：
<td widyh="20%"><input type="text" name="title" size="52">

<tr>
<td>新闻正文：
<td><textarea id="editor" name="content" type="text/plain" style="width: 1000px ; height: 500px"> 45634</textarea>
<tr>
<td colspan="2" align="center">
<input type="button" value="确认" name="ok" onclick="ok_onClick();">
<input type="reset" value="取消">
</td>

</table>
</form>

<script type="text/javascript" src="../js/newscheck.js"></script>
 <script type="text/javascript">
    UE.getEditor('editor');
 </script>

</body>
</html>