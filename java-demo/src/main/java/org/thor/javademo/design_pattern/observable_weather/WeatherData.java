package org.thor.javademo.design_pattern.observable_weather;

import java.util.ArrayList;
import java.util.List;

/**
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.observable_weather
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2019-04-01 下午7:42
 * 系统版本：1.0.0
 **/

public class WeatherData implements Subject {
    private List<Observer> observers;
    private float temp;
    private float humidity;
    private float pressure;


    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temp, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
