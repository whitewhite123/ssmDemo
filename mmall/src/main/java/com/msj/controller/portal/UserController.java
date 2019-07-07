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

    //1、登录
    @RequestMapping("/login.do")
    @ResponseBody
    public ServerResponse login(@Param("username") String username,
                                @Param("password") String password, HttpSession session) {
        User user = userService.selectByName(username, password);
        //如果取得出来user，证明已经被注册过了的，登录成功，否则登录失败
        if (user != null) {
            session.setAttribute("user",user);
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByFailMessage();
    }

    //2、注册
    @RequestMapping("/register.do")
    @ResponseBody
    public ServerResponse register(@Param("username")String username,@Param("password")String password,
                                   @Param("email")String email,@Param("phone")String phone,
                                   @Param("question")String question,@Param("answer")String answer){
        User user = userService.selectForRegister(username, password, email, phone, question, answer);
        //如果取得出来user，证明已经注册过了，注册失败，否则注册成功
        if(user!=null){
            return ServerResponse.registerByFail();
        }
        return  ServerResponse.registerBySuccess();
    }

    //3、检查用户名是否有效
    @RequestMapping("/check_valid.do")
    @ResponseBody
    public ServerResponse checkValid(@Param("str") String str,@Param("type") String type){
        User user = userService.selectForCheck(str,type);
        //如果取得出来user，证明已经注册过了
        if(user!=null){
            return ServerResponse.registerByFail();
        }
        return ServerResponse.registerBySuccess();
    }

    //4、获取用户信息
    //登录成功才可获取用户信息，未登录不可获取用户信息
    @RequestMapping("/get_user_info.do")
    @ResponseBody
    public ServerResponse getUserInfo(HttpSession session){
        if(session.getAttribute("user")!=null){
            return ServerResponse.loginBySuccess(session.getAttribute("user"));
        }
        return ServerResponse.loginByFail();
    }
}
