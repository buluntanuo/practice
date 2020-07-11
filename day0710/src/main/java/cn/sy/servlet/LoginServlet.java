package cn.sy.servlet;

import cn.sy.entry.User;
import cn.sy.service.UserService;
import cn.sy.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * @ClassName: LoginServlet
 * @Descriptin: TODO
 * @author: lkk
 * @Date: 2020/7/10 15:20
 * @Version: 1.0
 **/
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(username,password);
        UserService userService = new UserServiceImpl();
        HttpSession session = req.getSession();
        try {
            boolean flag = userService.loginService(user);
            if (flag) {
                //页面重定向
                User user1 = userService.showService(username);
                session.setAttribute("user",user1);
                session.setAttribute("loginFlag",true);
                out.print("登陆成功,3秒后跳转至主界面");
            }else {
                //输出提示信息
                session.setAttribute("loginFlag",false);
                out.print("登陆失败，3秒后请重新登陆");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
