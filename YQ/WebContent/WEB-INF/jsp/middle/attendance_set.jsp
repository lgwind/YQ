<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.lgwind.util.*"%>
<%@ page import="com.lgwind.view.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-attendance_set.css" />
<script src="${pageContext.request.contextPath }/js/js-attendance_set.js"></script>
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
	
	ADSet adSet = new ADSet(usernameLgwind);
	
%>
<div class="ad-set-middle">
	<h1>设置考勤地点</h1>
	<div class="message">
	<table>
	<tr><th>用户名</th><th>考勤地点</th></tr>
	<tr><td class="message-name"><%=usernameLgwind %></td>
	    <td class="message-message">
	    <div class="message2">
	    <p title='点击设置为考勤地点' onclick='window.open("${pageContext.request.contextPath }/attendance/set?username=<%=usernameLgwind%>&num=1","_self");'><span>考勤地点1：</span>(<%=adSet.getJd1() %>,<%=adSet.getWd1() %>)<%=adSet.getJwName1() %></p>
	    <p title='点击设置为考勤地点' onclick='window.open("${pageContext.request.contextPath }/attendance/set?username=<%=usernameLgwind%>&num=2","_self");'><span>考勤地点2：</span>(<%=adSet.getJd2() %>,<%=adSet.getWd2() %>)<%=adSet.getJwName2() %></p>
	    <p title='点击设置为考勤地点' onclick='window.open("${pageContext.request.contextPath }/attendance/set?username=<%=usernameLgwind%>&num=3","_self");'><span>考勤地点3：</span>(<%=adSet.getJd3() %>,<%=adSet.getWd3() %>)<%=adSet.getJwName3() %></p>
	    <p><span>默认考勤地点：</span>(<%=adSet.getJd() %>,<%=adSet.getWd() %>)<%=adSet.getJwName() %></p>
	    </div>
	    </td>
	    </tr>
	</table>
	</div>
</div>