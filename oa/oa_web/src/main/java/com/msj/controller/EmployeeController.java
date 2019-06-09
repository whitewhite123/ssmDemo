package com.msj.controller;
import com.msj.entity.Employee;
import com.msj.global.Contant;
import com.msj.service.DepartmentService;
import com.msj.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;

//员工信息
@Controller("employeeController")
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    //查看员工信息
    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        List<Employee> list = employeeService.getAll();
        map.put("list",list);
        return "employee_list";
    }

    //添加
    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("employee",new Employee());
        map.put("dlist",departmentService.getAll());
        map.put("plist",Contant.getPosts());
        return "employee_add"; //跳转到添加页面
    }

    @RequestMapping("/add")
    public String add(Employee employee){
        System.out.println(employee);
        Integer num = employeeService.addOne(employee);
        System.out.println("添加"+num+"条数据成功！");
        return "redirect:list";
    }

    //删除
    @RequestMapping("/remove")
    public String remove(String sn){
        Integer num = employeeService.removeOne(sn);
        System.out.println("删除"+num+"条数据成功！");
        return "redirect:list";
    }

    //更新
    @RequestMapping("/to_update")
    public String toUpdate(String sn,Map<String,Object> map){
        Employee employee = employeeService.getOne(sn);
        System.out.println(employee);
        map.put("employee",employee);
        map.put("dlist",departmentService.getAll());
        map.put("plist",Contant.getPosts());
        return "employee_update";
    }
    @RequestMapping("/update")
    public String update(Employee employee){
        Integer num = employeeService.editOne(employee);
        System.out.println("更新"+num+"条数据成功！");
        return "redirect:list";
    }
}
