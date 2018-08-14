<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.lgwind.util.IData"%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
<link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.4.6&key=3491a6e5494461d9c8bce6b222984ba8&plugin=AMap.Geocoder"></script>
<script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
    
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath }/css/css-attendance_signUp.css" />
<script src="${pageContext.request.contextPath }/js/js-attendance_signUp.js"></script>

<%
    //判断签到还是签退
    String signUpName="签到";
    if(IData.hour()>12){
        signUpName="签退";
    }
%>
<div id="container"></div>
<div class='signUp-middle'><input class='signUp-input' type='button' value='<%=signUpName %>' onclick='signUp();' />
</div>
