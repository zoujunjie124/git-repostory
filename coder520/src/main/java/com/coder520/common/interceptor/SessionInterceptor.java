package com.coder520.common.interceptor;

import com.coder520.user.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by JackWangon[www.aiprogram.top] 2017/6/18.
 */
public class SessionInterceptor implements HandlerInterceptor{
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {String uri = request.getRequestURI();
        if((uri.indexOf("login")>=0)||(uri.indexOf("sign")>=0)||(uri.indexOf("error")>=0)){
            return true;
        }
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("userinfo");
//        User user = (User) session.getAttribute("userinfo");
        if(user!=null){
            return true;
        }
         //转发到登录
        request.getRequestDispatcher("/login").forward(request,response);
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
