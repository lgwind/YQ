<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.lgwind.util.*"%>
<%@ page import="com.lgwind.dao.*"%>
<%@ page import="com.lgwind.domain.*"%>
<%@ page import="com.lgwind.view.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-attendance_company.css" />
<script src="${pageContext.request.contextPath }/js/js-attendance_company.js"></script>
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
	Company company=null;
	if(data!=null){
	    company = new CompanyDao().get(data.getCompany());
	}
	
%>
<div class="company-middle">
	<h1>企业信息完善</h1>	
	<form action="${pageContext.request.contextPath }/attendance/company/add" method="post">
	<input name='companyName' class='message-input2' type='text' placeholder="<%if(data!=null){ %><%=data.getCompany()%><%}%>"/>
	<input title='点击添加企业' class='message-add' type="submit" value='+'/>
	</form>
	<div class="company">
	<table>
	<tr><th>企业名称</th><th>考勤信息</th><th>操作</th></tr>
	<%if(company!=null){ %>
	<tr><td class="company-name"><%=data.getCompany() %></td>
	    <td class="company-message">
	    <div class="message">
	    <form action="${pageContext.request.contextPath }/attendance/company/update" method="post">
	    <input name='companyName' class="name" type="text" value='<%=company.getCompanyName() %>' />
	    <p><span>考勤班次：</span><input name='startTime' class="time" type='text' value='<%=company.getStartTime() %>'/>~
	                           <input name='lastTime' class="time" type='text' value='<%=company.getLastTime() %>'/></p>
	    <p><span>经纬度1：</span><input name='jd' class="time" type='text' value='<%=company.getJd() %>'/>&nbsp;&nbsp;<input name='wd' class="time" type='text' value='<%=company.getWd() %>'/></p>
	    <p><span>经纬度2：</span><input name='jd2' class="time" type='text' value='<%=company.getJd2() %>'/>&nbsp;&nbsp;<input name='wd2' class="time" type='text' value='<%=company.getWd2() %>'/></p>
	    <p><span>经纬度3：</span><input name='jd3' class="time" type='text' value='<%=company.getJd3() %>'/>&nbsp;&nbsp;<input name='wd3' class="time" type='text' value='<%=company.getWd3() %>'/></p>
	    <p><span>考勤地点1：</span><textarea name='jwName' cols="30" rows='1'><%=company.getJwName() %></textarea></p>
	    <p><span>考勤地点2：</span><textarea name='jwName2' cols="30" rows='1'><%=company.getJwName2() %></textarea></p>
	    <p><span>考勤地点3：</span><textarea name='jwName3' cols="30" rows='1'><%=company.getJwName3() %></textarea></p>
	    <p><span>考勤范围(m)：</span><input name='scope' type='text' value='<%=company.getScope() %>'/></p>
	    <p><input class="submit" type='submit' value="确认修改"/></p>
	    </form>
	    </div>
	    </td>
	    <td class="company-op"></td></tr>
	<%} %>
	</table>
	</div>
</div>