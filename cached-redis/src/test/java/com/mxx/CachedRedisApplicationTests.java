package com.mxx;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class CachedRedisApplicationTests {
    @Autowired
    @Qualifier("redisTemplete")
    private RedisTemplate redisTemplate;
    @Test
    void contextLoads() {
        redisTemplate.opsForHash().put("student","name","lisi");
        System.out.println(redisTemplate.opsForHash().values("student"));
    }

}
