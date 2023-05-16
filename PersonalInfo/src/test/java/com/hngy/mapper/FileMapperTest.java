package com.hngy.mapper;

import com.hngy.entity.File;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 6-126
 * @date 2023/5/3 01:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springMVC.xml")
public class FileMapperTest {
    @Autowired
    private FileMapper fileMapper;
    @Test
    public void testInsertOne(){
        File file = new File();
        file.setUsername("admin");
        file.setTitle("test");
        file.setName("test");
        file.setContentType("test");
        file.setSize("test");
        file.setFilePath("test");
        fileMapper.insertOne(file);
    }

    @Test
    public void testSelectOne(){
        File file = fileMapper.selectOne("admin", "test");
        System.out.println(file);
    }

    @Test
    public void testListAll(){
        fileMapper.listAll("admin").forEach(System.out::println);
    }

    @Test
    public void testDeleteOne(){
        int i = fileMapper.deleteOne("admin", "test");
        System.out.println(i);
    }
}
