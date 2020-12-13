<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>xxx主页</title>
</head>
<body>
<%-- ${}是jsp中el表达式 --%>
${sessionScope.userName}欢迎来到xxx网站！<br>
<a href="${pageContext.request.contextPath}/LogoutServlet">注销登录</a>
</body>
</html>
