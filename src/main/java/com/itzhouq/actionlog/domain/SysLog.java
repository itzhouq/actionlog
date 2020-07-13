package com.itzhouq.actionlog.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class SysLog {
    /**
     * ID
     */
    private String logId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户 IP 地址
     */
    private String userIp;

    /**
     * 请求方法
     */
    private String requestMethod;

    /**
     * 请求描述
     */
    private String requestDesc;

    /**
     * 创建时间
     */
    private Date createTime;
}