package org.thor.miaosha.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thor.miaosha.properties.RedisProperties;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @description:
 * @author: wangyiqiang
 * @date: 2020-02-12 下午1:32
 * @version: V1.0
 */
@Configuration
public class RedisPoolFactory {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisProperties.getPoolMaxIdle());
        poolConfig.setMaxTotal(redisProperties.getPoolMaxTotal());
        poolConfig.setMaxWaitMillis(redisProperties.getPoolMaxWait());

        JedisPool jedisPool = new JedisPool(poolConfig, redisProperties.getHost(), redisProperties.getPort(),
                redisProperties.getTimeout() * 1000, redisProperties.getPassword(), 0);
        return jedisPool;
    }
}
