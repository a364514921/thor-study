package org.thor.miaosha.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: wangyiqiang
 * @date: 2020-02-12 下午12:30
 * @version: V1.0
 */
@Component
@ConfigurationProperties(prefix = "redis")
@Data
public class RedisProperties {

    /**
     * 主机名
     */
    private String host;

    /**
     * 端口号
     */
    private int port;

    /**
     * 超时时间 - 秒
     */
    private int timeout;

    /**
     * 密码
     */
    private String password;

    /**
     * 最大连接数号
     */
    private int poolMaxTotal;

    /**
     * 最大空闲数
     */
    private int poolMaxIdle;

    /**
     * 最长等待时间 - 秒
     */
    private int poolMaxWait;
}
