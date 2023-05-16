package com.hngy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hngy.entity.Friend;
import com.hngy.mapper.FriendMapper;
import com.hngy.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 6-126
 * @date 2023/4/30 14:45
 */
@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    private FriendMapper friendMapper;

    @Override
    public PageInfo<Friend> page(String username, Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<Friend> friends = friendMapper.listAll(username);
        PageInfo<Friend> pageInfo = new PageInfo<>(friends);
        return pageInfo;
    }

    @Override
    public int deleteFriend(String username, String name) {
        return friendMapper.deleteFriendByUsernameAndName(username, name);
    }

    @Override
    public void addFriend(Friend friend) {
        friendMapper.insertOne(friend);
    }

    @Override
    public List<Friend> listFriend(String username, String name) {
        return friendMapper.selectByUsernameAndName(username, name);
    }


    @Override
    public void editFriend(Friend friend) {
        friendMapper.updateFriendInfo(friend);
    }

    @Override
    public Friend getFriend(String username, String name) {
        return friendMapper.selectFriend(username, name);
    }
}
