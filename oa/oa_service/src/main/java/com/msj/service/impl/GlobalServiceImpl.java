package com.msj.service.impl;

import com.msj.dao.EmployeeDao;
import com.msj.entity.Employee;
import com.msj.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("globalService")
public class GlobalServiceImpl implements GlobalService {
    @Autowired
    private EmployeeDao employeeDao;

    //登录
    public Employee login(String sn, String password) {
        Employee employee = employeeDao.selectOne(sn);
        if(employee!=null && employee.getPassword().equals(password)){
            return employee;
        }
        return null;
    }
    //修改密码
    public void changePassword(Employee employee) {
        employeeDao.updateOne(employee);
    }
}
