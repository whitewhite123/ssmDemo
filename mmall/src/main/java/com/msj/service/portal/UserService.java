package com.msj.service.portal;

import com.msj.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    User selectByName(@Param("username")String username,@Param("password")String password);
}
