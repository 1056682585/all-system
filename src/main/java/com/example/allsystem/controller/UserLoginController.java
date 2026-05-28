package com.example.allsystem.controller;

import com.example.allsystem.entity.UserLogin;
import com.example.allsystem.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userLogin")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;


    // 查询所有
    @GetMapping("/list")
    public List<UserLogin> list() {
        return userLoginService.list();
    }

    //根据id查询
    @GetMapping("/getUserById")
    public UserLogin getUserById(@PathVariable Integer id) {
        return userLoginService.getById(id);
    }

    //新增
    @PostMapping("/addUser")
    public boolean addUser(@RequestBody UserLogin userLogin) {
        return userLoginService.save(userLogin);
    }


    //修改
    @PutMapping("/updateUser")
    public boolean updateUser(@RequestBody UserLogin userLogin) {
        return userLoginService.updateById(userLogin);
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@PathVariable Integer id) {
        return userLoginService.removeById(id);
    }
}
