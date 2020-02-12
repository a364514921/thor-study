package org.thor.miaosha.redis;

public interface KeyPrefix {

    /**
     * 过期时间 - 秒
     *
     * @return
     */
    public int expireSeconds();

    /**
     * 获取前缀
     *
     * @return
     */
    public String getPrefix();

}
