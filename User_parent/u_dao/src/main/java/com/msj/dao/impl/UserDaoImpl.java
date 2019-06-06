package com.msj.dao.impl;

import com.msj.dao.UserDao;
import com.msj.mapper.UserMapper;
import com.msj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public Integer addOne(User user) {
        return userMapper.addOne(user);
    }

    public Integer deleteOne(Integer id) {
        return userMapper.deleteOne(id);
    }

    public User findOne(Integer id) {
        return userMapper.findOne(id);
    }

    public Integer updateOne(User user) {
        return userMapper.updateOne(user);
    }
}
