package com.msj.service;
import com.msj.entity.Department;
import java.util.List;

public interface DepartmentService {
    //添加
    Integer addOne(Department department);
    //更新
    Department getOne(String sn);
    Integer editOne(Department department);
    //删除
    Integer removeOne(String sn);
    //查看
    List<Department> getAll();
}
