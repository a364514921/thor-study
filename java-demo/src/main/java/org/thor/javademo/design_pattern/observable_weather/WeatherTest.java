package org.thor.javademo.design_pattern.observable_weather;

/**
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.observable_weather
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2019-04-01 下午7:57
 * 系统版本：1.0.0
 **/

public class WeatherTest {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);

        weatherData.setMeasurements(80,65,70);
    }
}
