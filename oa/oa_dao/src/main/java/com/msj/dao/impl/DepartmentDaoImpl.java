package com.msj.dao.impl;

import com.msj.dao.DepartmentDao;
import com.msj.entity.Department;
import com.msj.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("departmentDao")
public class DepartmentDaoImpl implements DepartmentDao {

    @Autowired
    private DepartmentMapper departmentMapper;

    public Integer insertOne(Department department) {
        return departmentMapper.insertOne(department);
    }

    public Integer updateOne(Department department) {
        return departmentMapper.updateOne(department);
    }

    public Integer deleteOne(String sn) {
        return departmentMapper.deleteOne(sn);
    }

    public Department selectOne(String sn) {
        return departmentMapper.selectOne(sn);
    }

    public List<Department> selectAll() {
        return departmentMapper.selectAll();
    }
}
