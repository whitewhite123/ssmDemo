package com.msj.dao.impl;

import com.msj.dao.UserDao;
import com.msj.entity.User;
import com.msj.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper userMapper;

    public Integer add(User user) {
        return userMapper.add(user);
    }
}
