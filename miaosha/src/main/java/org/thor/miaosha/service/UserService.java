package org.thor.miaosha.service;

import org.thor.miaosha.entity.User;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-02-12 上午7:39
 * @Version: V1.0
 */
public interface UserService {

    User getById(Integer id);

    int insert();
}
