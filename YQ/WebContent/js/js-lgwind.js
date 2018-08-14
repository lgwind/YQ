/**
 * 加载页面执行的操作
 */
//window.onload=function(event){
//
//}

/**
 * 返回id
 * @param id
 * @returns
 */
function $$(id){
	return document.getElementById(id);
}


/**
 * 显示遮罩
 * @returns
 */
function showMask(){
	$$("userMask").style.display="inline";
}

/**
 * 获取日期
 * @returns {String}
 */
function getDate(){
	var myDate = new Date();
	var str = ''+myDate.getFullYear();    //获取完整的年份(4位,1970-????)
	str+='-';
	str+=myDate.getMonth()+1;       //获取当前月份(0-11,0代表1月)
	str+='-';
	str+=myDate.getDate();        //获取当前日(1-31)
	str+='-';
	str+=myDate.getHours();       //获取当前小时数(0-23)
	str+='-';
	str+=myDate.getMinutes();     //获取当前分钟数(0-59)
	str+='-';
	str+=myDate.getSeconds();     //获取当前秒数(0-59)
	return str;
}

/**
 * 时间减法
 * @param time1 时间
 * @param time2 时间
 * @returns {Number} 返回结果秒数
 */
function timeSub(time1, time2){
	var times1 = timeInt(time1);
	var times2 = timeInt(time2);
	var num1 = (times1[0]-times2[0])*60*60;
	var num2 = (times1[1]-times2[1])*60;
	var num3 = times1[2]-times2[2];
	return num1+num2+num3;
}

/**
 * 时间转化为数字数组
 * @param time
 * @returns {Array}
 */
function timeInt(time){
	var times = time.split(":");
	var int = [parseInt(times[0]),parseInt(times[1]),parseInt(times[2])];
	return int;
}

/**
 * 获取当前时间
 * @returns {String}
 */
function getTime(){
	var myDate = new Date();
	var str='';
	if(myDate.getHours()<10){
		str+='0';
	}
	str+=myDate.getHours();       //获取当前小时数(0-23)
	str+=':';
	if(myDate.getMinutes()<10){
		str+='0';
	}
	str+=myDate.getMinutes();     //获取当前分钟数(0-59)
	str+=':';
	if(myDate.getSeconds()<10){
		str+='0';
	}
	str+=myDate.getSeconds();     //获取当前秒数(0-59)
	return str;
}


