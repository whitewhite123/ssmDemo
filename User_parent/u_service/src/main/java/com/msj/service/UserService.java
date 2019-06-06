package com.msj.service;

import com.msj.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public Integer addOne(User user);
    public Integer delete(Integer id);
    public User findOne(Integer id);
    public Integer updateOne(User user);
}
