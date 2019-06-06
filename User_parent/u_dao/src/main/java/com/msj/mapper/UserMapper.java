package com.msj.mapper;

import com.msj.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> findAll();
    public Integer addOne(User user);
    public Integer deleteOne(Integer id);
    public User findOne(Integer id);
    public Integer updateOne(User user);
}
