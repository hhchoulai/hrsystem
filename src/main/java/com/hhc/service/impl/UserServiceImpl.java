package com.hhc.service.impl;

import com.hhc.entity.User;
import com.hhc.mapper.UserMapper;
import com.hhc.service.UserService;
import com.hhc.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

//    注入mapper
    @Autowired
    private UserMapper userMapper;
    /**
     *登陆
     */
    public ResultVO login(String username,String password) {
//        通过用户名查看此用户是否存在
        User user=userMapper.getUserByUsername(username);
//        用户不存在
        if (user==null){
            return ResultVO.fail(1,"用户不存在");
        }
//      用户存在   验证用户密码是否正确----不正确的情况
        if (!user.getPassword().equals(password)){
            return ResultVO.fail(2,"密码错误");
        }
//        防止在postman中看到
        user.setPassword("");
        return ResultVO.success("登陆成功",user);
    }

    /**
     *修改密码
     */
    @Override
    public ResultVO resetPassword(String username, String oldPassword,String newPassword) {
        User user = userMapper.getUserByUsername(username);
//        验证旧密码是否正确
        if (user.getPassword().equals(oldPassword)){
//            user.setPassword(newPassword);
            userMapper.updatePassword(newPassword,user.getUsername());
            return ResultVO.success();
        }
        return ResultVO.fail(1,"旧密码错误");
    }

    @Override
    public ResultVO register(User user) {
        User user1 = userMapper.getUserByUsername(user.getUsername());
//        System.out.println(user1);
        if (user1!=null){
            return ResultVO.fail(1,"用户名已存在");
        }
        int i = userMapper.addUser(user);
        if (i == 0) {
            return ResultVO.fail(2,"注册失败");
        }
        return ResultVO.success("注册成功！");
    }
}
