package com.itzhouq.actionlog.mapper;

import com.itzhouq.actionlog.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: zhouquan
 * @Date: 2020/7/12 20:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void selectAll() {
        List<User> users = userMapper.selectAll();
        System.out.println(users);
    }
}