package com.itzhouq.actionlog.service;

import com.itzhouq.actionlog.domain.User;
import com.itzhouq.actionlog.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: 用户操作 service
 * @Author: itzhouq
 * @Date: 2020/7/12 21:41
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public void deleteUserById(User user) {
        int delete = userMapper.deleteByPrimaryKey(user.getId());
    }

    /**
     * 通过 ID 查询用户
     * @param userId 用户ID
     * @return 用户
     */
    public User selectUserById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
