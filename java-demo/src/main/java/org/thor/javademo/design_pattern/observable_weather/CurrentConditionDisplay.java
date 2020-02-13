package org.thor.javademo.design_pattern.observable_weather;

/**
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.observable_weather
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2019-04-01 下午7:50
 * 系统版本：1.0.0
 **/

public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temp;
    private float humidity;
    private Subject WeatherData;

    public CurrentConditionDisplay(Subject weatherData) {
        WeatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions:" + temp + "F degrees and " + humidity + "% humidity");
    }
}
