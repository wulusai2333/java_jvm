package net.wulusai.designpattern.observer.subject;

import net.wulusai.designpattern.observer.observer.Observer;

import java.util.ArrayList;


/**
 * 天气数据
 */
public class WeatherData implements Subject{
    /**
     * 观察者列表
     */
    private ArrayList<Observer> observers;
    /**
     * 温度
     */
    private float temperature;
    /**
     * 湿度
     */
    private float humidity;
    /**
     * 气压
     */
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }


    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }
    /**
     * 天气数据改变
     */
    public void measurementsChanged() {
        notifyObservers();
    }

    /**
     * 观察者更新
     */
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    /**
     * 设置天气数据
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public float getTemperature() {
        return temperature;
    }
}
