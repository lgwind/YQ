/*
 * 加载页面执行的操作
 */
window.onload = function(event) {	    
    
}

/**
 * 添加企业申请验证
 */
function companyAdd(id,num){
	$$('companyAdd-finish'+id).value=''+num;
//	alert($$('companyAdd-finish'+id).value);
	$("#companyAdd-form"+id).submit();
}