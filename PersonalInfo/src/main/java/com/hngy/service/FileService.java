package com.hngy.service;


import com.github.pagehelper.PageInfo;

import com.hngy.entity.File;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 6-126
 * @date 2023/5/3 01:42
 */
public interface FileService {

    void addFile(File file);

    PageInfo<File> page(String username, Integer pageNum);

    int deleteFile(String username, String title);

    File getFile(String username, String title);
}
