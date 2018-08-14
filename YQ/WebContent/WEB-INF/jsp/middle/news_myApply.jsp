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
	
	List<News> newsList = NewsUtil.news(usernameLgwind);
	
%>
<div class="message-middle">
	<h1>我的申请-消息</h1>
	<div class="message">
	<table>
			<tr>
				<th class='message-name'>序号</th>
				<th class='message-message2'>消息</th>
				<th class='message-op'>操作</th>
			</tr>
			<%for(int i=0; i<newsList.size(); i++){ %>
			<tr>
				<td class="message-name"><%=i+1 %></td>
				<td class="message-message">
					<div class="message2">
						<form id='companyAdd-form<%=i %>' action="${pageContext.request.contextPath }/news/companyAdd"
							method="post">
							<p>
								<span>消息ID：</span><input name='id' type='text'
									value='<%=newsList.get(i).getId()%>' readonly="readonly" />
							</p>
							<p>
								<span>消息类型：</span><input name='itype' type='text'
									value='<%=newsList.get(i).getItype()%>' readonly="readonly" />
							</p>
							<p>
								<span>申请用户名：</span><input name='username' type='text'
									value='<%=newsList.get(i).getUsername()%>' readonly="readonly" />
							</p>
							<%if(newsList.get(i).getCompany()!=null){ %>
							<p>
								<span>企业名：</span><input name='company' type='text' value='<%=newsList.get(i).getCompany()%>' readonly="readonly" />
							</p>
							<%} %>
							<p>
								<span>申请理由：</span><input name='reason' type='text' value='<%=newsList.get(i).getReason()%>'  readonly="readonly"/>
							</p>
							<p>
								<span>申请时间：</span><input name='time' type='text' value='<%=newsList.get(i).getTime()%>'  readonly="readonly"/>
							</p>
							<%if(newsList.get(i).getFinish()==0){ %>
							<p><input class="submit" type='button' value="正在等待处理"/></p>
							<%}else if(newsList.get(i).getFinish()==2){ %>
							<p><input class="submit" type='button' value="通过"/></p>
							<%}else if(newsList.get(i).getFinish()==3){ %>
							<p><input class="submit" type='button' value="不通过"/></p>
							<%} %>
						</form>
					</div>
				</td>
				<td class="message-op" onclick='var msg = "是否不在显示此消息？";
		if (confirm(msg) == true){window.open("${pageContext.request.contextPath }/news/read?id=<%=newsList.get(i).getId()%>","_self")}'><a>不在显示此消息</a></td>
			</tr>
			<%} %>
		</table>
	</div>
</div>