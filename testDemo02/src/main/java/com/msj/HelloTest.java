package com.msj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HelloTest {

    @RequestMapping("/hello")
    public String hello(String name,String password,Map<String,Object> map){
        System.out.println("名字："+name);
        System.out.println("密码："+password);
        map.put("msg","返回给视图的消息");
        return "/pages/success.jsp";
    }

    @RequestMapping("/hello2")
    public void hello2(){
        System.out.println("hhhhhhh");
    }
}
