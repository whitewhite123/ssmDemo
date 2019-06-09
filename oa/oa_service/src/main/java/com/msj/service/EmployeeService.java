package com.msj.service;


import com.msj.entity.Employee;

import java.util.List;

public interface EmployeeService {
    //添加
    Integer addOne(Employee employee);
    //更新
    Employee getOne(String sn);
    Integer editOne(Employee employee);
    //删除
    Integer removeOne(String sn);
    //查看
    List<Employee> getAll();
}
