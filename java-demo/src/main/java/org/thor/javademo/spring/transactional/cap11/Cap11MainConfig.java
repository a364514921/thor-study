package org.thor.javademo.spring.transactional.cap11;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-24 13:03
 * @Version: V1.0
 */
@Configuration
@ComponentScan("com.wyq.studyjava.spring.transactional.cap11")
@EnableTransactionManagement
public class Cap11MainConfig {

    /**
     * 创建数据源
     *
     * @return
     * @throws PropertyVetoException
     */
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        return dataSource;
    }

    /**
     * 能简化增删改查操作
     *
     * @return
     * @throws Exception
     */
    @Bean
    public JdbcTemplate jdbcTemplate() throws Exception {
        // Spring对@Configuration类会特殊处理；给容器中加组件的方法，多次调用都只是从容器中找组件
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    /**
     * 注册事物管理器
     * @return
     * @throws PropertyVetoException
     */
    @Bean
    public PlatformTransactionManager platformTransactionManager() throws PropertyVetoException {
        // 需要加入数据源dataSource()，管理数据源，才控制数据源的每一链接，连接的提交、回滚都是由数据源操作的
        return new DataSourceTransactionManager(dataSource());
    }
}
