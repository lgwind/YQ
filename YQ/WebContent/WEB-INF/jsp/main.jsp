<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.lgwind.util.UserUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.lgwind.util.*"%>
<%@ page import="com.lgwind.dao.*"%>
<%@ page import="com.lgwind.domain.*"%>
<%
	//获得登录的用户名\角色\登录页面
	String usernameLgwind;
	String userroleLgwind;
	String pageLgwind;
	String subpageLgwind;
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
	//获取登录页面
	if (UserUtil.page.equals("null")){
		pageLgwind = (String) session.getAttribute("pageLgwind");
	} else{
		pageLgwind = UserUtil.page;
		UserUtil.page = "null";
	}
	//获取登录页面子页面
	if (UserUtil.subpage.equals("null")){
		subpageLgwind = (String) session.getAttribute("subpageLgwind");
	} else{
	    subpageLgwind = UserUtil.subpage;
		UserUtil.subpage = "null";
	}
	System.out.println("登录的用户为"+userroleLgwind+"：" + usernameLgwind);
	System.out.println("页面定位："+pageLgwind+"-"+subpageLgwind);
	//将登录的用户名和角色放入session
	session.setAttribute("usernameLgwind", usernameLgwind);
	session.setAttribute("userroleLgwind", userroleLgwind);
	session.setAttribute("pageLgwind", pageLgwind);
	session.setAttribute("subpageLgwind", subpageLgwind);
	
	List<News> newsList = NewsUtil.news(usernameLgwind);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>易签-<%=pageLgwind %><%if(!subpageLgwind.equals("")){ %>-<% } %><%=subpageLgwind %></title>
<!-- 引入外部css样式 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-lgwind.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-main.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-left.css" />
<!-- 引入外部js代码 -->
<script src="${pageContext.request.contextPath }/js/jquery-3.2.0.js"></script>
<script src="${pageContext.request.contextPath }/js/js-lgwind.js"></script>
</head>
<body>
	<div class='all'>
		<!-- 顶部菜单栏 -->
		<div class='top'>
			<!-- 菜单选项 -->
			<div class='menu-top'>
			    <span class='menu' 
			          onclick='window.open("${pageContext.request.contextPath }/page/home","_self")'>
			                      首页
			    </span>
			    <span class='menu' 
			          onclick='window.open("${pageContext.request.contextPath }/page/attendance","_self")'>
			                      考勤
			    </span>
			    <span class='menu' 
			          onclick='window.open("${pageContext.request.contextPath }/page/forum","_self")'>
			                      论坛
			    </span>
			    <span class='menu' 
			          onclick='window.open("${pageContext.request.contextPath }/page/friend","_self")'>
			                      好友
			    </span>
			    <span class='menu' 
			          onclick='window.open("${pageContext.request.contextPath }/page/news","_self")'>
			                      消息
			<%if(newsList.size()!=0) {%>
			<span class="news-num-little"><%=newsList.size() %></span>
			<%} %>
			    </span>
			    <span class='menu' 
			          onclick='window.open("${pageContext.request.contextPath }/page/set","_self")'>
			                      设置
			    </span>
			</div>
			<!-- 个人选项 -->
			<!-- 个人头像+登录 -->
			<div class='image-top'>
				<%if(usernameLgwind==null || usernameLgwind.equals("未登录")){ %>
				<img class='i-image' alt="未登录"
					src="${pageContext.request.contextPath }/image/unlogin.jpg"
					width='25px' height='25px' 
					onclick='window.open("${pageContext.request.contextPath }/page/me","_self")'/>
				<%}else{ %>
				<img class='i-image' alt="未登录"
					src="${pageContext.request.contextPath }/image/login.jpg"
					width='25px' height='25px' 
					onclick='window.open("${pageContext.request.contextPath }/page/me","_self")'/>
				<%} %>
				<div class='login-top'>
				    <form id='login-form' action="${pageContext.request.contextPath }/page/me/login">
				        <table>
				        <tr>
				        <%if(usernameLgwind==null || usernameLgwind.equals("未登录")){ %>
				        <td><input type='submit' class='submit-lgwind' value='登录' /></td>
				        <%}else{ %>
				        <td><input type='button' class='submit-lgwind' value='退出' 
				        onclick='window.open("${pageContext.request.contextPath }/user/loginExit","_self")' /></td>
				        <%} %>
				        </tr>
				        <tr><td><a href='${pageContext.request.contextPath }/page/me/register'>点这里注册哦~</a></td></tr>
				        </table>
				    </form>
				</div>
			</div>
			<div class='i-top'>			    
			    <span class='menu' onclick='window.open("${pageContext.request.contextPath }/page/attendance/record?username=<%=usernameLgwind %>","_self")'>
			                     考勤记录</span>
			    <span class='menu'>我的收藏</span>
			    <span class='menu'>历史</span>
			    <span class='menu'>帮助</span>
			</div>
		</div>

		<!-- 左部菜单 -->
		<div class="left">
			<!-- 改变选择页面 -->
			<%
			    if (pageLgwind.equals("首页")) {
			%>
			<jsp:include page="left/_1_home.jsp"></jsp:include>
			<%
			    } else if (pageLgwind.equals("考勤")) {
			%>
			<jsp:include page="left/_2_attendance.jsp"></jsp:include>
			<%
			    } else if (pageLgwind.equals("论坛")) {
			%>
			<jsp:include page="left/_3_forum.jsp"></jsp:include>
			<%
			    } else if (pageLgwind.equals("好友")) {
			%>
			<jsp:include page="left/_4_friend.jsp"></jsp:include>
			<%
			    } else if (pageLgwind.equals("消息")) {
			%>
			<jsp:include page="left/_5_news.jsp"></jsp:include>
			<%
			    } else if (pageLgwind.equals("设置")) {
			%>
			<jsp:include page="left/_6_set.jsp"></jsp:include>
			<%
			    } else if (pageLgwind.equals("我")) {
			%>
			<jsp:include page="left/_7_me.jsp"></jsp:include>
			<%} %>
		</div>
		<!-- 中部主页面 -->
		<div class="middle">
		   <!-- 改变选择页面 -->
			<%
			    if (subpageLgwind.equals("登录")) {
			%>
			<!-- 若未登录则显示未登录界面 -->
			<%if(usernameLgwind==null || usernameLgwind.equals("未登录")){ %>
			<jsp:include page="middle/me_login.jsp"></jsp:include>
			<%} else{%>			
			<jsp:include page="middle/me_login_already.jsp"></jsp:include>
			<%} %>
			<%
			    } else if (subpageLgwind.equals("注册")) {
			%>
			<jsp:include page="middle/me_register.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("密码修改")) {
			%>
			<jsp:include page="middle/me_passwordUpdate.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("个人信息完善")) {
			%>
			<jsp:include page="middle/me_message_person.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("用户信息管理")) {
			%>
			<jsp:include page="middle/me_message.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("打卡")) {
			%>
			<jsp:include page="middle/attendance_signUp.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("考勤记录")) {
			%>
			<jsp:include page="middle/attendance_record.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("员工考勤记录")) {
			%>
			<jsp:include page="middle/attendance_record_company.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("企业信息完善")) {
			%>
			<jsp:include page="middle/attendance_company_person.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("企业信息管理")) {
			%>
			<jsp:include page="middle/attendance_company.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("设置考勤地点")) {
			%>
			<jsp:include page="middle/attendance_set.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("企业相关申请")) {
			%>
			<jsp:include page="middle/attendance_apply.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("我的申请")) {
			%>
			<jsp:include page="middle/news_myApply.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("添加企业申请")) {
			%>
			<jsp:include page="middle/news_companyAdd.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("企业管理员申请")) {
			%>
			<jsp:include page="middle/news_companyUserAdd.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("用户登录表管理")) {
			%>
			<jsp:include page="middle/set_table_user.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("用户信息表管理")) {
			%>
			<jsp:include page="middle/set_table_data.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("消息表管理")) {
			%>
			<jsp:include page="middle/set_table_news.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("企业信息表管理")) {
			%>
			<jsp:include page="middle/set_table_company.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("考勤记录表管理")) {
			%>
			<jsp:include page="middle/set_table_ad.jsp"></jsp:include>
			<%} else {%>
			<jsp:include page="middle/home.jsp"></jsp:include>
			<%} %>
		</div>		
		<!-- 右部副页面 -->
		<div class="right">
		    <%
			    if (subpageLgwind.equals("打卡")) {
			%>
			<jsp:include page="right/attendance_signUp.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("考勤记录")) {
			%>
			<jsp:include page="right/attendance_record.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("员工考勤记录")) {
			%>
			<jsp:include page="right/attendance_record_company.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("企业信息管理")) {
			%>
			<jsp:include page="right/attendance_company.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("用户信息管理")) {
			%>
			<jsp:include page="right/me_message.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("用户登录表管理")) {
			%>
			<jsp:include page="right/set_table_user.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("用户信息表管理")) {
			%>
			<jsp:include page="right/set_table_data.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("消息表管理")) {
			%>
			<jsp:include page="right/set_table_news.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("企业信息表管理")) {
			%>
			<jsp:include page="right/set_table_company.jsp"></jsp:include>
			<%
			    } else if (subpageLgwind.equals("考勤记录表管理")) {
			%>
			<jsp:include page="right/set_table_ad.jsp"></jsp:include>
			<%} else{ %>
			<jsp:include page="right/home.jsp"></jsp:include>
			<%} %>
		</div>
	</div>

</body>
</html>