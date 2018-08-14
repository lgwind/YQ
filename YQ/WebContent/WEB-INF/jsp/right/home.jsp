<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.lgwind.util.*"%>
<%@ page import="com.lgwind.view.*"%>
<%@ page import="com.lgwind.dao.*"%>
<%@ page import="com.lgwind.domain.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath }/css/css-home.css" />
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
<div class='home-right'>
    <table>
    <tr><th class='home-title' colspan='2'>用户信息</th></tr>
    <tr><td class='home-td'>用户名：</td><td><%=usernameLgwind %></td></tr>
    <tr><td class='home-td'>角色：</td><td><%=userroleLgwind %></td></tr>
    <tr><td class='home-td'>页面定位：</td><td><%=pageLgwind %><%if(!subpageLgwind.equals("")){ %>-<%}%><%=subpageLgwind %></td></tr>
    </table>
</div>
