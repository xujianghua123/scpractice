package com.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.sharding.mapper")
@SpringBootApplication
public class ShardingJDBCApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJDBCApplication.class,args);
    }
}
