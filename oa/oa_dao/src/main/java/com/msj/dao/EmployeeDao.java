package com.msj.dao;

import com.msj.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public interface EmployeeDao {
    Integer selectOne(@Param("sn")String sn,@Param("password")String password);
    List<Employee> selectAll();
    void insertOne(Employee employee);
    void deleteOne(String sn);
    Employee select(String sn);
    void updateOne(Employee employee);
}
