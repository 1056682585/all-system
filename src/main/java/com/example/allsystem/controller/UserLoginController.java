package com.example.allsystem.controller;

import com.example.allsystem.common.Result;
import com.example.allsystem.entity.UserLogin;
import com.example.allsystem.service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/userLogin")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;


    // 查询所有
    @GetMapping("/list")
    public Result<List<UserLogin>> list() {
        List<UserLogin> list = userLoginService.list();
        return Result.success(list);
    }

    //根据id查询
    @GetMapping("/getUserById")
    public Result<UserLogin> getUserById(@PathVariable Integer id) {
        UserLogin user = userLoginService.getById(id);
        return user != null ? Result.success(user) : Result.fail("用户不存在");
    }

    //新增
    @PostMapping("/addUser")
    public Result<String> addUser(@RequestBody UserLogin userLogin) {
        // 1. 检查用户名是否已存在
        UserLogin exist = userLoginService.getUserByUsername(userLogin.getUserName());
        if (exist != null) {
            return Result.fail("用户名已存在，不允许重复注册");
        }
        // 2. 不存在则新增
        boolean ok = userLoginService.save(userLogin);
        return ok ? Result.success("注册成功") : Result.fail("注册失败");
    }


    //修改
    @PutMapping("/updateUser")
    public Result<String> updateUser(@RequestBody UserLogin userLogin) {
        boolean ok = userLoginService.updateById(userLogin);
        return ok ? Result.success("修改成功") : Result.fail("修改失败");
    }

    @DeleteMapping("/deleteUser")
    public Result<String> deleteUser(@RequestParam String id) {
        boolean ok = userLoginService.removeById(id);
        return ok ? Result.success("删除成功") : Result.fail("删除失败");
    }

    //登录验证
    @PostMapping("/login")
    public Result<UserLogin> login(@RequestBody UserLogin userLogin) {
        log.info("userLogin:{}", userLogin);
        UserLogin user = userLoginService.login(userLogin.getUserName(), userLogin.getPassword());
        if (user == null) {
            return Result.fail("用户名或密码错误");
        }
        // 密码不回传给前端
        user.setPassword(null);
        return Result.success("登录成功", user);
    }
}
