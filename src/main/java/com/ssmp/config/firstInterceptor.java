//package com.ssmp.config;
//
//import org.springframework.lang.Nullable;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
////1.设置拦截器实现handlerinterceptor接口，写拦截方法
////2.在spring的doInterceptors方法中添加该控制器
//public class firstInterceptor implements HandlerInterceptor {
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("拦截器拦截了");
//        HttpSession session= request.getSession();
//        if(session.getAttribute("employee")==null)
//        { System.out.println("拦截器跳转了");
//            response.sendRedirect("-1");
//        }
//        return true;
//    }
//
//}