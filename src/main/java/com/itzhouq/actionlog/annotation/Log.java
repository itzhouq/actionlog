package com.itzhouq.actionlog.annotation;

import java.lang.annotation.*;

/**
 * @Description: 自定义记录系统日志的注解
 * @Author: itzhouq
 * @Date: 2020/7/13 14:19
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface Log {

    public enum LOG_TYPE {ADD, UPDATE, DELETE, SELECT}

    ;

    /**
     * 类型 curd
     */
    LOG_TYPE type();

    /**
     * 操作页面
     */
    String operatePage();

    /**
     * 操作内容
     */
    String operateContent();

    /**
     * 触发按钮
     */
    String triggerButton();

    /**
     * 组织层次
     */
    String level();
}
