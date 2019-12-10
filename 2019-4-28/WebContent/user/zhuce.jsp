<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="../css/public.css">
    <link rel="stylesheet" href="../css/register.css">
</head>
<body>
<div class="box">
    <div  class="myform">
        <form action="zhucechuli.jsp" name="frm_zhuce" method="post" onsubmit="return test()">
            <table>
                <tr>
                    <td class="td">用户名：
                    <td>
                    <input type="text" placeholder="用户名由6~12个字母数字或下划线组成" class="inputs" name="username" id="uname">

                <tr>
                    <td class="td">密码：
                    <td><input type="password" placeholder="用户名由6~12个字母数字或下划线组成" class="inputs" name="password" id="password">
                
                <tr>
                    <td class="td">确认密码：
                    <td><input type="password" placeholder="用户名由6~12个字母数字或下划线组成" class="inputs" name="password_1" id="password_1">
                    
                <tr>
                    <td class="td">性别：
                    <td>
                        <span class="all">
                            <input type="radio" value="0" name="sex">男
                            <input type="radio" value="1" name="sex" class="all2">女
                        </span>
                
                <tr>
                    <td class="td">职业：
                    <td>
                        <span class="all">
                            <select name="profession" class="select">
                            <option value="0">学生
                            <option value="1" >教师
                            <option value="2">工人
                             </select>
                        </span>
                <tr>
                    <td class="td">个人爱好：
                    <td>
                    <span class="all">
                         <input type="checkbox" value="0" name="favourite" >电脑网络
                        <input type="checkbox" value="1" name="favourite" class="all2">影视娱乐
                        <input type="checkbox" value="2" name="favourite" class="all2">棋牌娱乐
                    </span>
                <tr>
                    <td class="td">个人说明：
                    <td colspan="3">
                        <textarea rows="6" cols=40%" name="note"></textarea>

                <tr>
                    <td colspan="2" align="center" class="last">
                        <input type="button" onclick="window.location.href='denglu.jsp'" name="btn_cancel" value="取消" class="reg_btn">
                        <input type="submit" value="注册" class="back_btn">
            </table>
        </form>
    </div>
</div>
</body>
</html>