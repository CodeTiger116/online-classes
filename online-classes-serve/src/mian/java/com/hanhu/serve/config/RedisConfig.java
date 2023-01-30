package com.hanhu.serve.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.support.collections.RedisCollectionFactoryBean;


/**
 * Redis配置类
 */
@Configuration
public class RedisConfig {

    /**
     * 序列化
     * @return
     */
    @Bean
    public RedisTemplate<String ,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){//放入连接工厂
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();

        //String类型key序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //String类型value序列化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        //Hash类型key序列化
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //Hash类型value序列化
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}
