package com.example.swagger2.controller;

import com.example.swagger2.RequsetBody.ReqLogin;
import com.example.swagger2.entity.ResponseInfo.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 简要说明. <br>
 *
 * <p>
 * Date-Time：  2019/9/17 16:02
 * <p>
 *
 * @author heyou
 * @version 1.0.0
 */
@RestController
@RequestMapping("api")
public class TestController {
    @RequestMapping("test")
    private Map<String,Object> test(){
        Map<String ,Object> map = new HashMap<>();
        map.put("name","heyou");
        map.put("age","24");
        return map;
    }
    @RequestMapping("login")
    private Result login(@RequestBody ReqLogin reqInfo){
       System.out.println("用户名："+reqInfo.getUserName()+"密码："+reqInfo.getPassword());

        return new Result(true,"成功");
    }
}
