/*
 * 加载页面执行的操作
 */
window.onload = function(event) {	    
}

function submit_form(action) {
//	alert("123");
    var form1 = $("#message-form");
//    form1.action = '/YQ/me/data/add';
    $("#message-form").attr("action",action);
    form1.submit();
}