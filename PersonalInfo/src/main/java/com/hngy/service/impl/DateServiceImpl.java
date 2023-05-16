package com.hngy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hngy.entity.Date;
import com.hngy.entity.Friend;
import com.hngy.mapper.DateMapper;
import com.hngy.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 6-126
 * @date 2023/5/2 21:53
 */
@Service
public class DateServiceImpl implements DateService {
    @Autowired
    private DateMapper dateMapper;

    @Override
    public PageInfo<Date> page(String username, Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<Date> dateList = dateMapper.listAll(username);
        PageInfo<Date> pageInfo = new PageInfo<>(dateList);
        return pageInfo;
    }

    @Override
    public int deleteDate(String username, String date) {
        return dateMapper.deleteOne(username, date);
    }

    @Override
    public void addDate(Date date) {
        dateMapper.insertOne(date);
    }

    @Override
    public int editDate(Date date) {
        return dateMapper.updateOne(date);
    }
}
