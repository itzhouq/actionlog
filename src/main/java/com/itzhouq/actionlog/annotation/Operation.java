package com.itzhouq.actionlog.annotation;

import java.lang.annotation.*;

/**
 * @Description: 自定义记录日志的注解
 * @Author: zhouquan
 * @Date: 2020/7/12 10:07
 */


@Target({ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Operation {
    String value() default "";
}
