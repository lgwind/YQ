<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.lgwind.util.UserUtil"%>
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
<div class="attendance-left">
    <div onclick='window.open("${pageContext.request.contextPath }/page/attendance/signUp","_self")'>
    <%if(usernameLgwind==null || usernameLgwind.equals("未登录")){ %>
    <img class='image-left' alt="未登录"
					src="${pageContext.request.contextPath }/image/unlogin.jpg"/>
	<%}else{ %>	
    <img class='image-left' alt="未登录"
					src="${pageContext.request.contextPath }/image/login.jpg"/>
	<%} %>
	<div id="username" class='username-left'>
	   <%if(usernameLgwind==null){ %>未登录<%} else{%>
	   <%=usernameLgwind %>
	   <%} %>
	</div>
	</div>
	<ul class='left-ul'>
		<li class='menu' 
			onclick='window.open("${pageContext.request.contextPath }/page/attendance","_self")'>
			考勤
		</li>
		<li class='menu' 
			onclick='window.open("${pageContext.request.contextPath }/page/forum","_self")'>
			论坛
		</li>
		<li class='menu' 
			onclick='window.open("${pageContext.request.contextPath }/page/friend","_self")'>
			好友
		</li>
		<li class='menu' 
			onclick='window.open("${pageContext.request.contextPath }/page/news","_self")'>
			消息
		</li>
		<li class='menu' 
			onclick='window.open("${pageContext.request.contextPath }/page/set","_self")'>
			设置
		</li>
		<li class='menu' 
			onclick='window.open("${pageContext.request.contextPath }/page/me","_self")'>
			我
		</li>
	</ul>
</div>