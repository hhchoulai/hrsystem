package com.hhc.service;

import com.hhc.entity.User;
import com.hhc.util.ResultVO;

public interface UserService {
    ResultVO login(String username,String password);
    ResultVO resetPassword(String username, String oldPassword, String newPassword);
    ResultVO register(User user);
}
