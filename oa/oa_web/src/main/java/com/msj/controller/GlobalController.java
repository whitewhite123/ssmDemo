package com.msj.controller;
import com.msj.entity.Employee;
import com.msj.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;


//处理登录
@Controller("globalController")
public class GlobalController {

    @Autowired
    private GlobalService globalService;

    //跳转登录页面
    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    //进行登录，设置session
    @RequestMapping("/login")
    public String login(HttpSession session,String sn, String password){
        Employee employee = globalService.login(sn, password);
        if(employee==null){
            return "redirect:to_login";
        }
        //设置session
        session.setAttribute("employee",employee);
        return "/self";
    }

    //登录后跳转页面
    @RequestMapping("/self")
    public String self(){
        return "self";
    }

    //退出
    @RequestMapping("/quit")
    public String quit(HttpSession session){
        session.setAttribute("employee",null);
        return "redirect:/to_login";
    }

    //修改密码
    @RequestMapping("/to_change_password")
    public String toChangePassword(){
        return "change_password";
    }

    @RequestMapping("change_password")
    public String changePassword(HttpSession session,String old,String new1,String new2){
        Employee employee = (Employee)session.getAttribute("employee");
        //如果表中查询到旧的密码，就看看新密码跟再次输入新的密码是否一致
        if(employee.getPassword().equals(old)){
            if(new1.equals(new2)){
                employee.setPassword(new1);
                globalService.changePassword(employee);
                return "redirect:/to_login";
            }
        }
        return "to_change_password";
    }
}
