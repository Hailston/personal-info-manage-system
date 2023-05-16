package com.hngy.service;

import com.github.pagehelper.PageInfo;
import com.hngy.entity.Date;
import com.hngy.entity.Friend;

import java.util.List;

/**
 * @author 6-126
 * @date 2023/5/2 21:52
 */
public interface DateService {
    PageInfo<Date> page(String username, Integer pageNum);
    int deleteDate(String username, String date);
    void addDate(Date date);
    int editDate(Date date);
}
