package org.thor.javademo.spring.transactional.cap11.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-26 下午12:18
 * @Version: V1.0
 */
@Repository
public class OrderDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert() {
        String sql = "INSERT INTO `order` (order_time,order_money,order_status) VALUES (?,?,?)";
        jdbcTemplate.update(sql, new Date(), 20, 0);
    }
}
