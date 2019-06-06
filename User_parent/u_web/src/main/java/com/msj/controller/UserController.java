package com.msj.controller;

import com.msj.dao.UserDao;
import com.msj.pojo.User;
import com.msj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //查看
    @RequestMapping("/index")
    public String userTest(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("users",userList);
        return "index";
    }
    //添加
    @RequestMapping("/add")
    public String userAdd(String name,Integer age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        Integer num = userService.addOne(user);
        System.out.println(num);
        return "redirect:index";
    }
    //删除
    @RequestMapping("/delete")
    public String userDelete(Integer id){
        Integer num = userService.delete(id);
        System.out.println(num);
        return "redirect:index";
    }
    //更新
    @RequestMapping("/update")
    public String userUpdate(Integer id,Model model){
        User user = userService.findOne(id);
        model.addAttribute("user",user);
        return "update";
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String userUpdate(Integer id,String name,Integer age){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
//        System.out.println(user);
        Integer num = userService.updateOne(user);
        System.out.println(num);
        return "redirect:/index";
    }

}
