package com.msj.controller;
import com.msj.entity.Employee;
import com.msj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    //跳转登录页面
    @RequestMapping("/to_login")
    public String to_login(){
        return "login";
    }

    //登录处理
    @RequestMapping("/login")
    public String login(String sn, String password, HttpSession session){
        Employee employee = loginService.selectOne(sn, password);
        //查询出来，就可以登录成功
        if(employee!=null){
            //登录成功，设置session
            session.setAttribute("employee",employee);
            return "self";
        }else{
            return "redirect:/employee/to_login";
        }
    }

    //修改密码
    @RequestMapping("/to_change_password")
    public String to_changePassword(String sn,String old,String new1,String new2){
        loginService.selectOldPassword(sn);
        return "change_password";
    }
}
