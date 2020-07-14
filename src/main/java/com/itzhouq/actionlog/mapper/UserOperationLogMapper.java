package com.itzhouq.actionlog.mapper;

import com.itzhouq.actionlog.domain.UserOperationLog;

public interface UserOperationLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserOperationLog record);

    int insertSelective(UserOperationLog record);

    UserOperationLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserOperationLog record);

    int updateByPrimaryKey(UserOperationLog record);
}