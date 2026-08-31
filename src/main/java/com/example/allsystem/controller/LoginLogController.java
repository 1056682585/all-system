package com.example.allsystem.controller;

import com.example.allsystem.common.Result;
import com.example.allsystem.entity.LoginLog;
import com.example.allsystem.service.LoginLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/loginLog")
public class LoginLogController {

    @Autowired
    private LoginLogService loginLogService;

    // 查询所有登录日志
    @GetMapping("/list")
    public Result<List<LoginLog>> list() {
        List<LoginLog> list = loginLogService.list();
        return Result.success(list);
    }

    // 新增登录日志
    @PostMapping("/addLoginLog")
    public Result<String> addLoginLog(@RequestBody LoginLog loginLog) {
        boolean ok = loginLogService.save(loginLog);
        return ok ? Result.success("新增成功") : Result.fail("新增失败");
    }

    // 修改登录日志
    @PutMapping("/updateLoginLog")
    public Result<String> updateLoginLog(@RequestBody LoginLog loginLog) {
        boolean ok = loginLogService.updateById(loginLog);
        return ok ? Result.success("修改成功") : Result.fail("修改失败");
    }

    // 删除登录日志
    @DeleteMapping("/deleteLoginLog")
    public Result<String> deleteLoginLog(@PathVariable Integer id) {
        boolean ok = loginLogService.removeById(id);
        return ok ? Result.success("删除成功") : Result.fail("删除失败");
    }
}
