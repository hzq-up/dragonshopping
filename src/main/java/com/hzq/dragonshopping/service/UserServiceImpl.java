package com.hzq.dragonshopping.service;

import com.hzq.dragonshopping.mapper.UserMapper;
import com.hzq.dragonshopping.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity login(UserEntity userEntity) {
        return userMapper.selectByUnamePwdType(userEntity);
    }

    @Transactional
    @Override
    public int regist(UserEntity userEntity) {
        return userMapper.insertUser(userEntity);
    }
}
