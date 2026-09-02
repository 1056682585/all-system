package com.example.allsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.allsystem.entity.UserLogin;
import com.example.allsystem.mapper.UserLoginMapper;
import com.example.allsystem.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserLoginServiceImpl extends ServiceImpl<UserLoginMapper, UserLogin> implements UserLoginService {


    //注入加密工具
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //重写save方法 新增时自动加密密码、设置注册时间为当前时间
    @Override
    public boolean save(UserLogin userLogin) {

        //密码加密
        userLogin.setPassword(bCryptPasswordEncoder.encode(userLogin.getPassword()));

        //注册时间设为当前系统时间
        userLogin.setRegDate(LocalDateTime.now());

        return super.save(userLogin);
    }


    // 登录验证密码，成功返回用户信息，失败返回 null
    @Override
    public UserLogin login(String username, String rawPassword) {
        // 1. 根据用户名查用户
        UserLogin user = lambdaQuery().eq(UserLogin::getUserName, username).one();
        if (user == null) return null;

        // 2. 验证密码：明文 和 数据库加密串 对比
        boolean ok = bCryptPasswordEncoder.matches(rawPassword, user.getPassword());
        return ok ? user : null;
    }

    // 根据用户名查询用户
    @Override
    public UserLogin getUserByUsername(String username) {
        return lambdaQuery().eq(UserLogin::getUserName, username).one();
    }

}
