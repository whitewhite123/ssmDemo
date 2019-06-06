package com.czq.service.impl;

import com.czq.dao.UserDao;
import com.czq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    //注入UserDao
    @Autowired
    private UserDao userDao;

    public int selAll() {
        return userDao.selAll();
    }
}
