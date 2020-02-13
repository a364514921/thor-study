package org.thor.javademo.spring.ioc.cap9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-24 10:42
 * @Version: V1.0
 */
@Service
public class TestService {

    // 指定加载testDao
//    @Qualifier("testDao")
//    @Resource(name = "testDao") // 与@Qualifier类似，但不支持@Primary注解和required = false功能
//    @Autowired(required = false)
//    @Inject
    @Autowired
    private TestDao testDao;

    public void println() {
        System.out.println("service...testDao..." + testDao);
    }
}
