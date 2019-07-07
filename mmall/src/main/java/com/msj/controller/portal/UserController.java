package com.msj.controller.portal;

import com.msj.common.ResponseCode;
import com.msj.common.ServerResponse;
import com.msj.pojo.User;
import com.msj.service.portal.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //登录
    @RequestMapping("/login.do")
    @ResponseBody
    public ServerResponse login(@Param("username") String username, @Param("password") String password, HttpSession session) {
        User user = userService.selectByName(username, password);
        System.out.println(user);
        if (user != null) {
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByFailMessage();
    }

    //注册
    @RequestMapping("/register.do")
    @ResponseBody
    public ServerResponse register(@Param("username")String username,@Param("password")String password,
                                   @Param("email")String email,@Param("phone")String phone,
                                   @Param("question")String question,@Param("answer")String answer){
        User user = userService.selectForRegister(username, password, email, phone, question, answer);
        System.out.println(user);
        if(user!=null){
            return ServerResponse.registerByFail();
        }
        return  ServerResponse.registerBySuccess();

    }
}
