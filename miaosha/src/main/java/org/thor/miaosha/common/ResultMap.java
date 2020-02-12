package org.thor.miaosha.common;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 返回结果类
 * @author: wangyiqiang
 * @date: 2020-02-12 上午6:48
 * @version: V1.0
 */
public class ResultMap extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public ResultMap() {
        super.put("success", true);
        super.put("code", 0);
        super.put("message", "操作成功！");
        super.put("timestamp", System.currentTimeMillis());
    }

    public static ResultMap error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
    }

    public static ResultMap error500(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static ResultMap error(int code, String msg) {
        ResultMap r = new ResultMap();
        r.put("code", code);
        r.put("message", msg);
        r.put("success", false);
        return r;
    }

    public static ResultMap ok() {
        return new ResultMap();
    }

    public static ResultMap ok(String msg) {
        ResultMap r = new ResultMap();
        r.put("message", msg);
        return r;
    }

    public static ResultMap okResult(Object result) {
        ResultMap r = new ResultMap();
        r.put("result", result);
        return r;
    }

    public static ResultMap ok(Map<String, Object> map) {
        ResultMap r = new ResultMap();
        r.putAll(map);
        return r;
    }

    @Override
    public ResultMap put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
