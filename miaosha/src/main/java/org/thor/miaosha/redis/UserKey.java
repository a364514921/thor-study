package org.thor.miaosha.redis;

/**
 * @description: 用户KEY
 * @author: wangyiqiang
 * @date: 2020-02-12 下午2:32
 * @version: V1.0
 */
public class UserKey extends BaseKeyPrefix {
    public UserKey(String prefix) {
        super(prefix);
    }

    public UserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");
}
