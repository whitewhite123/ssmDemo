package com.msj.controller;

import com.msj.dao.UserDao;
import com.msj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/to_add")
    public String to_add(Map<String,Object> map){
        map.put("users",new User());
        return "add.jsp";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(User user){
        userDao.add(user);
        return "success";
    }

}
