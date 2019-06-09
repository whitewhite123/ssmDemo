package com.msj.controller;
import com.msj.entity.Department;
import com.msj.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;

//部门信息
@Controller("departmentController")
@RequestMapping("/department")
public class DepartmentController {
    //注入DepartmentService
    @Autowired
    private DepartmentService departmentService;

    //查看部门信息
    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        List<Department> list = departmentService.getAll();
        map.put("list",list);
        return "department_list";
    }

    //添加
    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("department",new Department());
        return "department_add"; //跳转到添加页面
    }

    @RequestMapping("/add")
    public String add(Department department){
        Integer num = departmentService.addOne(department);
        System.out.println("添加"+num+"条数据成功！");
        return "redirect:list";
    }

    //删除
    @RequestMapping("/remove")
    public String remove(String sn){
        Integer num = departmentService.removeOne(sn);
        System.out.println("删除"+num+"条数据成功！");
        return "redirect:list";
    }

    //更新
    @RequestMapping("/to_update")
    public String toUpdate(String sn,Map<String,Object> map){
        Department department = departmentService.getOne(sn);
        map.put("department",department);
        return "department_update";
    }
    @RequestMapping("/update")
    public String update(Department department){
        Integer num = departmentService.editOne(department);
        System.out.println("更新"+num+"条数据成功！");
        return "redirect:list";
    }
}
