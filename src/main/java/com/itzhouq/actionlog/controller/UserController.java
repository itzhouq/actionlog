package com.itzhouq.actionlog.controller;

import com.itzhouq.actionlog.annotation.Log;
import com.itzhouq.actionlog.domain.User;
import com.itzhouq.actionlog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: itzhouq
 * @Date: 2020/7/12 21:40
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/deleteUserById")
    public void deleteUserById(User user) {
        userService.deleteUserById(user);
        log.info("delete User success.");
    }

    /**
     * 通过 ID 查询用户
     * @param userId 用户 ID
     * @return 用户
     */
    @Log(type = Log.LOG_TYPE.SELECT, operatePage = "用户管理", operateContent = "查询用户", triggerButton = "查询按钮", level = "2")
    @GetMapping("/selectUserById/{userId}")
    public User selectUserById(@PathVariable("userId") Long userId) {
        return userService.selectUserById(userId);
    }
}
