package org.thor.miaosha.common;

import lombok.Data;

/**
 * @description: 返回结果类
 * @author: wangyiqiang
 * @date: 2020-02-12 上午6:48
 * @version: V1.0
 */
@Data
public class Result<T> {
    /**
     * 返回码
     */
    private int code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 时间戳
     */
    private long timestamp;

    public Result() {
        this.code = 0;
        this.msg = "success";
        this.data = null;
        this.success = true;
        this.timestamp = System.currentTimeMillis();
    }

    public Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
        this.success = true;
        this.timestamp = System.currentTimeMillis();
    }

    private Result(CodeMsg cm) {
        if (cm == null) {
            return;
        }
        this.code = cm.getCode();
        this.msg = cm.getMsg();
        this.success = false;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 成功时候的调用
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    /**
     * 成功时候的调用
     */
    public static <T> Result<T> success() {
        return new Result<T>();
    }

    /**
     * 失败时候的调用
     */
    public static <T> Result<T> error(CodeMsg cm) {
        return new Result<T>(cm);
    }
}
