package com.hngy.mapper;

import com.hngy.entity.Date;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 6-126
 * @date 2023/5/2 21:37
 */
public interface DateMapper {
    List<Date> listAll(@Param("username") String username);
    int insertOne(Date date);
    int updateOne(Date date);
    int deleteOne(@Param("username") String username, @Param("date") String date);
//    int selectOne(@Param("username") String username, @Param("date") String date);
}
