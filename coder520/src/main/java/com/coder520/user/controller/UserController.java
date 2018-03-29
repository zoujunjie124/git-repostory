package com.coder520.user.controller;

import com.coder520.user.entity.User;
import com.coder520.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by JackWangon[www.aiprogram.top] 2017/6/16.
 */
@Controller
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(){

     return "home";
    }

    /**
     *@Author JackWang [www.coder520.com]
     *@Date 2017/6/19 21:51
     *@Description  获取用户信息
     */
    @RequestMapping("/userinfo")
    @ResponseBody
    public User getUser(){
       User user = (User) SecurityUtils.getSubject().getSession().getAttribute("userinfo");
       return user;
    }


    /**
     *@Author JackWang [www.coder520.com]
     *@Date 2017/6/20 20:39
     *@Description 登出系统
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

}
