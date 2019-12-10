<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/public.css">
<link rel="stylesheet" href="../css/addNews.css">

<meta http-equiv="CONTENT-TYPE" content="text/html;charest=utf-8">
<script type="text/javascript" charset="utf-8" src="../ueditor2/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="../ueditor2/ueditor.all.js"></script>
<link href="../ueditor2/themes/default/css/ueditor.css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="../ueditor2/lang/zh-cn/zh-cn.js"></script>

</head>
<body>
<div class="box">
	<div  class="myform">
		<form action="/2019-4-28/addnwes" method="post" name="frm_addnews">
			<table>
				<tr>
					<td class="ziti">title:</td>
				</tr>
				<tr>
					<td >
						<input type="text" name="title" class="inputs">
					</td>
				</tr>
				<tr>
					<td class="ziti">
						content:	
					</td>

				</tr>
				<tr>
					<td>
						<textarea id="editor" name="content" type="text/plain" style="width: 500px ; height: 150px; margin-bottom: 10px; "></textarea>
					</td>
				</tr>

				<tr>
					<td class="mylogin">															
						<input type="button" onclick="window.parent.location.href='../user/index.jsp'" class="reg_btn" name="btn_cancel" target="_parent" value="返回">
						<input type="button" value="发布" class="log_btn"  onclick="ok_onClick();">	
					</td>
				</tr>
			</table>
		</form>   
	</div>
</div>
<script type="text/javascript" src="../js/newscheck.js"></script>
 <script type="text/javascript">
    UE.getEditor('editor', {'enterTag' : 'br',initialFrameWidth: null , autoHeightEnabled: false,});
 </script>
 
</body>
</html>