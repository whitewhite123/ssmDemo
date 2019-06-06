package com.czq.dao.impl;

import com.czq.dao.UserDao;
import com.czq.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int selAll() {
        return jdbcTemplate.update("insert into user (name,age)values ('hh',1)");
    }
}
