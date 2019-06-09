package com.msj.dao.impl;

import com.msj.dao.DepartmentDao;
import com.msj.dao.EmployeeDao;
import com.msj.entity.Department;
import com.msj.entity.Employee;
import com.msj.mapper.DepartmentMapper;
import com.msj.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private EmployeeMapper employeeMapper;

    public Integer insertOne(Employee employee) {
        return employeeMapper.insertOne(employee);
    }

    public Integer updateOne(Employee employee) {
        return employeeMapper.updateOne(employee);
    }

    public Integer deleteOne(String sn) {
        return employeeMapper.deleteOne(sn);
    }

    public Employee selectOne(String sn) {
        return employeeMapper.selectOne(sn);
    }

    public List<Employee> selectAll() {
        return employeeMapper.selectAll();
    }
}
