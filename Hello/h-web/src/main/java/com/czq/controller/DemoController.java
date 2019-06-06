package com.czq.controller;

import com.czq.dao.UserDao;
import com.czq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    //注入UserService
    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    @ResponseBody  //不返回视图
    public String hello(){
        int i = userService.selAll();
        System.out.println(i);
        return "hello";
    }
}
