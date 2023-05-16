package com.hngy.service;

import com.hngy.entity.User;

/**
 * @author 6-126
 * @date 2023/4/29 18:41
 */
public interface UserService {
    boolean addUser(User user);

    User login(String username, String password);

    void editUserInfo(String username, String edu, String work, String phone, String email);

    void editPassword(String username, String password);
}
