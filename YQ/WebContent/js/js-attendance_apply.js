/*
 * 加载页面执行的操作
 */
window.onload = function(event) {	    
    
}

/**
 * 添加企业申请验证
 */
function companyAdd(){
	if($$('companyAdd-company').value==''){
		alert('企业名称不能为空！');
		$$('companyAdd-company').focus();		
	}
	else if($$('companyAdd-reason').value==''){
		alert('申请理由不能为空！');
		$$('companyAdd-reason').focus();	
	}else{
		$("#companyAdd-form").submit();
	}
}

/**
 * 添加企业申请验证
 */
function companyUserAdd(){
	if($$('companyUserAdd-reason').value==''){
		alert('申请理由不能为空！');
		$$('companyUserAdd-reason').focus();	
	}else{
		$("#companyUserAdd-form").submit();
	}
}