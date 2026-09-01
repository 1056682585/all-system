package com.example.allsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.allsystem.entity.LoginLog;
import com.example.allsystem.mapper.LoginLogMapper;
import com.example.allsystem.service.LoginLogService;
import org.springframework.stereotype.Service;

@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {
}
