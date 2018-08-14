<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.lgwind.util.*"%>
<%@ page import="com.lgwind.view.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-me_message.css" />
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
<div class="message-middle">
	<h1>考勤记录表管理</h1>
	<form id="message-form" name='message-form' action="${pageContext.request.contextPath }/me/data/add" method="post">
	<input name='username' class='message-input' type='text' placeholder="搜索/添加的用户名" value='${messageInput }'/>
	<input title='点击添加用户' class='message-search' type="button" value='搜' onclick='submit_form("/YQ/me/data/search");'/>
	<input title='点击添加用户' class='message-add' type="button" value='+' onclick='submit_form("/YQ/me/data/add")'/>
	</form>
	<div class="message">
	<table>
	<tr><th class='message-th1'>用户名</th><th class='message-th2'>用户信息</th><th class='message-th3'>操作</th></tr>
	<c:forEach items="${adList }" var="item">
	<tr id="message-${item.username}-${item.adTime}"><td class="message-name">${item.username }<br>${item.adTime }</td>
	    <td class="message-message">
	    <div class="message2">
	    <form action="${pageContext.request.contextPath }/me/data/update" method="post">
	    <p><span>用户名：</span><input name='username' type='text' value='${item.username }'/></p>
	    <p><span>考勤时间：</span><input name='adTime' type='text' value='${item.adTime }'/></p>
	    <p><span>经度：</span><input name='jd' type='text' value='${item.jd }'/></p>
	    <p><span>纬度：</span><input name='wd' type='text' value='${item.wd }'/></p>
	    <p><span>签到地点：</span><input name='jwName' type='text' value='${item.jwName }'/></p>
	    <p><span>签到距离：</span><input name='scope' type='text' value='${item.scope }'/></p>
	    <p><span>签到时间：</span><input name='time' type='text' value='${item.time }'/></p>
	    <p><span>考勤状态：</span><input name='status' type='text' value='${item.status }'/></p>
	    <p><input class="submit" type='submit' value="确认修改"/></p>
	    </form>
	    </div>
	    </td>
	    <td class="message-op" onclick='var msg = "你确定要删除？";
		if (confirm(msg) == true){window.open("${pageContext.request.contextPath }/me/data/delete?username=${item.username }","_self")}'><a>删除</a></td></tr>
	</c:forEach>
	</table>
	</div>
</div>