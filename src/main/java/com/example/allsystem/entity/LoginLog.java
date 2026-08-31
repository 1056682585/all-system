package com.example.allsystem.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("login_log")
public class LoginLog {

    // 主键自增
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String loginUsername;
    private String loginDatetime;
    private String loginPc;
    private LocalDateTime loginIp;
}
