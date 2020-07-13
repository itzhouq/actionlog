package com.itzhouq.actionlog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan("com.itzhouq.actionlog.mapper")
public class ActionlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActionlogApplication.class, args);
    }

}
