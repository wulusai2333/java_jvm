package net.wulusai.designpattern.observer.observer;


import net.wulusai.designpattern.observer.subject.Subject;

/**
 * 显示最小、
 * 平均和最大的观测值
 */
public class StatisticsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;
    @Override
    public void update(float temperature, float humidity, float pressure) {

    }

    @Override
    public void display() {

    }
}
