package com.example.swagger2.controller;

import com.example.swagger2.entity.ResponseInfo.Result;
import com.example.swagger2.entity.User;
import com.example.swagger2.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by heyou on 2019/6/14 0014.
 */
@Api("用户信息管理")
@RestController
@RequestMapping("/user/*")
public class UserController {
    @Resource
    UserServiceImpl userService;
    private final static List<User> userList = new ArrayList<>();{
        userList.add(new User(1, "admin", "123456"));
        userList.add(new User(2, "jacks", "111111"));
    }

    @ApiOperation("获取列表")
    @GetMapping("list")
    public Result userList() {
        Result result = new Result();
        result.setData(userList);
        result.setSuccess(true);
        result.setMsg("成功");
        return result;
    }

    @ApiOperation("新增用户")
    @PostMapping("save")
    public boolean save(User user) {
        return userList.add(user);
    }

    @ApiOperation("更新用户")
    @ApiImplicitParam(name = "user", value = "单个用户信息", dataType = "User")
    @PutMapping("update")
    public boolean update(User user) {
        return userList.remove(user) && userList.add(user);
    }

    @ApiOperation("批量删除")
    @ApiImplicitParam(name = "users", value = "N个用户信息", dataType = "List<User>")
    @DeleteMapping("delete")
    public boolean delete(@RequestBody List<User> users) {
        return userList.removeAll(users);
    }

    @ApiOperation("登录")
    @ApiImplicitParam(name = "login", value = "单个用户信息", dataType = "User")
    @PostMapping("login")
    public User login(@RequestBody User user){
        return userService.login(user);
    }

}

