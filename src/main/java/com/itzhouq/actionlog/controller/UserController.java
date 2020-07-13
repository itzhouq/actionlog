package com.itzhouq.actionlog.controller;

import com.itzhouq.actionlog.annotation.Operation;
import com.itzhouq.actionlog.domain.User;
import com.itzhouq.actionlog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: zhouquan
 * @Date: 2020/7/12 21:40
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @Operation("删除用户")
    @PostMapping("/deleteUserById")
    public void deleteUserById(User user) {
        userService.deleteUserById(user);
        log.info("delete User success.");
    }
}
