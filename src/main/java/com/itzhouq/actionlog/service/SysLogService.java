package com.itzhouq.actionlog.service;

import com.itzhouq.actionlog.domain.SysLog;
import com.itzhouq.actionlog.mapper.SysLogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Description: 日志记录的 service
 * @Author: zhouquan
 * @Date: 2020/7/12 19:43
 */
@Service
public class SysLogService {


    @Resource
    private SysLogMapper sysLogMapper;


    /**
     * 保存日志
     * @param sysLog 日志对象
     */
    public void saveLog(SysLog sysLog) {
        sysLog.setLogId(UUID.randomUUID().toString());
        sysLogMapper.insert(sysLog);
    }
}
