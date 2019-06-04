package com.service.impl;

import com.dao.UserDao;
import com.pojo.User;
import com.service.UserService;
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

    public Integer delOne(Integer id) {
        return userDao.delOne(id);
    }

    public User selOne(Integer id) {
        return userDao.selOne(id);
    }

    public Integer update(User user) {
        return userDao.update(user);
    }
}
