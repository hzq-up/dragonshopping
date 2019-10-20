package com.hzq.dragonshopping.service;

import com.hzq.dragonshopping.entity.ProduceEntity;
import com.hzq.dragonshopping.entity.ProduceShoppingCartEntity;
import com.hzq.dragonshopping.entity.ShoppingCartEntity;
import com.hzq.dragonshopping.mapper.ProduceMapper;
import com.hzq.dragonshopping.mapper.ShoppingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ShoppingCart")
public class ShoppingCartServiceImpl implements IShoppingCartService{

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Autowired
    private ProduceMapper produceMapper;

    @Override
    public List<ProduceShoppingCartEntity> getAllShopingCart(int uid) {
        return shoppingCartMapper.selectAllShoppingCartByUid(uid);
    }

    @Override
    public ProduceEntity checkProduceCount(ProduceEntity produceEntity) {
        return produceMapper.selectProduceCount(produceEntity);
    }

    @Transactional
    @Override
    public Map<String, Object> addShoppingCart(ShoppingCartEntity shoppingCartEntity) {
        Map<String,Object> map = new HashMap<>();
        ProduceEntity produceEntity = new ProduceEntity();
        produceEntity.setProduce_id(shoppingCartEntity.getProduce_id());
        produceEntity.setProduce_count(shoppingCartEntity.getCart_produce_count());
        if (checkProduceCount(produceEntity)!=null) {
            //判断该商品是否在购物车
            if (shoppingCartMapper.selectShoppingCartProduceCountByUidAndPid(shoppingCartEntity)!=null) {
                ShoppingCartEntity shoppingCartEntity1 = new ShoppingCartEntity();
                //用户id
                shoppingCartEntity1.setProduce_id(shoppingCartEntity.getProduce_id());
                //商品id
                shoppingCartEntity1.setUser_id(shoppingCartEntity.getUser_id());
                //购物车更新的商品数量
                shoppingCartEntity1.setCart_produce_count(shoppingCartEntity.getCart_produce_count() + shoppingCartMapper.selectShoppingCartProduceCountByUidAndPid(shoppingCartEntity).getCart_produce_count());
                //增加购物车商品数量
                int result = shoppingCartMapper.updateShoppingCartProduceCount(shoppingCartEntity1);

                //减少商品库存
                ProduceEntity produceEntity1 = new ProduceEntity();
                produceEntity1.setProduce_id(shoppingCartEntity.getProduce_id());
                produceEntity1.setProduce_count(produceMapper.selectProduceCountByPid(produceEntity1).getProduce_count());
                //获取商品库存数量和商品id
                //更新库存数量
                produceEntity1.setProduce_count(produceEntity1.getProduce_count() - shoppingCartEntity.getCart_produce_count());
                int result2 = produceMapper.updateProduceProduce_count(produceEntity1);
                if (result + result2 >= 2) {
                    map.put("codemsg","1");
                    System.out.println("添加成功,code="+1);
                } else {
                    map.put("codemsg", "0");
                    System.out.println("添加失败,code="+0);
                }
            } else {
                int res = shoppingCartMapper.insertShoppingCart(shoppingCartEntity);
                if(res>0){
                    map.put("codemsg","1");
                    System.out.println("添加成功,code="+1);
                }else {
                    map.put("codemsg", "0");
                    System.out.println("添加失败,code="+0);
                }
//                System.out.println("补充插入语句");
            }
        }else {
            map.put("codemsg","2");
            System.out.println("库存不足,code"+2);
        }
        return map;
    }
}
