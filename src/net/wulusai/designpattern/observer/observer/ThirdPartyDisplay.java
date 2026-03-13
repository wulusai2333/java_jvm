package net.wulusai.designpattern.observer.observer;


import net.wulusai.designpattern.observer.subject.Subject;

/**
 * 显示基于观
 * 测值的其他内容
 */
public class ThirdPartyDisplay implements Observer, DisplayElement {
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
