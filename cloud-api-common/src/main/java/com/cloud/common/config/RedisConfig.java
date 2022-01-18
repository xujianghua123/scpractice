package com.cloud.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/8 19:50
 */
@Configuration
public class RedisConfig {

    @Bean
    public Jedis redisConnection(){
        return new Jedis("42.192.6.87", 6379);
    }
}
