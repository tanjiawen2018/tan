package cn.hestyle.web.servlet;

import cn.hestyle.service.UserService;
import cn.hestyle.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        UserService userService = new UserServiceImpl();
        //使用表单信息登录账号
        if (userService.login(userName, password)) {
            //添加用户名到session中
            request.getSession().setAttribute("userName", userName);
            response.addHeader("content-type", "text/html;charset=utf-8");
            response.addHeader("refresh", "3;url=" + request.getContextPath()+"/main.jsp");
            response.getWriter().write("登录成功！3秒后自动跳转到主页...");
        } else {
            //在请求域中添加错误信息
            request.setAttribute("userName", userName);
            request.setAttribute("errMsg", "用户名或密码错误！");
            request.setAttribute("password", password);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

}
