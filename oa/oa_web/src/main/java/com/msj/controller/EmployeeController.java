package com.msj.controller;

import com.msj.dao.EmployeeDao;
import com.msj.entity.Employee;
import com.msj.global.Contant;
import com.msj.service.DepartmentService;
import com.msj.service.EmployeeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController{

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    //跳转登录页面
    @RequestMapping("/to_login")
    public String to_login(){
        return "login";
    }

    //登录处理
    @RequestMapping("/login")
    public String login(String sn,String password){
        Integer num = employeeService.selectOne(sn, password);
        //查询出来，就可以登录成功
        if(num!=null){
            return "redirect:/employee/list";
        }else{
            return "redirect:/employee/to_login";
        }
    }

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        List<Employee> employeeList = employeeService.findAll();
        System.out.println(employeeList);
        map.put("list",employeeList);
        return "employee_list";
    }

    @RequestMapping("/to_add")
    public String to_add(Map<String,Object> map){
        map.put("employee",new Employee());
        map.put("dlist",departmentService.findAll());
        map.put("plist",Contant.getPosts());
        return "employee_add";
    }
    @RequestMapping("/add")
    public String add(Employee employee){
        employeeService.insertOne(employee);
        return null;
    }
}
