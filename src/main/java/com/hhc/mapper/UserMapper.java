package com.hhc.mapper;

import com.hhc.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    User getUserByUsername(String username);
//    参数顺序必须与param1 param2顺序一致
    int updatePassword(String password,String username);
    int addUser(User user);
}
