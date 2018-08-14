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
	href="${pageContext.request.contextPath }/css/css-attendance_apply.css" />
<script src="${pageContext.request.contextPath }/js/js-me_message.js"></script>
<script src="${pageContext.request.contextPath }/js/js-news.js"></script>
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
	
	List<News> newsList = NewsUtil.news("企业管理员申请", 0);
	
%>
<div class="message-middle">
	<h1>添加企业申请-待处理消息</h1>
	<div class="message">
	<table>
			<tr>
				<th class="message-name">序号</th>
				<th class="message-message2">待处理消息</th>
			</tr>
			<%for(int i=0; i<newsList.size(); i++){ %>
			<tr>
				<td class="message-name"><%=i+1 %></td>
				<td class="message-message">
					<div class="message2">
						<form id='companyAdd-form<%=i %>' action="${pageContext.request.contextPath }/news/companyUserAdd"
							method="post">
							<p>
								<span>消息ID：</span><input name='id' type='text'
									value='<%=newsList.get(i).getId()%>' readonly="readonly" />
							</p>
							<p>
								<span>申请用户名：</span><input name='username' type='text'
									value='<%=newsList.get(i).getUsername()%>' readonly="readonly" />
							</p>
							<p>
								<span>申请理由：</span><input name='reason' type='text' value='<%=newsList.get(i).getReason()%>'  readonly="readonly"/>
							</p>
							<p>
							<input class='hidden-input' name='itype' type='text' value='<%=newsList.get(i).getItype()%>' />
							<input class='hidden-input' name='time' type="datetime" value='<%=newsList.get(i).getTime()%>' />
							<input id='companyAdd-finish<%=i %>' class='hidden-input' name='finish' type='text' value='<%=newsList.get(i).getFinish()%>' />
							<input class="submit" type='button' value="通过" onclick='companyAdd(<%=i%>,2);'/>
							<input class="submit" type='button' value="不通过" onclick='companyAdd(<%=i%>,3);'/>
							</p>
						</form>
					</div>
				</td>
			</tr>
			<%} %>
		</table>
	</div>
</div>