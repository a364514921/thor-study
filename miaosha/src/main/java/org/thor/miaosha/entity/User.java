package org.thor.miaosha.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: 用户
 * @author: wangyiqiang
 * @date: 2020-02-12 上午7:35
 * @version: V1.0
 */
@Data
@Accessors(chain = true)
public class User {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String name;

}
