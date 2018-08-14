<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.lgwind.util.*"%>
<%@ page import="com.lgwind.dao.*"%>
<%@ page import="com.lgwind.domain.*"%>
<%@ page import="com.lgwind.view.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-attendance_record_company.css" />
<script src="${pageContext.request.contextPath }/js/js-me_message.js"></script>
<script src="${pageContext.request.contextPath }/js/js-news.js"></script>
<script src="${pageContext.request.contextPath }/js/js-attendance_record_company.js"></script>
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
	<h1><input id='record-date' class='date-input' type='date' value="${nowDate }" />员工考勤记录</h1>
	<div class="message">
	<table>
			<tr>
				<th class="message-name">用户名</th>
				<th class="message-message2">考勤记录</th>
			</tr>
			<c:forEach items="${companyDate }" var="item">
			<tr>
				<td class="message-name">${item.username }/${item.name }</td>
				<td class="message-message">
					<div class="message2">
						<form id='companyAdd-form' action="${pageContext.request.contextPath }/news/companyAdd"
							method="post">
							<p>
								<span>上午：</span><span class="status" >${item.amStatus }</span><span>${item.amTime }</span>
							</p>
							<p>
								<span>下午：</span><span class="status" >${item.pmStatus }</span><span>${item.amTime }</span>
							</p>
						</form>
					</div>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</div>