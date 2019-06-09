package com.msj.mapper;

import com.msj.entity.Employee;

import java.util.List;

public interface EmployeeMapper {
    Integer insertOne(Employee employee);
    Integer updateOne(Employee employee);
    Integer deleteOne(String sn);
    Employee selectOne(String sn);
    List<Employee> selectAll();
}
