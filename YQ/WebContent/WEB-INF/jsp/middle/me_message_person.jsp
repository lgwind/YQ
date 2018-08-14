<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.lgwind.util.*"%>
<%@ page import="com.lgwind.dao.*"%>
<%@ page import="com.lgwind.domain.*"%>
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
	
	Data data = new DataDao().get(usernameLgwind);
	
%>
<div class="message-middle">
	<h1>个人信息完善</h1>
	<form action="${pageContext.request.contextPath }/me/data/add" method="post">
	<input name='username' class='message-input2' type='text' value='<%=usernameLgwind%>' readonly="readonly"/>
	<input title='点击添加个人信息' class='message-add' type="submit" value='+'/>
	</form>
	<div class="message">
	<table>
	<tr><th>用户名</th><th>个人信息</th><th>操作</th></tr>
	<%if(data!=null) {%>
	<tr><td class="message-name"><%=data.getUsername() %></td>
	    <td class="message-message">
	    <div class="message2">
	    <form action="${pageContext.request.contextPath }/me/data/update" method="post">
	    <input name='username' class="name" type="text" value='<%=data.getUsername() %>' />
	    <p><span>姓名：</span><input name='name' type='text' value='<%=data.getName() %>'/></p>
	    <p><span>头像：</span><input name='icon' type='text' value='<%=data.getIcon() %>'/></p>
	    <p><span>性别：</span><input name='sex' type='text' value='<%=data.getSex() %>'/></p>
	    <p><span>电话：</span><input name='phone' type='text' value='<%=data.getPhone() %>'/></p>
	    <p><span>邮箱：</span><input name='email' type='text' value='<%=data.getEmail() %>'/></p>
	    <p><span>生日：</span><input name='birthday' type='date' value='<%=data.getBirthday() %>'/></p>
	    <p><span>所属企业：</span><input name='company' type='text' value='<%=data.getCompany() %>'/></p>
	    <p><span>职位：</span><input name='position' type='text' value='<%=data.getPosition() %>'/></p>
	    <p><span>地址：</span><input name='address' type='text' value='<%=data.getAddress() %>'/></p>
	    <p><span>默认考勤地点：</span><input name='jwd' type='text' value='<%=data.getJwd() %>'/></p>
	    <p><input class="submit" type='submit' value="确认修改"/></p>
	    </form>
	    </div>
	    </td>
	    <td class="message-op"></td></tr>
	<%} %>
	</table>
	</div>
</div>