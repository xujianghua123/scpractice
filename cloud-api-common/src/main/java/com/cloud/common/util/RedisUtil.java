package com.cloud.common.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/24 10:46
 */
@Component
public class RedisUtil {

    @Resource
    private RedisTemplate redisTemplate;


}
