package com.hngy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 6-126
 * @date 2023/4/28 15:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;
    private String password;
    private String name;
    private String sex;
    private String birth;
    private String nation;
    private String edu;
    private String work;
    private String phone;
    private String place;
    private String email;
}
