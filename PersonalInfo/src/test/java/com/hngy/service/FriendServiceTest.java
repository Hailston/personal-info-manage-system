package com.hngy.service;

import com.hngy.entity.Friend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 6-126
 * @date 2023/4/30 14:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springMVC.xml")
public class FriendServiceTest {
    @Autowired
    private FriendService friendService;
    @Test
    public void testPage(){
        System.out.println(friendService.page("admin", 1));
    }
}
