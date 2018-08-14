<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.lgwind.util.*"%>
<%@ page import="com.lgwind.view.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-attendance_company.css" />
<script src="${pageContext.request.contextPath }/js/js-attendance_company.js"></script>
<script src="${pageContext.request.contextPath }/js/js-me_message.js"></script>
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
	
%>
<div class="company-middle">
	<h1>企业信息管理</h1>
	<form id="message-form" name='message-form' action="${pageContext.request.contextPath }/me/data/add" method="post">
	<input name='companyName' class='message-input' type='text' placeholder="搜索/添加的用户名" value='${messageInput}'/>
	<input title='点击添加用户' class='message-search' type="button" value='搜' onclick='submit_form("/YQ/attendance/company/search");'/>
	<input title='点击添加用户' class='message-add' type="button" value='+' onclick='submit_form("/YQ/attendance/company/add")'/>
	</form>
	<div class="company">
	<table>
	<tr><th class='message-th1'>企业名称</th><th class='message-th2'>考勤信息</th><th class='message-th3'>操作</th></tr>
	<c:forEach items="${company }" var="item">
	<tr id="message-${item.companyName }"><td class="company-name">${item.companyName }</td>
	    <td class="company-message">
	    <div class="message">
	    <form action="${pageContext.request.contextPath }/attendance/company/update" method="post">
	    <input name='companyName' class="name" type="text" value='${item.companyName }' />
	    <p><span>考勤班次：</span><input name='startTime' class="time" type='text' value='${item.startTime }'/>~
	                           <input name='lastTime' class="time" type='text' value='${item.lastTime }'/></p>
	    <p><span>经纬度1：</span><input name='jd' class="time" type='text' value='${item.jd }'/>&nbsp;&nbsp;<input name='wd' class="time" type='text' value='${item.wd }'/></p>
	    <p><span>经纬度2：</span><input name='jd2' class="time" type='text' value='${item.jd2 }'/>&nbsp;&nbsp;<input name='wd2' class="time" type='text' value='${item.wd2 }'/></p>
	    <p><span>经纬度3：</span><input name='jd3' class="time" type='text' value='${item.jd3 }'/>&nbsp;&nbsp;<input name='wd3' class="time" type='text' value='${item.wd3 }'/></p>
	    <p><span>考勤地点1：</span><textarea name='jwName' cols="30" rows='1'>${item.jwName }</textarea></p>
	    <p><span>考勤地点2：</span><textarea name='jwName2' cols="30" rows='1'>${item.jwName2 }</textarea></p>
	    <p><span>考勤地点3：</span><textarea name='jwName3' cols="30" rows='1'>${item.jwName3 }</textarea></p>
	    <p><span>考勤范围(m)：</span><input name='scope' type='text' value='${item.scope }'/></p>
	    <p><input class="submit" type='submit' value="确认修改"/></p>
	    </form>
	    </div>
	    </td>
	    <td class="company-op" onclick='var msg = "你确定要删除？";
		if (confirm(msg) == true){window.open("${pageContext.request.contextPath }/attendance/company/delete?companyName=${item.companyName }","_self")}'><a>删除</a></td></tr>
	</c:forEach>
	</table>
	</div>
</div>