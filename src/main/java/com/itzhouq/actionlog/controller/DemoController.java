package com.itzhouq.actionlog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: zhouquan
 * @Date: 2020/7/11 15:27
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("test")
    public String demo() {
        return "demo";
    }
}
