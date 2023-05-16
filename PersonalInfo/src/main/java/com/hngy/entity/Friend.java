package com.hngy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 6-126
 * @date 2023/4/30 14:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend {
    private String username;
    private String name;
    private String phone;
    private String email;
    private String workplace;
    private String place;
    private String QQ;
}
