<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>xxx注册</title>
</head>
<body>
<%-- ${}是jsp中el表达式 --%>
<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
    <table border="1">
        <tr>
            <td colspan="2"><span style="color: red">${requestScope.errMsg}</span></td>
        </tr>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="userName" placeholder="请输入用户名" value="${requestScope.userName}"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" placeholder="请输入密码" value="${requestScope.password}"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>
</body>
</html>
