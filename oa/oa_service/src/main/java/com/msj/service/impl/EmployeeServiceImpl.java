package com.msj.service.impl;


import com.msj.dao.EmployeeDao;
import com.msj.entity.Employee;
import com.msj.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public Integer addOne(Employee employee) {
        employee.setPassword("000000");
        return employeeDao.insertOne(employee);
    }

    public Employee getOne(String sn) {
        return employeeDao.selectOne(sn);
    }

    public Integer editOne(Employee employee) {
        return employeeDao.updateOne(employee);
    }

    public Integer removeOne(String sn) {
        return employeeDao.deleteOne(sn);
    }

    public List<Employee> getAll() {
        return employeeDao.selectAll();
    }
}
