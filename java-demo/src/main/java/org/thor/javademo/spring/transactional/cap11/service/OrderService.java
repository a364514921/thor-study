package org.thor.javademo.spring.transactional.cap11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thor.javademo.spring.transactional.cap11.dao.OrderDao;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-26 下午12:23
 * @Version: V1.0
 */
@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    @Transactional
    public void addOrder() {
        orderDao.insert();
        System.out.println("insert 操作完成...");

//        int a = 1 / 0;
    }
}
