package com.hngy.mapper;

import com.hngy.entity.Friend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 6-126
 * @date 2023/4/30 14:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springMVC.xml")
public class FriendMapperTest {
    @Autowired
    private FriendMapper friendMapper;

    @Test
    public void testInsertOne(){
        Friend friend = new Friend();
        friend.setUsername("admin");
        friend.setName("王五");
        friend.setPhone("17711111111");
        friend.setEmail("test@qq.com");
        friend.setWorkplace("test");
        friend.setPlace("北京");
        friend.setQQ("2523760784");
        friendMapper.insertOne(friend);
    }

    @Test
    public void testSelectByUsernameAndName(){
//        Friend friend1 = friendMapper.selectByUsernameAndName("admin", "王五");
//        Friend friend2 = friendMapper.selectByUsernameAndName("askd", "王五");
//        Friend friend3 = friendMapper.selectByUsernameAndName("admin", "zklc");
//        System.out.println(friend1);
//        System.out.println(friend2);
//        System.out.println(friend3);
    }

    @Test
    public void testUpdateFriendInfo(){
        Friend friend = new Friend();
        friend.setUsername("admin");
        friend.setName("王五");
        friend.setPhone("12345678901");
        friend.setEmail("wangwu@qq.com");
        friend.setWorkplace("长沙");
        friend.setPlace("湘潭");
        friend.setQQ("test");
        friendMapper.updateFriendInfo( friend);
//        Friend friend1 = friendMapper.selectByUsernameAndName("admin", "王五");
//        System.out.println(friend1);
    }
    @Test
    public void testDeleteFriendByUsernameAndName(){
        int i = friendMapper.deleteFriendByUsernameAndName("admin", "王五");
        System.out.println("受影响的行数："+i);
    }

    @Test
    public void testListAll(){
        friendMapper.listAll("admin").forEach(System.out::println);
    }
}
