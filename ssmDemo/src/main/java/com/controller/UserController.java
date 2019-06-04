package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import java.util.List;

@Controller

public class UserController {

    @Autowired
    private UserService userService;

    //查看
    @RequestMapping("/index")
    public String select(Model model){
        List<User> list = userService.findAll();
        model.addAttribute("list",list);
        return "index.jsp";
    }
    //添加
    @RequestMapping("/add")
    public String add(String name,Integer age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        Integer num = userService.addOne(user);
        System.out.println("添加："+num);
        return "redirect:/index";
    }
    //删除
    @RequestMapping("/delete")
    public String delete(Integer id){
        Integer num = userService.delOne(id);
        System.out.println("删除："+num);
        return "redirect:/index";
    }
    //更新前先进行查询一条数据
    @RequestMapping(value = "/update")
    public String selectOne(Integer id, Model model){
        User user = userService.selOne(id);
        model.addAttribute("user",user);
        return "/update.jsp";
    }
    //更新
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(Integer id,String name,Integer age){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        System.out.println(user);
        Integer num = userService.update(user);
        System.out.println("更新："+num);
        return "redirect:/index";
    }
}

