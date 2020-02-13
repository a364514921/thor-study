package org.thor.javademo.spring.bean;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-24 12:14
 * @Version: V1.0
 */
@ToString
@Component
public class Sun {
    private Moon moon;

    public Moon getMoon() {
        return moon;
    }

    /**
     * @param moon
     * @Autowired 可以再任何方法上，当@Autowired标注在方法上：Spring容器穿件当前对象时，就会调用方法，完成赋值
     * 方法使用的参数，自定义类型的值从IOC容器中取数，方法里的moon会从容器中拿到
     */
//    @Autowired
    public void setMoon(Moon moon) {
        this.moon = moon;
    }

    @Autowired
    public Sun( Moon moon) {
        this.moon = moon;
    }

//    public Sun(@Autowired Moon moon) {
//        this.moon = moon;
//    }
}
