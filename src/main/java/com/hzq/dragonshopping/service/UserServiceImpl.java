package com.hzq.dragonshopping.service;

import com.hzq.dragonshopping.controller.IndexController;
import com.hzq.dragonshopping.entity.ProduceEntity;
import com.hzq.dragonshopping.mapper.ProduceMapper;
import com.hzq.dragonshopping.mapper.UserMapper;
import com.hzq.dragonshopping.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service("UserService")
public class UserServiceImpl implements IUserService {

    private final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IShoppingCartService shoppingCartService;
    @Autowired
    private ProduceMapper produceMapper;

    @Override
    public UserEntity login(UserEntity userEntity) {
        return userMapper.selectByUnamePwdType(userEntity);
    }

    @Transactional
    @Override
    public int regist(UserEntity userEntity) {
        return userMapper.insertUser(userEntity);
    }

    @Transactional
    @Override
    public Map<String, Object> payProduce(ProduceEntity produceEntity,UserEntity userEntity) {
        Map<String,Object> map = new HashMap<>();
        //判断库存是否够用shoppingCartService.checkProduceCount(produceEntity)!=null
        if(shoppingCartService.checkProduceCount(produceEntity)!= null){
            //总价格
            double totlePrice = produceEntity.getProduce_price()*produceEntity.getProduce_count();
            userEntity.setUser_money(totlePrice);
            //判断余额是否够用
            if(userMapper.selectComparedUserBalanceById(userEntity) != null){
                //进行购买操作
                //更新用户余额
                double newBalance = userMapper.selectComparedUserBalanceById(userEntity).getUser_money() - totlePrice;
                userEntity.setUser_money(newBalance);
                int result = userMapper.updateUserMoneyByUid(userEntity);
                //更新商品库存
                int newProduce_count = produceMapper.selectProduceCount(produceEntity).getProduce_count() - produceEntity.getProduce_count();
                produceEntity.setProduce_count(newProduce_count);
                int result2 = produceMapper.updateProduceProduce_count(produceEntity);
                if(result + result2 >= 2){
                    map.put("msgcode","1");
                    logger.info("code+msg"+"1支付成功");
                }else {
                    map.put("msgcode","0");
                    logger.info("code+msg"+"0支付失败");
                }
            }else {
                map.put("msgcode","00");
                logger.info("code+msg"+"00余额不足");
            }
        }else {
            map.put("msgcode","000");
            logger.info("code+msg"+"000库存不足");
        }
        return map;
    }
}
