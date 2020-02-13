package org.thor.javademo.spring.ioc.cap6;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description:自定义逻辑返回导入组件
 * @Author: wangyiqiang
 * @Date: 2020-01-23 16:11
 * @Version: V1.0
 */
public class JamesImportSelector implements ImportSelector {

    /**
     * 返回值就是导入到容器中组件的全类名
     *
     * @param importingClassMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"com.wyq.studyjava.spring.ioc.entity.Fish","com.wyq.studyjava.spring.ioc.entity.Tiger"};
    }
}
