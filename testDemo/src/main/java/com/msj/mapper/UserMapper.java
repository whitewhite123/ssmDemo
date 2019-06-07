package com.msj.mapper;

import com.msj.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Insert("insert into user(name,age) values(#{name},#{age})")
    public Integer add(User user);
}
