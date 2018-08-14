<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.lgwind.util.*"%>
<%@ page import="com.lgwind.dao.*"%>
<%@ page import="java.util.List" %>
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
	
	List<AD> adList = new ADDao().getAll();
%>
<div class='record-title2'>考勤记录表管理
</div>
<div class='record-right'>
    <table>
<%--     <tr><th class='record-title2' colspan='2'><%=usernameLgwind %>的考勤记录</th></tr> --%>
    <%
      for(int i=0;i<adList.size();i++){ %>
        <tr><td onclick='window.open("#message-<%=adList.get(i).getUsername() %>-<%=adList.get(i).getAdTime() %>","_self")'><%=adList.get(i).getUsername() %>&nbsp;<%=adList.get(i).getAdTime() %></td></tr>
    <%}%>
    </table>
</div>
