package com.hngy.mapper;

import com.hngy.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 6-126
 * @date 2023/4/28 16:49
 */
public interface UserMapper {
    List<User> listAll();
    int insertOne(User user);

    User selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    void updateUserInfo(@Param("username") String username,
                        @Param("edu") String edu,
                        @Param("work") String work,
                        @Param("phone") String phone,
                        @Param("email") String email);

    void updatePassword(@Param("username") String username,
                        @Param("password") String password);
}
