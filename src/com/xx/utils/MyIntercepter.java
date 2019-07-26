package com.xx.utils;

import com.xx.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("进入了拦截器！");
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        //user = new User();
        if(user!=null){
            System.out.println("user:"+user.getId()+"\t"+user.getUsername());
            System.out.println("不拦截");
            return true;
        }else {
            System.out.println("拦截成功");
            httpServletResponse.sendRedirect("http://localhost/login.jsp");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
