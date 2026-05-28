package com.example.allsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.allsystem.entity.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserLoginMapper extends BaseMapper<UserLogin> {

    UserLogin selectUserById(@Param("id")Integer id);
}
