package com.msj.dao;

import com.msj.entity.Department;

import java.util.List;

public interface DepartmentDao {
    Integer insertOne(Department department);
    Integer updateOne(Department department);
    Integer deleteOne(String sn);
    Department selectOne(String sn);
    List<Department> selectAll();

}
