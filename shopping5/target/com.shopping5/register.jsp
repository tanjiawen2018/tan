<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>xxx注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
    <table border="1">
        <tr>
            <td>用户名</td>
            <%-- placeholder属性的作用是在框中提示输入，value属性的作用是记录上次错误的表单，后面的${}是el表达式，用于显示错误警告 --%>
            <td><input type="text" name="userName" placeholder="请输入用户名" value="${userForm.userName}">${userNameErr}${userForm.errMap.userName}</td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" placeholder="请输入密码" value="${userForm.password}">${userForm.errMap.password}</td>
        </tr>
        <tr>
            <td>确认密码</td>
            <td><input type="password" name="repassword" placeholder="请再次输入密码" value="${userForm.repassword}">${userForm.errMap.repassword}</td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="gender" value="男" checked="checked">男
                <input type="radio" name="gender" value="女">女
            </td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input type="text" name="emailAddr" placeholder="请输入邮箱地址" value="${userForm.emailAddr}">${userForm.errMap.emailAddr}</td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="注册"></td>
        </tr>
    </table>
</form>
</body>
</html>
