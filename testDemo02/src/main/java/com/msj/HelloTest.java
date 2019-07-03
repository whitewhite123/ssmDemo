package com.msj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloTest {

    @RequestMapping("/hello")
    public void hello(String name,String password){
        System.out.println("名字："+name);
        System.out.println("密码："+password);
    }

    @RequestMapping("/hello2")
    public void hello2(){
        System.out.println("hhhhhhh");
    }
}
