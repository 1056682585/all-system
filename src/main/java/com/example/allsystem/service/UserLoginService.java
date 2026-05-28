package com.example.allsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.allsystem.entity.UserLogin;

public interface UserLoginService extends IService<UserLogin> {

    public boolean login(String username, String rawPassword);
}
