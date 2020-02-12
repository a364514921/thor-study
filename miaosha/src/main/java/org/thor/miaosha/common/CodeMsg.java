package org.thor.miaosha.common;

import lombok.Data;

/**
 * @description: 返回码和返回信息
 * @author: wangyiqiang
 * @date: 2020-02-12 上午6:49
 * @version: V1.0
 */
@Data
public class CodeMsg {
    /**
     * 返回码
     */
    private int code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 通用异常
     */
    public static CodeMsg COMMON = new CodeMsg(500, "服务端异常");

    /**
     * 登录模块
     */
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "登录模块异常");

    //商品模块 5002XX

    //订单模块 5003XX

    //秒杀模块 5004XX

    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
