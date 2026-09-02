package com.example.allsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.allsystem.entity.UserLogin;

public interface UserLoginService extends IService<UserLogin> {

    public UserLogin login(String username, String rawPassword);

    // 根据用户名查询用户
    public UserLogin getUserByUsername(String username);
}
