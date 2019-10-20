package com.hzq.dragonshopping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
@MapperScan("com.hzq.dragonshopping.mapper")
public class DragonshoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DragonshoppingApplication.class, args);
	}

}
