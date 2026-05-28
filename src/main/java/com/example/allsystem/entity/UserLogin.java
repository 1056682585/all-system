package com.example.allsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_login")
public class UserLogin {

    //用来序列化 传给前端不丢失精度 long---->bigint
    //@JsonSerialize(using = ToStringSerializer.class)


    // 自动生成UUID
    @TableId(type = IdType.ASSIGN_UUID)
    private String userId;

    private String userName;
    private String password;
}
