<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css-me-register.css" />
<div class="register-middle">
    <h2>注册</h2>
	<form class='register-form' action="${pageContext.request.contextPath }/user/register">
	<table>
	<tr><td><input type="text" class='input-register' placeholder="用户名" name='username' value='${user.username }' /></td></tr>
	<tr><td><input type="password" class='input-register' placeholder="密码" name='password' value='${user.password }' /></td></tr>
	<tr class='register-tr'><td><input type="password" class='input-register' placeholder="确认密码" name='password2' value='${password2 }' /></td></tr>
	<tr><td><input type="submit" class='submit-register' value='注册'/></td></tr>
	</table>
	</form>
	<div class='register-result'>${registerResult }</div>
</div>