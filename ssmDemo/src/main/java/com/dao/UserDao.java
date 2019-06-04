package com.dao;

import com.pojo.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
    public Integer addOne(User user);
    public Integer delOne(Integer id);
    public User selOne(Integer id);
    public Integer update(User user);
}
