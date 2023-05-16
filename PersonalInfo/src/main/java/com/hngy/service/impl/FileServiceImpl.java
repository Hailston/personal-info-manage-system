package com.hngy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hngy.entity.Date;
import com.hngy.entity.File;
import com.hngy.mapper.FileMapper;
import com.hngy.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author 6-126
 * @date 2023/5/3 01:53
 */
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileMapper fileMapper;

    @Override
    public void addFile(File file) {
        fileMapper.insertOne(file);
    }

    @Override
    public PageInfo<File> page(String username, Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<File> fileList = fileMapper.listAll(username);
        PageInfo<File> pageInfo = new PageInfo<>(fileList);
        return pageInfo;
    }

    @Override
    public int deleteFile(String username, String title) {
        return fileMapper.deleteOne(username, title);
    }

    @Override
    public File getFile(String username, String title) {
        return fileMapper.selectOne(username, title);
    }
}
