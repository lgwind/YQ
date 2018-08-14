<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.lgwind.util.*"%>
<%@ page import="com.lgwind.view.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-attendance_record.css" />
<script src="${pageContext.request.contextPath }/js/js-attendance_record.js"></script>
<%
	//获得登录的用户名\角色\登录页面
	String usernameLgwind;
	String userroleLgwind;
	String pageLgwind;
	//获取登录的用户名
	if (UserUtil.username.equals("还没保存用户名哦~")) {
		usernameLgwind = (String) session.getAttribute("usernameLgwind");
	} else {
		usernameLgwind = UserUtil.username;
		UserUtil.username = "还没保存用户名哦~";
	}
	//获取登录的角色
	if (UserUtil.userrole.equals("还没保存用户角色哦~")) {
		userroleLgwind = (String) session.getAttribute("userroleLgwind");
	} else {
		userroleLgwind = UserUtil.userrole;
		UserUtil.userrole = "还没保存用户角色哦~";
	}
	//将登录的用户名和角色放入session
	session.setAttribute("usernameLgwind", usernameLgwind);
	session.setAttribute("userroleLgwind", userroleLgwind);
	
	SignUp signUp=ADUtil.adMessage(usernameLgwind);
	
%>
<div class="record-middle">
	<h1><%=usernameLgwind%>的考勤记录
	</h1>
	<div class='record-div' title="点击选择日期">
		<div class='record-title'>日期：
	<input id='record-date' class='date-input' type='date' value="${record_date }" /></div>
		<div class='recond-content'>
			<div class='record-content-1'>
				<span class="record-font">上</span>打卡时间&nbsp;&nbsp;${record.amTime }
				&nbsp;&nbsp;考勤班次(<%=signUp.getStartTime() %>~<%=signUp.getLastTime() %>)
			</div>
			<div class='record-content-2'>
			           ${record.amJWName }
			</div>
			<div class='record-content-3'>
			           ${record.amStatus }
			</div>
		</div>
		<div class='recond-content'>
			<div class='record-content-1'>
				<span class="record-font">下</span>打卡时间&nbsp;&nbsp;${record.pmTime }
				&nbsp;&nbsp;考勤班次(<%=signUp.getStartTime() %>~<%=signUp.getLastTime() %>)
			</div>
			<div class='record-content-2'>
			           ${record.pmJWName }
			</div>
			<div class='record-content-3'>
			           ${record.pmStatus }
			</div>
		</div>
	</div>


	
</div>