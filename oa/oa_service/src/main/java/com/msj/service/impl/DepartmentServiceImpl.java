package com.msj.service.impl;

import com.msj.dao.DepartmentDao;
import com.msj.entity.Department;
import com.msj.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    public Integer addOne(Department department) {
        return departmentDao.insertOne(department);
    }

    public Integer editOne(Department department) {
        return departmentDao.updateOne(department);
    }

    public Integer removeOne(String sn) {
        return departmentDao.deleteOne(sn);
    }

    public Department getOne(String sn) {
        return departmentDao.selectOne(sn);
    }

    public List<Department> getAll() {
        return departmentDao.selectAll();
    }
}
