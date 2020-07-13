package com.itzhouq.actionlog.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
//@NoArgsConstructor
public class SysLog {
    /**
     *
     */
    private String logId;

    /**
     *
     */
    private String userName;

    /**
     *
     */
    private String userIp;

    /**
     *
     */
    private String requestMethod;

    /**
     *
     */
    private String requestDesc;

    /**
     *
     */
    private Date createTime;
}