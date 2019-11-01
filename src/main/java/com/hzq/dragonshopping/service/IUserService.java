package com.hzq.dragonshopping.service;

import com.hzq.dragonshopping.entity.ProduceEntity;
import com.hzq.dragonshopping.entity.UserEntity;

import java.util.Map;

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

    /**
     * 购买商品
     * @param produceEntity
     * @return
     */
    Map<String,Object> payProduce(ProduceEntity produceEntity,UserEntity userEntity);
}
