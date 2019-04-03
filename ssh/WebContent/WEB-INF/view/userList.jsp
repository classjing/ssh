<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 引入jstl标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>用户列表</h3>

编号------>姓名------>密码------>邮箱--->操作<br>
<c:forEach items="${users}" var="u">
${u.id}------>${u.username}------>${u.password} ------>${u.email} 
	<a href="${pageContext.request.contextPath}/user/delete.do?id=${u.id}">删除</a>
	<a href="">修改</a>
<br>
</c:forEach>
<hr>
<a href="${pageContext.request.contextPath}/user/export.do">导出用户</a>

</body>
</html>