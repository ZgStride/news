/**
 * 
 *
 */

function ok_onClick() {
	var title =frm_addnews.title.value;
	if(title.length==0){
		alert("标题不能为空")
		frm_addnews.title.focus();
		return;
	}
	
	frm_addnews.submit();
}