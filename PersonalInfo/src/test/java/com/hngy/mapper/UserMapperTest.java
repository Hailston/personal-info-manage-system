package com.hngy.mapper;

import com.hngy.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 6-126
 * @date 2023/4/28 16:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springMVC.xml")
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        user.setName("test");
        user.setSex("t");
        user.setBirth("test");
        user.setNation("test");
        user.setWork("test");
        user.setPhone("test");
        user.setPlace("test");
        user.setEmail("test");
        userMapper.insertOne(user);
    }
    @Test
    public void testSelect(){
        System.out.println(userMapper.selectByUsernameAndPassword("admin", "admin2"));
    }
}
