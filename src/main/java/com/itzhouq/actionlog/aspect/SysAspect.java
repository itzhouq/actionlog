package com.itzhouq.actionlog.aspect;

import cn.hutool.system.SystemUtil;
import com.itzhouq.actionlog.annotation.Operation;
import com.itzhouq.actionlog.domain.SysLog;
import com.itzhouq.actionlog.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * @Description: 切面类
 * @Author: zhouquan
 * @Date: 2020/7/12 10:12
 */

@Component
@Aspect
public class SysAspect {

    @Resource
    private SysLogService sysLogService;

    /**
     * 定义切点 @Pointcut
     * 在注解的位置切入代码
     */
    @Pointcut("@annotation(com.itzhouq.actionlog.annotation.Operation)")
    public void logPointcut() {

    }

    @AfterReturning("logPointcut()")
    public void saveSysLog(JoinPoint joinPoint) {

        // 保存日志
        SysLog sysLog = SysLog.builder().build();
        // 从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取切入点所在的方法
        Method method = signature.getMethod();

        // 获取操作
        Operation operation = method.getAnnotation(Operation.class);
        if (operation != null) {
            String value = operation.value();
            // 保存获取的操作
            sysLog.setRequestDesc(value);
        }

        // 获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        // 获取请求的方法
        String methodName = method.getName();

        // 注入 Syslog 对象
        sysLog.setUserName("Jack");

        // 获取 IP 地址
        sysLog.setUserIp(SystemUtil.getHostInfo().getAddress());
        sysLog.setRequestMethod(className + "." + methodName);

         // 保存到数据库
        sysLogService.saveLog(sysLog);
    }


}
