package com.corbin.examples.mybatis.controller;

import com.corbin.examples.mybatis.entity.User;
import com.corbin.examples.mybatis.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/add")
    public String addUser(String userName, Integer age) {
        return userService.addUser(userName, age) ? "success" : "fail";
    }

    @RequestMapping("/get")
    public User getUserByName(String userName) {
        return userService.getUserByName(userName);
    }
}
