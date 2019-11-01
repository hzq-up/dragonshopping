package com.hzq.dragonshopping;

import com.hzq.dragonshopping.controller.IndexController;
import com.hzq.dragonshopping.entity.ProduceEntity;
import com.hzq.dragonshopping.entity.UserEntity;
import com.hzq.dragonshopping.mapper.UserMapper;
import com.hzq.dragonshopping.service.IUserService;
import com.hzq.dragonshopping.service.UserServiceImpl;
import com.hzq.dragonshopping.untils.JedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DragonshoppingApplication.class)
public class DragonshoppingApplicationTests {
	private final Logger logger = LoggerFactory.getLogger(IndexController.class);
	@Resource
	private UserMapper userMapper;
	@Autowired
	private IUserService userService;
	@Resource
	private JedisUtils jedisUtils;

	/**
	 * 检查支付方法
	 */
	@Test
	public void userM() {
		UserEntity userEntity = new UserEntity();
		userEntity.setUser_id(1);
		ProduceEntity produceEntity = new ProduceEntity();
		produceEntity.setProduce_id(1);
		produceEntity.setProduce_count(1);
		produceEntity.setProduce_price(100.0);
		logger.info("code========"+userService.payProduce(produceEntity,userEntity).get("code").toString());
//		UserEntity userEntity1 = userMapper.selectComparedUserBalanceById(userEntity);
//		logger.info(userEntity1.toString());
	}
	@Test
	public void testRedis(){
		Map<String,String> userH = new HashMap<>();
		userH.put("name","hzq");
		userH.put("age","10");
		System.out.println(jedisUtils.hmset("user:001",userH));
		System.out.println(jedisUtils.hmget("user:001","name","age"));
	}

}
