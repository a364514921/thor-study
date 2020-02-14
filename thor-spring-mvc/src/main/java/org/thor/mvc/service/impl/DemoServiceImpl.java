package org.thor.mvc.service.impl;

import org.thor.mvc.annotation.ThorService;
import org.thor.mvc.service.DemoService;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-31 下午3:30
 * @Version: V1.0
 */
@ThorService("demoServiceImpl")
public class DemoServiceImpl implements DemoService {

    @Override
    public void insert() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public String query(String name, String age) {
        return "用户信息：name = " + name + ", age = " + age;
    }
}
