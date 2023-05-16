package com.hngy.mapper;

import com.hngy.entity.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 6-126
 * @date 2023/5/2 21:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springMVC.xml")
public class DateMapperTest {
    @Autowired
    private DateMapper dateMapper;

    @Test
    public void testInsertOne(){
        Date date = new Date();
        date.setUsername("admin");
        date.setDate("2023-5-4");
        date.setThing("..............！");
        int one = dateMapper.insertOne(date);
        System.out.println(one);
    }
    @Test
    public void testUpdateOne(){
        Date date = new Date();
        date.setUsername("admin");
        date.setDate("2023-5-4");
        date.setThing("..............！");
        int one = dateMapper.updateOne(date);
        System.out.println(one);
    }
    @Test
    public void testListAll(){
        dateMapper.listAll("admin").forEach(System.out::println);
    }
    @Test
    public void testDeleteOne(){
        int one = dateMapper.deleteOne("admin", "2023-5-4");
        System.out.println(one);
    }
}
