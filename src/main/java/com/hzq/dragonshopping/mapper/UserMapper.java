package com.hzq.dragonshopping.mapper;

import com.hzq.dragonshopping.entity.UserEntity;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    /**
     * 登录查询
     * @param user
     * @return
     */
    public UserEntity selectByUnamePwdType(UserEntity user);

    /**
     * 注册插入
     * @param user
     * @return
     */
    public int insertUser(UserEntity user);

    /**
     * 查询余额是否够用
     * @param userEntity
     * @return
     */
    public UserEntity selectComparedUserBalanceById(UserEntity userEntity);

    /**
     * 更新用户余额
     * @param userEntity
     * @return
     */
    public int updateUserMoneyByUid(UserEntity userEntity);
}
