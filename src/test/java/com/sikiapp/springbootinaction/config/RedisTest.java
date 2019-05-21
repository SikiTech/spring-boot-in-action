package com.sikiapp.springbootinaction.config;

import com.sikiapp.springbootinaction.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    private static final Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTeplate;

    @Test
    public void get() {
        stringRedisTemplate.opsForValue().set("kk", "1");
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        IntStream.range(0, 1).forEach(i ->
                executorService.execute(() -> stringRedisTemplate.opsForValue().increment("kk", 1))
        );
        String kk = stringRedisTemplate.opsForValue().get("kk");
        logger.info("[多线程操作结果]", kk);
        stringRedisTemplate.opsForValue().set("k1", "v1");
        String k1 = stringRedisTemplate.opsForValue().get("k1");
        logger.info("[字符缓存结果] - [{}]", k1);

        String key = "user:1";
        redisCacheTeplate.opsForValue().set(key, new User("Robert", "男", 28));
        User user = (User)redisCacheTeplate.opsForValue().get(key);
        logger.info("[对象缓存结果] - [{}]", user);
    }

}