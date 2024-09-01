package com.corbin.exmaples.jta.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Resource
    private UserService userService=new UserServiceImpl();

    @RequestMapping(value = "/userList")
    public String addPre() {
        String msg = "";
        try {
            userService.updateUser("and FID = 7");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return msg;
    }
}
