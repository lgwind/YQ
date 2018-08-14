/*
 * 加载页面执行的操作
 */
window.onload = function(event) {	    
    //定义经纬度坐标
    JWPoint = [116.397428, 39.90923];
    //加载地图，调用浏览器定位服务
	var map = new AMap.Map("container", {
        resizeEnable: true,
		zoom: 18,
		center: JWPoint
    });
    //获取经纬度
    getPosition(map);
}

/**
 * 逆地理编码函数
 * @param point
 */
function regeocoder(point) {
    var geocoder = new AMap.Geocoder({
        radius: 1000,
        extensions: "all"
    });        
    geocoder.getAddress(point, function(status, result) {
        if (status === 'complete' && result.info === 'OK') {
            geocoder_CallBack(result);
        }
    });   
}
/**
 * 显示数据 当前地点
 * @param data
 */
function geocoder_CallBack(data) {
    var address = data.regeocode.formattedAddress; //返回地址描述
//    document.getElementById("result").innerHTML = address;
    $$('nowSite').innerHTML = address;
}

/**
 * 添加标注点
 * @param map 地图
 * @param point 经纬度
 */
function addMarker(map, point){
    var marker = new AMap.Marker({
        map: map,
        position: point
    });
    map.setFitView();
}
/**
 * 显示数据 经纬度
 * @param point
 */
function showJW(point){
	$$('jd').innerHTML = point[0];
	$$('wd').innerHTML = point[1];
}

/**
 * 定位，获取经纬度
 * @param map
 */
function getPosition(map){
	var geolocation;
	map.plugin('AMap.Geolocation', function() {
        geolocation = new AMap.Geolocation({
            enableHighAccuracy: true,//是否使用高精度定位，默认:true
            timeout: 10000,          //超过10秒后停止定位，默认：无穷大
            buttonOffset: new AMap.Pixel(20, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
            zoomToAccuracy: true,      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
            buttonPosition:'RB'
        });
        map.addControl(geolocation);
        geolocation.getCurrentPosition();
        AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
        AMap.event.addListener(geolocation, 'error', onError);      //返回定位出错信息
    });
    //解析定位结果
    function onComplete(data) {
    	//添加标注点
    	var JWPoint = [data.position.getLng(),data.position.getLat()];
    	addMarker(map, JWPoint);

        //运行显示经纬度函数
        showJW(JWPoint);        

        //运行逆地理编码函数
        regeocoder(JWPoint);
    	
        var str=['定位成功'];
        if(data.accuracy){
             str.push('精度：' + data.accuracy + ' 米');
        }//如为IP精确定位结果则没有精度信息
        str.push('是否经过偏移：' + (data.isConverted ? '是' : '否'));
        $$('location').innerHTML = str.join('<br>');
//        alert(str.join('\n'));
    }
    //解析定位错误信息
    function onError(data) {
        $$('location').innerHTML = '定位失败';
    }
}

/**
 * 签到函数
 */
function signUp(){
	//获取经纬度
	var jd = $$('jd').innerHTML;
	var wd = $$('wd').innerHTML;
	//获取用户名
	var username = $$('username').innerHTML;
	//获取当前时间
	var time = getDate();
	//获取考勤时间
	var ad = $$('ad-times').innerHTML;
	//获取考勤地点
	var jwName = $$('nowSite').innerHTML;
	var ads = ad.split("~");
	
//	alert(timeCompare("08:40:00","08:40:01"));

	var myDate = new Date();
	var hour=myDate.getHours();       //获取当前小时数(0-23)
	
//	alert(jd+"\n"+wd+"\n"+username+"\n"+time);
	username=username.replace(/\s/g,"");
//	alert("a"+username+"a");
	if(username=='null' || username=='未登录'){
		alert('您还没有登录哦~');
	}
	//没有考勤班次不允许考勤
	else if(ads[0]=='未获取信息'){
		alert('未获取考勤班次信息');
	}
	//上班前两小时内允许考勤，更早的的时间不允许考勤
	else if(timeSub(ads[0],getTime())>60*60*2){
		alert('现在还不是签到时间哦~');
	}
	//没到下班时间提醒会早退
	else if(timeSub(ads[1],getTime())>0 && timeSub(getTime(),"12:00:00")>0 ){
		var msg = "现在还没到下班时间哦~\n您确定要签退吗？\n\n请确认！"
		if (confirm(msg) == true){
			link();
		}
	}
	else{
		link();
	}
	
	function link(){
		window.open("/YQ/attendance/signUp?" +
				"username="+username+
				"&jd="+jd+
				"&wd="+wd+
				"&time="+time+
				"&jwName="+jwName
				,"_self");
	}
}



