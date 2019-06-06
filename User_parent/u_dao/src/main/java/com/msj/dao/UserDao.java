package com.msj.dao;

import com.msj.pojo.User;

import java.util.List;

public interface UserDao {
    //查询
    public List<User> findAll();
    //添加
    public Integer addOne(User user);
    //删除
    public Integer deleteOne(Integer id);
    //更新：先查找出来
    public User findOne(Integer id);
    public Integer updateOne(User user);
}
