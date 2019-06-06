package com.msj.service.impl;

import com.msj.dao.UserDao;
import com.msj.pojo.User;
import com.msj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public List<User> findAll() {
        return userDao.findAll();
    }

    public Integer addOne(User user) {
        return userDao.addOne(user);
    }

    public Integer delete(Integer id) {
        return userDao.deleteOne(id);
    }

    public User findOne(Integer id) {
        return userDao.findOne(id);
    }

    public Integer updateOne(User user) {
        return userDao.updateOne(user);
    }
}
