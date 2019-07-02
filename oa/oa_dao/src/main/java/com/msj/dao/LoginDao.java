package com.msj.dao;

import com.msj.entity.Employee;
import org.apache.ibatis.annotations.Param;

public interface LoginDao {
    Employee selectOne(@Param("sn")String sn, @Param("password")String password);
    void changePassword(Employee employee);
}
