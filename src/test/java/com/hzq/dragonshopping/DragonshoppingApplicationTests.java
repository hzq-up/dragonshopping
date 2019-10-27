package com.hzq.dragonshopping;

import com.hzq.dragonshopping.entity.UserEntity;
import com.hzq.dragonshopping.mapper.UserMapper;
import com.hzq.dragonshopping.untils.JedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DragonshoppingApplicationTests {
	@Resource
	private UserMapper userMapper;
	@Resource
	private JedisUtils jedisUtils;

	@Test
	public void contextLoads() {
		UserEntity userEntity = new UserEntity();
		userEntity.setUser_name("admin");
		userEntity.setUser_password("password");
		System.out.println(userMapper.selectByUnamePwdType(userEntity).getUser_id());
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
