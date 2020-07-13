package com.itzhouq.actionlog.aspect;

import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson.JSON;
import com.itzhouq.actionlog.annotation.Log;
import com.itzhouq.actionlog.domain.SysLog;
import com.itzhouq.actionlog.mapper.SysLogMapper;
import com.itzhouq.actionlog.util.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Description: 为增删改查添加监控
 * @Author: itzhouq
 * @Date: 2020/7/13 14:29
 */

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Resource
    private SysLogMapper sysLogMapper;

    @Pointcut("@annotation(com.itzhouq.actionlog.annotation.Log)")
    private void pointcut() {

    }

    @After("pointcut()")
    public void insertLogSuccess(JoinPoint joinPoint) {
        addLog(joinPoint);
    }

    /**
     * 添加日志的逻辑
     * @param joinPoint 织入点
     */
    private void addLog(JoinPoint joinPoint) {
        Log.LOG_TYPE type = getType(joinPoint);
        String operatePage = getOperatePage(joinPoint);
        String operationContext = getOperationContext(joinPoint);
        String level = getLevel(joinPoint);
        log.info("注解参数 ===>  type: {} -- operatePage: {} -- operationContext: {} -- level: {}", type, operatePage, operationContext, level);

        SysLog sysLog = SysLog.builder().build();
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 一些监控信息
        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            // 请求的 IP 地址
            String ip = IpUtil.getIp(request);
            sysLog.setUserIp(ip);

            // 请求的 URL
            StringBuffer requestURL = request.getRequestURL();

            // 请求的方法
            String method = request.getMethod();
            sysLog.setRequestMethod(method);
        }

        // 请求的参数
        Object[] args = joinPoint.getArgs();
        StringBuilder stringBuffer = new StringBuilder();
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                stringBuffer.append("[ 参数 ").append(i + 1).append(": ");
                Object arg = args[i];
                if (arg instanceof Model) {
                    continue;
                }
                String parameter = null;
                try {
                    parameter = JSON.toJSONString(arg);
                } catch (Exception e) {
                    continue;
                }
                stringBuffer.append(parameter);
                stringBuffer.append(']');
            }
        }
        log.info("Params ===> {}", stringBuffer.toString() );
        sysLog.setCreateTime(new Date());
        sysLog.setUserName("写死的用户名");
        sysLog.setLogId(UUID.fastUUID().toString());
        sysLog.setRequestDesc("写死的请求描述");
        sysLogMapper.insert(sysLog);

    }


    /**
     * 获取 curd 的操作类型
     * @param joinPoint 织入点
     * @return 操作页面类型
     */
    private Log.LOG_TYPE getType(JoinPoint joinPoint) {
        return getLogAnnotation(joinPoint).type();
    }

    /**
     * 获取操作页面
     * @param joinPoint  织入点
     * @return 操作页面
     */
    private String getOperatePage(JoinPoint joinPoint) {
        return getLogAnnotation(joinPoint).operatePage();
    }

    /**
     * 获取操作内容
     * @param joinPoint 织入点
     * @return 操作内容
     */
    private String getOperationContext(JoinPoint joinPoint) {
        return getLogAnnotation(joinPoint).operateContent();
    }

    /**
     * 获取组织层次
     * @param joinPoint 织入点
     * @return 组织层级
     */
    private String getLevel(JoinPoint joinPoint) {
        return getLogAnnotation(joinPoint).level();
    }

    /**
     * 获取注解
     * @param joinPoint 织入点
     * @return 注解 Log
     */
    private Log getLogAnnotation(JoinPoint joinPoint) {
        MethodSignature methodName = (MethodSignature) joinPoint.getSignature();
        return methodName.getMethod().getAnnotation(Log.class);
    }
}
