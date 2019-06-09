package com.msj.dao;

import com.msj.entity.Department;
import com.msj.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    Integer insertOne(Employee employee);
    Integer updateOne(Employee employee);
    Integer deleteOne(String sn);
    Employee selectOne(String sn);
    List<Employee> selectAll();

}
