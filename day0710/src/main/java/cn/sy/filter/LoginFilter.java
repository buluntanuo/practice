package cn.sy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName: LoginFilter
 * @Descriptin: TODO
 * @author: lkk
 * @Date: 2020/7/11 9:10
 * @Version: 1.0
 **/

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request =(HttpServletRequest) servletRequest;
        boolean flag = (boolean) request.getSession(false).getAttribute("loginFlag");
        System.out.println("开始过滤");
        if (flag) {
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            request.getRequestDispatcher("/jsp/login.jsp").forward(servletRequest,servletResponse);
        }
    }

}
