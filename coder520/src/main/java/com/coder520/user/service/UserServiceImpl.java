package com.coder520.user.service;

import com.coder520.common.utils.MD5Utils;
import com.coder520.user.dao.UserMapper;
import com.coder520.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by JackWangon[www.aiprogram.top] 2017/6/16.
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;


    /**
     *@Author JackWang [www.coder520.com]
     *@Date 2017/6/18 12:48
     *@Description 根据用户名查询用户
     */
    @Override
    public User findUserByUserName(String username) {
        User user=null;
        try {
             user =userMapper.selectByUserName(username);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        return user;
    }


    @Override
    public void createUser(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        user.setPassword(MD5Utils.encryptPassword(user.getPassword()));

        userMapper.insertSelective(user);
    }
}
