<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>登录页面</h3>
<form action="${pageContext.request.contextPath}/user/login.do" method="post">
	账号：<input name="username"><br>
	密码：<input name="password"><br>
	<button type="submit">登录</button>
</form>
</body>
</html>