package com.mapper;

import com.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> selectAll();
    public Integer insertOne(User user);
    public Integer deleteOne(Integer id);
    public User selectOne(Integer id);
    public Integer update(User user);
}
