/**
 * 
 */
var  update = document.forms["update"];
var  pwdold = update.elements["password_old"];
var  pwdnew = update.elements["password_new"];
var  pwdcomf = update.elements["password_confirm"];
var  zz_pwd = /^\S{6,12}$/i;
function check() {
	var  password_old =document.getElementById("password_old").value;
	var  password_new =document.getElementById("password_new").value;
	var  password_confirm =document.getElementById("password_confirm").value;
	if(password_old==null||password_new==null||password_confirm==null||password_old==""||password_new==""||password_confirm==""){
		alert("密码不能为空");
		return;
	}
	if( zz_pwd.test(pwdold.value)==false ){
	    alert("密码错误，请重新输入！");
	    pwd.focus();
		return  false ;	
	}
	if( zz_pwd.test(pwdnew.value)==false ){
	    alert("密码错误，请重新输入！");
	    pwd.focus();
		return  false ;	
	}
	if( zz_pwd.test(pwdcomf.value)==false ){
	    alert("密码错误，请重新输入！");
	    pwd.focus();
		return  false ;	
	}
	
	if(password_new===password_old){
		alert("新旧密码相同");
		update.password_new.focus();
		return;
	}
	
	if(password_new!==password_confirm){
		alert("两次密码不相同");
		update.password_confirm.focus();
		return;
	}
	update.submit();
}