package com.cpjxuejava.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("=====处理前,拦截器拦截=====");
        HttpSession session = request.getSession();
        String s1 = request.getContextPath()+"/book/allBook";
        System.out.println(s1);
        if(s1.equals("/myWeb/book/allBook")){
            return true;
        }
        if (session.getAttribute("userLoginInfo") != null) {
            return true;
        }
        if(request.getRequestURI().contains("login")){
            return true;
        }
        /*if(s1.equals("/myWeb/book/allBook")){
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }*/
        if(session.getAttribute("userLoginInfo")==null) {
            request.getRequestDispatcher(s1 + "/login.jsp").forward(request, response);

        }
        return false;

    }

    /*下面两个方法可以写日志文件*/
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("=====处理后=====");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
         System.out.println("=====清理=====");
    }
}
