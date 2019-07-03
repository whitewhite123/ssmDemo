package com.msj;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor implements HandlerInterceptor {
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("utf-8");
        System.out.println("之前1");
        //返回值：表示我们是否要拦截当前的请求
        //true：请求被执行
        //false:请求被终止，不会到达控制器，也不会执行postHandle和afterCompletion
        return true;
    }

    public void postHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //modelAndView:修改返回视图的数据
//        modelAndView.addObject("msg","被拦截器修改的消息");
        //改变返回的视图
//        modelAndView.setViewName("/pages/fail.jsp");
        System.out.println("postHandle1");
    }

    public void afterCompletion(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("之后1");
    }
}
