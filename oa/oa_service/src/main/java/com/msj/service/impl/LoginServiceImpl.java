package com.msj.service.impl;
import com.msj.dao.LoginDao;
import com.msj.entity.Employee;
import com.msj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private LoginDao loginDao;

    public Employee selectOne(String sn, String password) {
        return loginDao.selectOne(sn,password);
    }


    public void changePassword(Employee employee) {
        loginDao.changePassword(employee);
    }


}
