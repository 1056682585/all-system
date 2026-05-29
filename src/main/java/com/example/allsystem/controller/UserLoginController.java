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
        boolean ok = userLoginService.save(userLogin);
        return ok ? Result.success("新增成功") : Result.fail("新增失败");
    }


    //修改
    @PutMapping("/updateUser")
    public Result<String> updateUser(@RequestBody UserLogin userLogin) {
        boolean ok = userLoginService.updateById(userLogin);
        return ok ? Result.success("修改成功") : Result.fail("修改失败");
    }

    @DeleteMapping("/deleteUser")
    public Result<String> deleteUser(@PathVariable Integer id) {
        boolean ok = userLoginService.removeById(id);
        return ok ? Result.success("删除成功") : Result.fail("删除失败");
    }

    //登录验证
    @PostMapping("/login")
    public Result<String> login(@RequestBody UserLogin userLogin) {
        log.info("userLogin:{}", userLogin);
        boolean ok = userLoginService.login(userLogin.getUserName(), userLogin.getPassword());
        return ok ? Result.success("登录成功") : Result.fail("用户名或密码错误");
    }
}
