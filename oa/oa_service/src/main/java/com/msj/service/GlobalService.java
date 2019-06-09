package com.msj.service;

import com.msj.entity.Employee;

public interface GlobalService {
    Employee login(String sn,String password);
    void changePassword(Employee employee);
}
