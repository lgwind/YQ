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
	<h1>用户信息表管理</h1>
	<form id="message-form" name='message-form' action="${pageContext.request.contextPath }/set/data/add" method="post">
	<input name='username' class='message-input' type='text' placeholder="搜索/添加的用户名" value='${messageInput }'/>
	<input title='点击添加用户' class='message-search' type="button" value='搜' onclick='submit_form("/YQ/set/data/search");'/>
	<input title='点击添加用户' class='message-add' type="button" value='+' onclick='submit_form("/YQ/set/data/add")'/>
	</form>
	<div class="message">
	<table>
	<tr><th class='message-th1'>用户名</th><th class='message-th2'>用户信息</th><th class='message-th3'>操作</th></tr>
	<c:forEach items="${dataList }" var="item">
	<tr id="message-${item.username }"><td class="message-name">${item.username }</td>
	    <td class="message-message">
	    <div class="message2">
	    <form action="${pageContext.request.contextPath }/set/data/update" method="post">
	    <input name='username' class="name" type="text" value='${item.username }' />
	    <p><span>姓名：</span><input name='name' type='text' value='${item.name }'/></p>
	    <p><span>头像：</span><input name='icon' type='text' value='${item.icon }'/></p>
	    <p><span>性别：</span><input name='sex' type='text' value='${item.sex }'/></p>
	    <p><span>电话：</span><input name='phone' type='text' value='${item.phone }'/></p>
	    <p><span>邮箱：</span><input name='email' type='text' value='${item.email }'/></p>
	    <p><span>生日：</span><input name='birthday' type='date' value='${item.birthday }'/></p>
	    <p><span>所属企业：</span><input name='company' type='text' value='${item.company }'/></p>
	    <p><span>职位：</span><input name='position' type='text' value='${item.position }'/></p>
	    <p><span>地址：</span><input name='address' type='text' value='${item.address }'/></p>
	    <p><span>默认考勤地点：</span><input name='jwd' type='text' value='${item.jwd }'/></p>
	    <p><input class="submit" type='submit' value="确认修改"/></p>
	    </form>
	    </div>
	    </td>
	    <td class="message-op" onclick='var msg = "你确定要删除？";
		if (confirm(msg) == true){window.open("${pageContext.request.contextPath }/set/data/delete?username=${item.username }","_self")}'><a>删除</a></td></tr>
	</c:forEach>
	</table>
	</div>
</div>