package com.hzq.dragonshopping.mapper;


import com.hzq.dragonshopping.entity.ProduceShoppingCartEntity;
import com.hzq.dragonshopping.entity.ShoppingCartEntity;

import java.util.List;

public interface ShoppingCartMapper {

    /**
     * 根据用户id查询购物车中所有商品
     * @param uid
     * @return
     */
    List<ProduceShoppingCartEntity> selectAllShoppingCartByUid(int uid);

    /**
     * 增加购物车商品
     * @param shoppingCartEntity
     * @return
     */
    int insertShoppingCart (ShoppingCartEntity shoppingCartEntity);

    /**
     * 根据用户id和商品id修改该商品数量
     * @param shoppingCartEntity
     * @return
     */
    int updateShoppingCartProduceCount(ShoppingCartEntity shoppingCartEntity);

    /**
     * 查询用户购物车是否有该商品
     * @param shoppingCartEntity
     * @return
     */
    ShoppingCartEntity selectShoppingCartProduceCountByUidAndPid(ShoppingCartEntity shoppingCartEntity);

}
