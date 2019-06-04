package com.dao.impl;


import com.dao.UserDao;
import com.mapper.UserMapper;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.selectAll();
    }

    public Integer addOne(User user) {
        return userMapper.insertOne(user);
    }

    public Integer delOne(Integer id) {
        return userMapper.deleteOne(id);
    }

    public User selOne(Integer id) {
        return userMapper.selectOne(id);
    }

    public Integer update(User user) {
        return userMapper.update(user);
    }
}
