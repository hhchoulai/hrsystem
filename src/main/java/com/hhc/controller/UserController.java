package com.hhc.controller;

import com.hhc.entity.User;
import com.hhc.service.UserService;
import com.hhc.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

//解决跨域问题 前后台用的是俩个不同的服务器
@CrossOrigin
//页面返回的是json格式，并且标注此类是控制类
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultVO login(String username, String password, HttpSession session){
//      调用业务层
        ResultVO user = userService.login(username, password);
//      将结果保存在session中  可以获取当前用户
        if (user.isSuccess()){
            session.setAttribute("current_user",user.getData());
//            User user1 = (User)session.getAttribute("current_user");
//            System.out.println(user1);
        }
//      返回给页面
        return user;
    }


    @PostMapping("/resetpassword")
    public ResultVO resetpassword(String password,String newPassword,HttpSession session){
        User user = (User)session.getAttribute("current_user");
        if (user==null){
            return ResultVO.fail(2,"未登陆");
        }
        return userService.resetPassword(user.getUsername(),password,newPassword);
    }

    @PostMapping("/register")
    public ResultVO register(User user){
        return userService.register(user);
    }
}
