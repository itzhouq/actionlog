package com.itzhouq.actionlog.mapper;

import com.itzhouq.actionlog.domain.SysLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: zhouquan
 * @Date: 2020/7/12 19:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysLogMapperTest {

    @Resource
    private SysLogMapper sysLogMapper;

    @Test
    public void selectAll() {
        List<SysLog> sysLogList = sysLogMapper.selectAll();
        System.out.println(sysLogList);
    }

    @Test
    public void insert() {
        SysLog sysLog = SysLog.builder().logId(UUID.randomUUID().toString())
                .userName("444")
                .userIp("82.21.34.224")
                .requestMethod("GET")
                .requestDesc("de444sc").build();
        int insert = sysLogMapper.insert(sysLog);
        System.out.println(insert);
    }
}