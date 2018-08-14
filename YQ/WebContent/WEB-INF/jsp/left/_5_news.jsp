<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.lgwind.util.*"%>
<%@ page import="com.lgwind.dao.*"%>
<%@ page import="com.lgwind.domain.*"%>
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
	
	List<News> newsList = NewsUtil.news(usernameLgwind);
	List<News> newsList2 = NewsUtil.news("添加企业申请", 0);
	List<News> newsList3 = NewsUtil.news("企业管理员申请", 0);
%>
<div class="news-left">
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
		<%if(usernameLgwind==null || usernameLgwind.equals("未登录")){} else{%>
		<li class='menu' 
			onclick='window.open("${pageContext.request.contextPath }/page/news/myApply","_self")'>
			我的申请
			<%if(newsList.size()!=0) {%>
			<span class="news-num"><%=newsList.size() %></span>
			<%} %>
		</li>
		<%if(userroleLgwind.equals("管理员") || 
		        userroleLgwind.equals("超级管理员")){%>	
		<li class='menu' 
			onclick='window.open("${pageContext.request.contextPath }/page/news/companyAdd","_self")'>
			添加企业申请
			<%if(newsList2.size()!=0) {%>
			<span class="news-num"><%=newsList2.size() %></span>
			<%} %>
		</li>		
		<li class='menu' 
			onclick='window.open("${pageContext.request.contextPath }/page/news/companyUserAdd","_self")'>
			企业管理员申请
			<%if(newsList3.size()!=0) {%>
			<span class="news-num"><%=newsList3.size() %></span>
			<%} %>
		</li>
		<%} %>
		<%} %>
	</ul>
</div>