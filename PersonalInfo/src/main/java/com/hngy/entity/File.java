package com.hngy.entity;

import lombok.Data;

/**
 * @author 6-126
 * @date 2023/5/3 01:04
 */
@Data
public class File {
    private String username;
    private String title;
    private String name;
    private String contentType;
    private String size;
    private String filePath;
}
