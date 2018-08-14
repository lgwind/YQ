<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.lgwind.util.*"%>
<%@ page import="com.lgwind.view.*"%>
<%@ page import="com.lgwind.dao.*"%>
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
	
	SignUp signUp=ADUtil.adMessage(usernameLgwind);
	
%>
<div class='signUp-right'>
    <table>
    <tr><th class='signUp-title' colspan='2'>考勤信息</th></tr>
    <tr><td class='signUp-td' valign="top">考勤地点：</td><td id='jw-name'><%=signUp.getJwName() %></td></tr>
    <tr><td class='signUp-td' valign="top">用户名：</td><td id='username'><%=usernameLgwind %></td></tr>
    <tr><td class='signUp-td' valign="top">经度：</td><td><%=signUp.getJd() %></td></tr>
    <tr><td class='signUp-td' valign="top">纬度：</td><td><%=signUp.getWd() %></td></tr>
    <tr><td class='signUp-td' valign="top">考勤范围：</td><td><%=signUp.getScope() %>米</td></tr>
    <tr><td class='signUp-td' valign="top">考勤班次：</td><td id='ad-times'><%=signUp.getStartTime() %>~<%=signUp.getLastTime() %></td></tr>
    <tr><td class='signUp-td' valign="top">考勤状态：</td><td><%=signUp.getStatus() %></td></tr>
    <tr><td class='signUp-td' valign="top">考勤距离：</td><td><%=signUp.getScope2() %></td></tr>
    </table>
    <br>
    <table>
    <tr><th class='signUp-title' colspan='2'>定位信息</th></tr>
    <tr><td class='signUp-td' valign="top">定位结果：</td><td id='location'>loading...</td></tr>
    <tr><td class='signUp-td' valign="top">经度：</td><td id='jd'>loading...</td></tr>
    <tr><td class='signUp-td' valign="top">纬度：</td><td id='wd'>loading...</td></tr>
    <tr><td class='signUp-td' valign="top">当前地点：</td><td id='nowSite'>loading...</td></tr>
    </table>
</div>
