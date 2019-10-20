package com.hzq.dragonshopping.service;

import com.hzq.dragonshopping.entity.UserEntity;

public interface IUserService {

    /**
     * 登录
     * @param userEntity
     * @return
     */
    UserEntity login(UserEntity userEntity);

    /**
     * 注册
     * @param userEntity
     * @return
     */
    int regist(UserEntity userEntity);
}
