package org.thor.mvc.service;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-31 下午3:30
 * @Version: V1.0
 */
public interface DemoService {

    /**
     * 增
     */
    public void insert();

    /**
     * 删
     */
    public void delete();

    /**
     * 改
     */
    public void update();

    /**
     * 查
     *
     * @param name 姓名
     * @param age  年龄
     * @return
     */
    public String query(String name, String age);
}
