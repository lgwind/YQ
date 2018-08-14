<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-me-login.css" />
<div class="login-middle">
    <h2>登录</h2>
	<form class='login-form' action="${pageContext.request.contextPath }/user/login">
	<table>
	<tr><td colspan='2'><input type="text" class='input-login' placeholder="用户名" name='username' value='${user.username }' /></td></tr>
	<tr><td colspan='2'><input type="password" class='input-login' placeholder="密码" name='password' value='${user.password }' /></td></tr>
	<tr><td><input type="checkbox" name="subjectAnswer" value="1" />记住我</td>
	<td class='right-td'><a href="">忘记密码？</a></td></tr>
	<tr><td><input type="submit" class='submit-login' value='登录'/></td>
	<td class='right-td'>
	    <input type="button" class='register-login' value='注册'
	           onclick='window.open("${pageContext.request.contextPath }/page/me/register","_self")'/></td></tr>
	</table>
	</form>
	<div class='login-result'>${loginResult }</div>
</div>