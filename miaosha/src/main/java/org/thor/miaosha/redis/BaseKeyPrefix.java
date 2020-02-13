package org.thor.miaosha.redis;

/**
 * @description: KeyPrefix抽象接口
 * @author: wangyiqiang
 * @date: 2020-02-12 下午2:28
 * @version: V1.0
 */
public abstract class BaseKeyPrefix implements KeyPrefix {

    /**
     * 过期时间
     */
    private int expireSeconds;

    /**
     * 前缀
     */
    private String prefix;

    public BaseKeyPrefix(String prefix) {
        //0代表永不过期
        this(0, prefix);
    }

    public BaseKeyPrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public int expireSeconds() {
        //默认0代表永不过期
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        StringBuffer sb = new StringBuffer(className).append(":").append(prefix).append(":");
        return sb.toString();
    }
}
