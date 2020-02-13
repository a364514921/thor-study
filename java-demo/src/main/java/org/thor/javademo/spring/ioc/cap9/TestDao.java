package org.thor.javademo.spring.ioc.cap9;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-24 10:42
 * @Version: V1.0
 */
@Repository
@Data
public class TestDao {
    private String flag = "1";
}
