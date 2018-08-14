<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.lgwind.util.*"%>
<%@ page import="com.lgwind.dao.*"%>
<%@ page import="com.lgwind.domain.*"%>
<%@ page import="com.lgwind.view.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-attendance_apply.css" />
<script src="${pageContext.request.contextPath }/js/js-me_message.js"></script>
<script src="${pageContext.request.contextPath }/js/js-attendance_apply.js"></script>
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
	<h1>企业相关申请</h1>
	<div class="message">
	<table>
			<tr>
				<th>申请类型</th>
				<th>申请内容</th>
			</tr>
			<tr>
				<td class="message-name">添加企业申请</td>
				<td class="message-message">
					<div class="message2">
						<form id='companyAdd-form' action="${pageContext.request.contextPath }/apply/companyAdd"
							method="post">
							<p>
								<span>申请用户名：</span><input name='username' type='text'
									value='<%=usernameLgwind%>' readonly="readonly" />
							</p>
							<p>
								<span>类型：</span><input name='itype' type='text' value='添加企业申请' readonly="readonly" />
							</p>
							<p>
								<span>企业名：</span><input id='companyAdd-company' name='company' type='text' value='${companyAddNews.company }' />
							</p>
							<p>
								<span>申请理由：</span><input id='companyAdd-reason' name='reason' type='text' value='${companyAddNews.reason }' />
							</p>
							<span class='apply-result'>${companyAddResult }</span>
							<p>
							<input class="submit" type='button' value="确认申请" onclick='companyAdd();'/>
							</p>
						</form>
					</div>
				</td>
			</tr>
			<tr>
				<td class="message-name">企业管理员申请</td>
				<td class="message-message">
					<div class="message2">
						<form id='companyUserAdd-form' action="${pageContext.request.contextPath }/apply/companyUserAdd"
							method="post">
							<p>
								<span>申请用户名：</span><input name='username' type='text'
									value='<%=usernameLgwind%>' readonly="readonly" />
							</p>
							<p>
								<span>类型：</span><input name='itype' type='text' value='企业管理员申请' readonly="readonly" />
							</p>
							<p>
								<span>申请理由：</span><input id='companyUserAdd-reason' name='reason' type='text' value='${companyUserAddNews.reason }' />
							</p>
							<span class='apply-result'>${companyUserAddResult }</span>
							<p>
							<input class="submit" type='button' value="确认申请" onclick='companyUserAdd();'/>
							</p>
						</form>
					</div>
				</td>
			</tr>
		</table>
	</div>
</div>