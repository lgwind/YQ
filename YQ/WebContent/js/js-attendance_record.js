/*
 * 加载页面执行的操作
 */
window.onload = function(event) {	    
    
}

/**
 * 监听日期的变化值
 */
$(function(){
	
	$('#record-date').bind('input propertychange', function() {
		var username = $$('username').innerHTML;
	    var date = $$('record-date').value;
		window.open("/YQ/attendance/record?" +
				"username="+username+
				"&date="+date
				,"_self");
	});
	
})

function changeDate(elem){
	var str=elem.innerHTML;
	var str2=str.charAt(0)+str.charAt(1)+str.charAt(2)+str.charAt(3)+"-"
	        +str.charAt(4)+str.charAt(5)+'-'
	        +str.charAt(6)+str.charAt(7);
//	alert(str2);
	$$('record-date').value=str2;
	var username = $$('username').innerHTML;
    var date = $$('record-date').value;
	window.open("/YQ/attendance/record?" +
			"username="+username+
			"&date="+date
			,"_self");
}