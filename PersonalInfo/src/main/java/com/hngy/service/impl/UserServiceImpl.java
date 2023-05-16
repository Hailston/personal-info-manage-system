package com.hngy.service.impl;

import com.hngy.entity.User;
import com.hngy.mapper.UserMapper;
import com.hngy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 6-126
 * @date 2023/4/29 18:42
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        try {
            userMapper.insertOne(user);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public User login(String username, String password) {
        return userMapper.selectByUsernameAndPassword(username, password);
    }

    @Override
    public void editUserInfo(String username, String edu, String work, String phone, String email) {
        userMapper.updateUserInfo(username, edu, work, phone, email);
    }

    @Override
    public void editPassword(String username, String password) {
        userMapper.updatePassword(username, password);
    }
}
