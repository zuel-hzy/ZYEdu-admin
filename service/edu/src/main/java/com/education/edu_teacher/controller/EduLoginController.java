package com.education.edu_teacher.controller;

import com.education.utils.result.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/edu_teacher/user")
@Api(description = "登录管理")
@CrossOrigin
public class EduLoginController {

    //login
    @PostMapping("login")
    public Result login(){
        return Result.ok().data("token","admin");
    }

    //info
    @GetMapping("info")
    public Result info(){
        return Result.ok().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
