package cn.hestyle.web.servlet;

import cn.hestyle.bean.User;
import cn.hestyle.bean.UserForm;
import cn.hestyle.service.UserService;
import cn.hestyle.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String gender = request.getParameter("gender");
        String emailAddr = request.getParameter("emailAddr");
        //首先检测表单的合法性
        UserForm userForm = new UserForm(userName, password, repassword, gender, emailAddr);
        if (!userForm.isValidate()) {
            request.setAttribute("userForm", userForm);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        //再检测用户名是否被注册
        User user = new User(userName, password, gender, emailAddr);
        UserService userService = new UserServiceImpl();
        if (!userService.userNameIsValidate(userName)) {
            request.setAttribute("userForm", userForm);
            request.setAttribute("userNameErr", "该用户名已被注册！");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        //最后注册到数据库中
        if (userService.register(user)) {
            response.addHeader("content-type", "text/html;charset=utf-8");
            response.addHeader("refresh", "5;url=" + request.getContextPath()+"/login.jsp");
            response.getWriter().write("注册成功！5秒后自动跳转到登录界面...");
            return;
        }
    }
}
