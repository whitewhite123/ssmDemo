package com.service;

import com.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public Integer addOne(User user);
    public Integer delOne(Integer id);
    public User selOne(Integer id);
    public Integer update(User user);
}
