package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement//开启事务管理
//@MapperScan("com.example.demo.dao")//与dao层的@Mapper二选一写上即可(主要作用是扫包)
@ComponentScan(basePackages={"com.example.demo"})
public class SpringbootMavenSsmWebappApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootMavenSsmWebappApplication.class, args);
	}

}

