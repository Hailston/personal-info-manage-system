package com.hngy.service;

import com.github.pagehelper.PageInfo;
import com.hngy.entity.Friend;

import java.util.List;

/**
 * @author 6-126
 * @date 2023/4/30 14:41
 */
public interface FriendService {
    PageInfo<Friend> page(String username, Integer pageNum);
    int deleteFriend(String username, String name);
    void addFriend(Friend friend);

    List<Friend> listFriend(String username, String name);

    Friend getFriend(String username, String name);
    void editFriend(Friend friend);
}
