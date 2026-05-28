package com.example.allsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.allsystem.entity.UserLogin;
import com.example.allsystem.mapper.UserLoginMapper;
import com.example.allsystem.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl extends ServiceImpl<UserLoginMapper, UserLogin> implements UserLoginService {


    //注入加密工具
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //重写save方法 新增时自动加密密码
    @Override
    public boolean save(UserLogin userLogin) {

        //密码加密
        userLogin.setPassword(bCryptPasswordEncoder.encode(userLogin.getPassword()));
        return super.save(userLogin);
    }


    // 登录验证密码
    @Override
    public boolean login(String username, String rawPassword) {
        // 1. 根据用户名查用户
        UserLogin user = lambdaQuery().eq(UserLogin::getUserName, username).one();
        if (user == null) return false;

        // 2. 验证密码：明文 和 数据库加密串 对比
        return bCryptPasswordEncoder.matches(rawPassword, user.getPassword());
    }

}
