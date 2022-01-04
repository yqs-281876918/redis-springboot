package com.yqs.redis;

import com.yqs.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Test
    void contextLoads()
    {
//        int n=1000;
//        System.out.println("n^0.01="+Math.pow(n,0.01));
//        System.out.println("log(n)^100="+Math.pow(Math.log(n),100));
        redisTemplate.execute(new RedisCallback() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                connection.flushDb();
                return "ok";
            }
        });
        redisTemplate.opsForValue().set("user",new User("yqs",21));
        System.out.println(redisTemplate.opsForValue().get("user"));
        redisTemplate.opsForValue().set("age",21);
        System.out.println(redisTemplate.opsForValue().get("age"));
        redisTemplate.opsForList().leftPush("list1",5);
        redisTemplate.opsForList().leftPush("list1",10);
        System.out.println(redisTemplate.opsForList().range("list1",0,-1));
    }

}
