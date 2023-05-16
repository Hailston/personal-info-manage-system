package com.hngy.mapper;

import com.hngy.entity.File;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 6-126
 * @date 2023/5/3 01:12
 */
public interface FileMapper {
    List<File> listAll(@Param("username") String username);
    File selectOne(@Param("username") String username, @Param("title") String title);
    int insertOne(File file);
    int deleteOne(@Param("username") String username, @Param("title") String title);
}
