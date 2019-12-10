// JavaScript Document
var  myform = document.forms["register"];
var  uname = myform.elements["uname"];
var  pwd = myform.elements["pwd"];
var denglu=document.getElementById("denglu");

	var  zz_uname =  /^\S\w{5,11}$/i;
	var  zz_pwd = /^\S{6,12}$/i;

denglu.onclick=function(){	
		if( zz_uname.test(uname.value)==false ){
		   alert("用户名错误，请重新输入！");
		   uname.focus();
		   	return  false ;	
		}
	
		if( zz_pwd.test(pwd.value)==false ){
		    alert("密码错误，请重新输入！");
		    pwd.focus();
			return  false ;	
		}
		register.submit();
}



