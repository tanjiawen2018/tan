package cn.hestyle.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //将session移除
        request.getSession().invalidate();
        response.addHeader("content-type", "text/html;charset=utf-8");
        response.addHeader("refresh", "3;url=" + request.getContextPath()+"/index.jsp");
        response.getWriter().write("注销成功！3秒后自动跳转到首页...");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
