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
 * @ClassName: RegisterServlet
 * @Descriptin: TODO
 * @author: lkk
 * @Date: 2020/7/10 15:20
 * @Version: 1.0
 **/
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        HttpSession session = req.getSession();
        if (username == null || username.equals("") ||
                password == null || password.equals("") ||
                email == null || email.equals("") ||
                phone == null || phone.equals("") ) {
            out.print("注册失败：用户名、密码、邮箱和手机号不允许为空--3秒后重新注册");
            session.setAttribute("url","register");
            return;
        }
        User user = new User(username,password,email,phone);
        UserService userService = new UserServiceImpl();

        try {
            userService.registerService(user);
            out.print("注册成功--3秒后进入登录界面");
            session.setAttribute("url","login");
        } catch (SQLException e) {
            out.print("注册失败：用户名或密码或邮箱或手机号太长--3秒后重新注册");
            session.setAttribute("url","register");
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
