package com.hngy.mapper;

import com.hngy.entity.Friend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 6-126
 * @date 2023/4/30 14:10
 */
public interface FriendMapper {
    int insertOne(Friend friend);
    List<Friend> selectByUsernameAndName(@Param("username") String username, @Param("name") String name);
    int updateFriendInfo(Friend friend);

    int deleteFriendByUsernameAndName(@Param("username") String username, @Param("name") String name);

    List<Friend> listAll(@Param("username") String username);

    Friend selectFriend(@Param("username") String username, @Param("name") String name);
}
