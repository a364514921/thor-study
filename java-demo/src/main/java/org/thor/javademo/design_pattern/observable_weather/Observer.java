package org.thor.javademo.design_pattern.observable_weather;

/**
 * ${DESCRIPTION}
 * 模块名称：StudyJava.com.wyq.studyjava.design_pattern.observable_weather
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2019-04-01 下午7:26
 * 系统版本：1.0.0
 **/
public interface Observer {
    void update(float temp, float humidity, float pressure);
}
