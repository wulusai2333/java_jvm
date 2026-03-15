package net.wulusai.designpattern.observer;

import net.wulusai.designpattern.observer.observer.CurrentConditionsDisplay;
import net.wulusai.designpattern.observer.subject.WeatherData;

/**
 * 观察者模式为：它定义了一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖它的对象都会自动得到通知并更新，从而实现松耦合的通信。
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        // Simulate some weather data changes
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);


    }
}
