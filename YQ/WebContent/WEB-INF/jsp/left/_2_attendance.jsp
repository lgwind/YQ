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
			onclick='window.open("${pageContext.request.contextPath }/page/attendance/signUp","_self")'>
			打卡
		</li>
		<%if(usernameLgwind==null || usernameLgwind.equals("未登录")){} else{%>
		<li class='menu' 
			onclick='window.open("${pageContext.request.contextPath }/page/attendance/record?username=<%=usernameLgwind %>","_self")'>
			考勤记录
		</li>
		<%if(userroleLgwind.equals("企业管理员") || 
		        userroleLgwind.equals("管理员") || 
		        userroleLgwind.equals("超级管理员")){%>
		<li class='menu' 
			onclick='window.open("${pageContext.request.contextPath }/page/attendance/recordCompany?username=<%=usernameLgwind %>","_self")'>
			员工考勤记录
		</li>
		<%} %>
		<li class='menu' 
			onclick='window.open("${pageContext.request.contextPath }/page/attendance/apply","_self")'>
			企业相关申请
		</li>
		<li class='menu' 
			onclick='window.open("${pageContext.request.contextPath }/page/attendance/set","_self")'>
			设置考勤地点
		</li>
		<%if(userroleLgwind.equals("企业管理员") || 
		        userroleLgwind.equals("管理员") || 
		        userroleLgwind.equals("超级管理员")){%>
		<li class='menu' 
			onclick='window.open("${pageContext.request.contextPath }/page/attendance/companyPerson","_self")'>
			企业信息完善
		</li>
		<%} %>		
		<%if(userroleLgwind.equals("管理员") || 
		        userroleLgwind.equals("超级管理员")){%>
		<li class='menu' 
			onclick='window.open("${pageContext.request.contextPath }/page/attendance/company","_self")'>
			企业信息管理
		</li>
		<%} %>
		<li class='menu' 
			onclick='window.open("${pageContext.request.contextPath }/page/attendance/messagePerson","_self")'>
			个人信息完善
		</li>
		<%if(userroleLgwind.equals("管理员") || 
		        userroleLgwind.equals("超级管理员")){%>
		<li class='menu' 
			onclick='window.open("${pageContext.request.contextPath }/page/attendance/message","_self")'>
			用户信息管理
		</li>
		<%}} %>
	</ul>
</div>