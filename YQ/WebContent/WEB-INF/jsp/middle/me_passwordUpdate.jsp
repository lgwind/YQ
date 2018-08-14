<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-me-register.css" />
<%@ page import="com.lgwind.util.*"%>
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
	//将登录的用户名和角色放入session
	session.setAttribute("usernameLgwind", usernameLgwind);
	session.setAttribute("userroleLgwind", userroleLgwind);
	session.setAttribute("pageLgwind", pageLgwind);
	session.setAttribute("subpageLgwind", subpageLgwind);
%>
<div class="register-middle">
    <h2>密码修改</h2>
	<form class='register-form' action="${pageContext.request.contextPath }/user/passwordUpdate">
	<table>
	<tr><td><input type="text" class='hidden' placeholder="用户名" name='username' value='<%=usernameLgwind %>' />
	<input type="password" class='input-register' placeholder="原密码" name='password0' value='${password.password0 }' /></td></tr>
	<tr><td><input type="password" class='input-register' placeholder="新密码" name='password' value='${password.password }' /></td></tr>
	<tr class='register-tr'><td><input type="password" class='input-register' placeholder="确认密码" name='password2' value='${password.password2 }' /></td></tr>
	<tr><td><input type="submit" class='submit-register' value='确认修改'/></td></tr>
	</table>
	</form>
	<div class='register-result'>${passwordUpdateResult }</div>
</div>