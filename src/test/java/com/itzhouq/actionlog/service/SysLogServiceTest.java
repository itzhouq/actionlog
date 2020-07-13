package com.itzhouq.actionlog.service;

import com.itzhouq.actionlog.domain.SysLog;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.IOException;
import java.net.URL;
import java.util.Date;

/**
 * @Description: 测试 service 保存日志的方法
 * @Author: itzhouq
 * @Date: 2020/7/12 19:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SysLogServiceTest {

    @Autowired
    private SysLogService sysLogService;

    @Test
    public void saveLog() {
        SysLog sysLog = SysLog.builder()
                .userName("分工会尽快了")
                .userIp("78.42.45.2")
                .requestMethod("GET")
                .requestDesc("描述www")
                .createTime(new Date())
                .build();

        sysLogService.saveLog(sysLog);
    }

    @Test
    public void test() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        String url = "http://localhost:8899/demo/test";
        String data = "data";
        //构建一个请求对象
        Request request = new Request.Builder().url(url).addHeader(data, "sdfghjkl").build();
        String method = request.method();
        URL url1 = request.url();
        HttpUrl httpUrl = request.httpUrl();
        log.info("method: {}, url: {}, httpUrl: {}" , method, url1, httpUrl);
        //发送请求
        Response response = okHttpClient.newCall(request).execute();
        String body = response.body().string();
        String message = response.message();
        boolean successful = response.isSuccessful();

        log.info("body: {}, message: {}, isSuccess: {} ", body, message, successful);
    }
}