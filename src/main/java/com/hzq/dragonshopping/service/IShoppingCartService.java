package com.hzq.dragonshopping.service;

import com.hzq.dragonshopping.entity.ProduceEntity;
import com.hzq.dragonshopping.entity.ProduceShoppingCartEntity;
import com.hzq.dragonshopping.entity.ShoppingCartEntity;

import java.util.List;
import java.util.Map;

public interface IShoppingCartService {

    /**
     * 获取用户购物车所有商品信息
     * @param uid
     * @return
     */
    List<ProduceShoppingCartEntity> getAllShopingCart(int uid);

    /**
     * 检查商品是否还有库存
     * @param produceEntity
     * @return
     */
    ProduceEntity checkProduceCount(ProduceEntity produceEntity);

    /**
     * 增加购物车
     * @param shoppingCartEntity
     */
    Map<String,Object> addShoppingCart(ShoppingCartEntity shoppingCartEntity);

}
